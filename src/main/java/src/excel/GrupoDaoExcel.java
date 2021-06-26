package src.excel;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Grupo;

@RequestScoped
public class GrupoDaoExcel extends AbstractDaoExcel<Grupo> {
	
//	public GrupoDaoExcel() {
//		super(Grupo.class);
//	}

	@Override
	public Grupo rowToEntity(Row row) {

		DataFormatter formatter = new DataFormatter();
		Grupo nuevo = getServiceLocator().getGrupoServices().getTransferObject();
				
//		nuevo.setId(Integer.valueOf(formatter.formatCellValue(row.getCell(0)))); 
		nuevo.setName(formatter.formatCellValue(row.getCell(1))); 
		nuevo.setDescription(formatter.formatCellValue(row.getCell(2))); 
		
		return nuevo;			
	}
	
	@PostConstruct
	@Override
	public void init() {
		setFileName("C:\\Users\\fabo_\\OneDrive\\Escritorio\\rs3db.xls");
		setSheetName("grupos");		
		
	}

}
