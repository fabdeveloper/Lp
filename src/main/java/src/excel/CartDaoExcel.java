package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Cart;
import src.entity.Product;

public class CartDaoExcel extends AbstractDaoExcel<Cart> {
	
//	public CartDaoExcel() {
//		super(Cart.class);
//	}

	@Override
	public Cart rowToEntity(Row row) {		
		//ID-VALUE
		DataFormatter formatter = new DataFormatter();
		Cart nuevo = getServiceLocator().getCartServices().getTransferObject();
				
		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); 
		nuevo.setValue(Float.valueOf(formatter.formatCellValue(row.getCell(2)))); 
		
		return nuevo;		
	}

	@PostConstruct
	@Override
	public void init() {
		setSheetName("carts");		
	}

}
