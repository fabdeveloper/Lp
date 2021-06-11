package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

public class EtiquetasDaoExcel extends AbstractDaoExcel<Etiqueta> {

	@Override
	public Etiqueta rowToEntity(Row row) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostConstruct
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
