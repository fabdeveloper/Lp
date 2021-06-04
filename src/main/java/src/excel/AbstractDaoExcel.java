package src.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import src.entity.Oferta;
import src.entityservices.IEntityServices;
import src.inter.IServiceLocator;

public abstract class AbstractDaoExcel<E> implements IDaoExcel {
	
//	private Class<E> entityClass;

	@Inject
	private IEntityServices<E> entityServices;
	
	@Inject
	private IServiceLocator serviceLocator;
	
	
	private List<E> list;	
	private String sheetName;
	private String fileName;

	private Workbook workbook;
	private Sheet sheet;
	
	
//	public AbstractDaoExcel(Class<E> entityClass){
//		this.entityClass = entityClass;
//	}
	
	
	
	@Override
	public void loadFile() {

			FileInputStream file;
			try {
				file = new FileInputStream(new File(fileName));				
				workbook = new HSSFWorkbook(file);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Loaded file: " + fileName));
				
			} catch (FileNotFoundException e) {				
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	@Override
	public void createList() {
		loadFile();
		List<E> listaTemporal = new ArrayList<E>();
		sheet = workbook.getSheet(sheetName);
		Iterator<Row> it = sheet.iterator();
		E newentity = null;
		while(it.hasNext()) {			
			try {
				newentity = rowToEntity(it.next());
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("row con problemas :   " + e.getMessage()));
			}	
			if(newentity != null)
			listaTemporal.add(newentity);
		}
		setList(listaTemporal); 
	}

	public abstract E rowToEntity(Row row);


	@Override
	public void persistList() {
		IEntityServices<E> es = getEntityServices();
		for(E e : getList()) {
			es.create(e);
		}	
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("listSize =  " + getList().size()));

	}
	@Override
	public Workbook getWorkbook() {
		if(workbook == null) {
			loadFile();
		}
		return workbook;
	}
	@Override
	public Sheet getSheet() {

		return sheet;
	}
	@Override
	public void setSheetName(String sheet_name) {
		sheetName = sheet_name;		
	}
	public List<E> getList() {
		if(list == null) {
			createList();
		}
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}
	public void setSheet(Sheet sheet) {
		this.sheet = sheet;
	}

//	public Class<E> getEntityClass() {
//		return entityClass;
//	}
//	public void setEntityClass(Class<E> entityClass) {
//		this.entityClass = entityClass;
//	}

	public IEntityServices<E> getEntityServices() {
		return entityServices;
	}

	public void setEntityServices(IEntityServices<E> entityServices) {
		this.entityServices = entityServices;
	}

	@Override
	public IServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(IServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	
	
	
	

}
