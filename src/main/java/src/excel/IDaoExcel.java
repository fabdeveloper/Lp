package src.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import src.inter.IServiceLocator;

public interface IDaoExcel {
	
	public void loadFile();
	public void createList();
	public void persistList();
	
	public Workbook getWorkbook();
	public Sheet getSheet();
	
	public void setSheetName(String sheet_name);
	

	public IServiceLocator getServiceLocator();


}
