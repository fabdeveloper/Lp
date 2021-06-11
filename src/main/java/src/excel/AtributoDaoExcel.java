package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Atributo;

public class AtributoDaoExcel extends AbstractDaoExcel<Atributo> {

	@Override
	public Atributo rowToEntity(Row row) {
		// TODO Auto-generated method stub
		return null;
	}

	@PostConstruct
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
