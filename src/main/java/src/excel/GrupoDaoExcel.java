package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Grupo;

public class GrupoDaoExcel extends AbstractDaoExcel<Grupo> {

	@Override
	public Grupo rowToEntity(Row row) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostConstruct
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
