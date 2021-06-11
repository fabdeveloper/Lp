package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.DeliveryDetails;

public class DeliveryDetailsDaoExcel extends AbstractDaoExcel<DeliveryDetails> {

	@Override
	public DeliveryDetails rowToEntity(Row row) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostConstruct
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
