package src.excel;

import java.util.Date;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Articulo;
import src.entity.Product;

@RequestScoped
public class ArticuloDaoExel extends AbstractDaoExcel<Articulo> {
	
	
	public ArticuloDaoExel() {
		setFileName("C:\\Users\\fabo_\\OneDrive\\Escritorio\\productLoad.xls");
		setSheetName("articulos");
	}

	@Override
	public Articulo rowToEntity(Row row) {
		Articulo art = null;
		DataFormatter formatter = new DataFormatter();

				art = getServiceLocator().getArticuloServices().getTransferObject();
				
				art.setDescripcion(formatter.formatCellValue(row.getCell(1)));
				art.setName(formatter.formatCellValue(row.getCell(2)));
				art.setPrice(Float.valueOf(formatter.formatCellValue(row.getCell(3))));
				art.setUrlImage(formatter.formatCellValue(row.getCell(4)));
				
				Product prod = getServiceLocator().getProductServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(5))));
				art.setProduct(prod);
				art.setCreationDate(new Date());		
		
		return art;
	}

}
