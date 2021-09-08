package src.loader;

import java.util.List;

import javax.inject.Inject;

import src.entityservices.IEntityServices;
import src.excel.IDaoExcel;

public abstract class AbstractProductLoader<E, P> implements IProductLoader<E, P> {
	
	@Inject
	private IDaoExcel<E> conversorXLS;
	
	@Inject
	private IEntityServices<E> entityServices;

	@Override
	public void loadFromXLSFile() {
 		getConversor().createList();
	}

	@Override
	public void loadFromDB() {
		getConversor().setList(getEntityServices().readAll());
	}

	@Override
	public IEntityServices<E> getEntityServices() {
		return entityServices;
	}

	@Override
	public IDaoExcel<E> getConversor() {
		return conversorXLS;
	}


	@Override
	public void setFileName(String fname) {
		getConversor().setFileName(fname);
	}

	@Override
	public String getFileName() {
		return getConversor().getFileName();
	}

	@Override
	public void setSheetName(String sheet_name) {
		getConversor().setSheetName(sheet_name);
		
	}


	@Override
	public List<E> getList() {
		return getConversor().getList();
	}

	@Override
	public void persistListToDB() {
		IEntityServices<E> entityServices = getEntityServices();
		List<E> listaEntidades = getList();
		
		for(E entity : listaEntidades) {
			entityServices.persist(entity);
		}		
	}
	
	

}
