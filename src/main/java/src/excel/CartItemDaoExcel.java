package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.CartItem;
import src.entity.Product;

public class CartItemDaoExcel extends AbstractDaoExcel<CartItem> {
	
//	public CartItemDaoExcel() {
//		super(CartItem.class);
//	}

	@Override
	public CartItem rowToEntity(Row row) {
		
		DataFormatter formatter = new DataFormatter();


		//ID-COUNTER-CART-OFERTA
		CartItem nuevo = getServiceLocator().getCartItemServices().getTransferObject();
				
		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(1)))); //row.getCell(1).getRichStringCellValue().getString());
		nuevo.setCounter(Integer.valueOf(formatter.formatCellValue(row.getCell(2)))); //row.getCell(2).getRichStringCellValue().getString());
		
//		pppppppppppppp
//		nuevo.setCart(row.getCell(3).getRichStringCellValue().getString());
//		nuevo.setOferta(row.getCell(4).getRichStringCellValue().getString());		
		
		
		return nuevo;
	}


	@PostConstruct
	@Override
	public void init() {
		setSheetName("cart_item");		

	}

}
