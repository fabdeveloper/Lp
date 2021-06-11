package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Order;

public class OrderDaoExcel extends AbstractDaoExcel<Order> {

	@Override
	public Order rowToEntity(Row row) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostConstruct
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
