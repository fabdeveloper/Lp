package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.PurchaseStatus;

public class PurchaseStatusDaoExcel extends AbstractDaoExcel<PurchaseStatus> {

	@Override
	public PurchaseStatus rowToEntity(Row row) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostConstruct
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
