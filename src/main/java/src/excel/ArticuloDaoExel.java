package src.excel;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Articulo;
import src.entity.Product;
import src.exception.RS3Exception;

@RequestScoped
public class ArticuloDaoExel extends AbstractDaoExcel<Articulo> {
	

	@Override
	public Articulo rowToEntity(Row row) {
		Articulo art = getServiceLocator().getArticuloServices().getTransferObject();
		DataFormatter formatter = new DataFormatter();
		try {
//			art.setId((int)row.getCell(0).getNumericCellValue());
			art.setName(formatter.formatCellValue(row.getCell(1)));
			art.setDescripcion(formatter.formatCellValue(row.getCell(2)));
			art.setPrice(Float.valueOf(formatter.formatCellValue(row.getCell(3))));
			art.setUrlImage(formatter.formatCellValue(row.getCell(4)));
			
			Product prod = getServiceLocator().getProductServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(5))));
			art.setProduct(prod);
			art.setCreationDate(new Date());
			
		}catch(Throwable t) {
			String msg = "ArticuloDaoExcel.rowToEntity() - ERROR - msg= " + t.getMessage();
			throw new RS3Exception(msg);	
		}

		
		
		return art;
	}

	@PostConstruct
	@Override
	public void init() {
		setFileName("C:\\Users\\fabo_\\OneDrive\\Escritorio\\rs3db.xls");
		setSheetName("articulos");		
	}

}
