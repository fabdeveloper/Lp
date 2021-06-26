package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Cart;
import src.entity.Order;
import src.entity.Product;

public class OrderDaoExcel extends AbstractDaoExcel<Order> {
	
//	public OrderDaoExcel() {
//		super(Order.class);
//	}

//	@Override
	public Order rowToEntity(Row row) {
		//ID - CONFIRMATION_DATE - CREATION_DATE - LAST_MODIFICATION_DATE - CLIENT_ID - CART_ID - DELIVERYDETAILS_ID - PURCHASESTATUS_ID

		DataFormatter formatter = new DataFormatter();
		Order nuevo = getServiceLocator().getOrderServices().getTransferObject();
				
//		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); 
//		nuevo.setConfirmationDate(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setCreationDate(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setLastModificationDate(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setClient(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setCart(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setDeliveryDetails(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
//		nuevo.setPurchaseStatus(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 

		
		return nuevo;	

		
		
	}
	
	@PostConstruct
	@Override
	public void init() {
		setSheetName("orders");		

	}

}
