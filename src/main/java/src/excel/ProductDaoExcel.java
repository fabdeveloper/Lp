package src.excel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Product;
import src.exception.RS3Exception;

@RequestScoped
public class ProductDaoExcel extends AbstractDaoExcel<Product> {
	

	@PostConstruct
	@Override
	public void init() {
		setFileName("C:\\Users\\fabo_\\OneDrive\\Escritorio\\rs3db.xls");
		setSheetName("products");		
	}

	@Override
	public Product rowToEntity(Row row) {
		Product prod = getServiceLocator().getProductServices().getTransferObject();
		try {				
//			prod.setId((int)row.getCell(0).getNumericCellValue());
			prod.setName(row.getCell(1).getRichStringCellValue().getString());
			prod.setType(row.getCell(2).getRichStringCellValue().getString());
			prod.setUrlImage(row.getCell(3).getRichStringCellValue().getString());			
			
		}catch(Throwable t) {	
			String msg = "ProductDaoExcel.rowToEntity() - ERROR - msg= " + t.getMessage();
			throw new RS3Exception(msg);			
		}		
//		String msg = "ProductDaoExcel.rowToEntity() - loaded from excel with entityId= " + prod.getId() + ", name= " + prod.getName();
//		publish(msg);					
		return prod;
	}

}

