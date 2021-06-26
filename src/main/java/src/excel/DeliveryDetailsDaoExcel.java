package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.DeliveryDetails;
import src.entity.Product;

public class DeliveryDetailsDaoExcel extends AbstractDaoExcel<DeliveryDetails> {
	
//	public DeliveryDetailsDaoExcel() {
//		super(DeliveryDetails.class);
//	}

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
