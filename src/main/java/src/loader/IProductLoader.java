package src.loader;

import src.entityservices.IEntityServices;
import src.excel.IDaoExcel;

public interface IProductLoader<E> {
	
	public void loadFromXLSFile();
	public void loadFromDB();
	public IEntityServices<E> getEntityServices();
	public IDaoExcel<E> getConversor();
	public void bindToParentEntity(Integer entity_id);

}
