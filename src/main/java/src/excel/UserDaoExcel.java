package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Product;
import src.entity.User;

public class UserDaoExcel extends AbstractDaoExcel<User> {
	
//	public UserDaoExcel() {
//		super(User.class);
//	}

	@Override
	public User rowToEntity(Row row) {
		//ID	ADDRESS	EMAIL	NAME	NICK	PASS	TELEPHONE

		DataFormatter formatter = new DataFormatter();
		User nuevo = getServiceLocator().getUserServices().getTransferObject();
				
		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); 
		nuevo.setAddress(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setEmail(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setName(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setNick(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setPassword(formatter.formatCellValue(row.getCell(2))); 
		nuevo.setTelephone(formatter.formatCellValue(row.getCell(2))); 

		
		return nuevo;	
	}

	
	@PostConstruct
	@Override
	public void init() {
		setSheetName("users");		
		
	}

}
