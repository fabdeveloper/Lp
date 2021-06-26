package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.Etiqueta;
import src.entity.Product;

public class EtiquetasDaoExcel extends AbstractDaoExcel<Etiqueta> {
	
//	public EtiquetasDaoExcel() {
//		super(Etiqueta.class);
//	}

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
