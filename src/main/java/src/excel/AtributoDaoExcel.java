package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Atributo;
import src.entity.Product;

public class AtributoDaoExcel extends AbstractDaoExcel<Atributo> {
	
//	public AtributoDaoExcel() {
//		super(Atributo.class);
//	}

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
