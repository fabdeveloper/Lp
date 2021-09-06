package src.excel;

import javax.persistence.EntityManager;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import src.entityservices.IEntityServices;
import src.inter.IServiceLocator;

public interface IDaoExcel<E> {
	
	public abstract E rowToEntity(Row row);
//	public abstract Row entityToRow(E entity);
	public abstract void init();
	
	public void loadFile(); // xml file to Workbook object
	public void createList(); // Workbook object to List<Entity>
	public void persistList(); // List<Entity> to BD
	
	public Workbook getWorkbook();
	public Sheet getSheet();
	
	public void setSheetName(String sheet_name);
	

	public IServiceLocator getServiceLocator(); // EntityServices
	public void setServiceLocator(IServiceLocator serviceLocator);
	public EntityManager getEntityManager();
	
	public IEntityServices<E> getEntityServices();
	public void setEntityServices(IEntityServices<E> entityServices);


}
