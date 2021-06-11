package src.excel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Product;

@RequestScoped
public class ProductDaoExcel extends AbstractDaoExcel<Product> {
	

	
	@PostConstruct
	@Override
	public void init() {
		setFileName("C:\\Users\\fabo_\\OneDrive\\Escritorio\\rs3db.ods");
		setSheetName("products");		
	}

	@Override
	public Product rowToEntity(Row row) {


			Product prod = getServiceLocator().getProductServices().getTransferObject();
	
			prod.setName(row.getCell(1).getRichStringCellValue().getString());
			prod.setTipo(row.getCell(2).getRichStringCellValue().getString());
			prod.setUrlImage(row.getCell(3).getRichStringCellValue().getString());
			
					
		return prod;
	}

}

