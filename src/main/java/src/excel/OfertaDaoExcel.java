package src.excel;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Articulo;
import src.entity.Oferta;
import src.exception.RS3Exception;

@RequestScoped
public class OfertaDaoExcel extends AbstractDaoExcel<Oferta> {
	
	@PostConstruct
	@Override
	public void init() {
		setFileName("C:\\Users\\fabo_\\OneDrive\\Escritorio\\rs3db.xls");
		setSheetName("ofertas");		
	}


	@Override
	public Oferta rowToEntity(Row row) {
		
		DataFormatter formatter = new DataFormatter();
		Oferta ofer = getServiceLocator().getOfertaServices().getTransferObject();
		try {		
			ofer.setName(formatter.formatCellValue(row.getCell(1)));
			ofer.setDescripcion(formatter.formatCellValue(row.getCell(2)));
//			ofer.setPrecio(Float.valueOf(formatter.formatCellValue(row.getCell(3)))); 
			ofer.setPrecio((float)row.getCell(3).getNumericCellValue()); 
			ofer.setStock(Integer.valueOf(formatter.formatCellValue(row.getCell(4))));
			Articulo arti = getServiceLocator().getArticuloServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(5))));
			ofer.setArticulo(arti);
			ofer.setUrlImage(formatter.formatCellValue(row.getCell(6)));
			ofer.setUrlImagebig(formatter.formatCellValue(row.getCell(7)));
			try {
				ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(formatter.formatCellValue(row.getCell(8))));
			}catch(Throwable t) {
				
			}
//			String cellString = formatter.formatCellValue(row.getCell(8));			
//			if(cellString.length() > 0) { ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(cellString)); }	
			
			ofer.setCreationDate(new Date());
			
		}catch(Throwable t) {	
			String msg = "OfertaDaoExcel.rowToEntity() - ERROR - msg= " + t.getMessage();
			throw new RS3Exception(msg);			
		}
		return ofer;
	}
}