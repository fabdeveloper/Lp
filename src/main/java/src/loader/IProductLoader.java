package src.loader;

import java.util.List;

import src.entityservices.IEntityServices;
import src.excel.IDaoExcel;

public interface IProductLoader<E, P> {
	
	
	public void loadFromXLSFile();
	public void loadFromDB();
	public void persistListToDB();
	
	public IEntityServices<E> getEntityServices(); // servicios de persistencia en BD
	public IDaoExcel<E> getConversor(); // servicios de acceso a datos en XLS
	
	public void bindToParentEntity(P parent_entity);
	
	
	public void setFileName(String fname);
	public String getFileName();
	public void setSheetName(String sheet_name);
	public List<E> getList();


}
