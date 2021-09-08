package src.excel;

import java.util.List;

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
	
	public void setFileName(String fileName);
	public String getFileName();
	public void loadFile(); // xml file to Workbook object
	public void createList(); // Workbook object to List<Entity>
	public void persistList(); // TODO: eliminar esto - List<Entity> to BD
	public void setList(List<E> list);
	public List<E> getList();

	
	public Workbook getWorkbook();
	public Sheet getSheet();
	
	public void setSheetName(String sheet_name);
	public String getSheetName();
	

	public IServiceLocator getServiceLocator(); // EntityServices
	public void setServiceLocator(IServiceLocator serviceLocator);
	public EntityManager getEntityManager();
	
	public IEntityServices<E> getEntityServices();
	public void setEntityServices(IEntityServices<E> entityServices);


}
