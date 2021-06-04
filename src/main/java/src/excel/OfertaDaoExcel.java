package src.excel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import src.entity.Articulo;
import src.entity.Oferta;

@RequestScoped
public class OfertaDaoExcel extends AbstractDaoExcel<Oferta> {

//	public OfertaDaoExcel(Class<Oferta> entityClass) {
//		super(entityClass);
//	}
	
	public OfertaDaoExcel() {
		setFileName("C:\\Users\\fabo_\\OneDrive\\Escritorio\\productLoad.xls");
		setSheetName("ofertas");


	}

	@Override
	public Oferta rowToEntity(Row row) {
		
		DataFormatter formatter = new DataFormatter();

		Oferta ofer = getEntityServices().getTransferObject();
		
		
						
				ofer.setDescripcion(formatter.formatCellValue(row.getCell(1)));
				ofer.setName(formatter.formatCellValue(row.getCell(2)));
				ofer.setPrecio(Float.valueOf(formatter.formatCellValue(row.getCell(3))));
				ofer.setStock(Integer.valueOf(formatter.formatCellValue(row.getCell(4))));
				ofer.setUrlImage(formatter.formatCellValue(row.getCell(5)));
				ofer.setUrlImagebig(formatter.formatCellValue(row.getCell(6)));
				Articulo arti = getServiceLocator().getArticuloServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(7))));
				ofer.setArticulo(arti);
				ofer.setCreationDate(new Date());
				try {
					ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(formatter.formatCellValue(row.getCell(9))));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				

		
		
		
		/*
		String articulo_id = row.getCell(0).getStringCellValue();
		Articulo articulo = getServiceLocator().getArticuloServices().read(Integer.valueOf(articulo_id));
		String descripcion = row.getCell(1).getStringCellValue();
		String name = row.getCell(2).getStringCellValue();
		String precioS = row.getCell(3).getStringCellValue();
		Float precioF = Float.valueOf(precioS);
		String stockS = row.getCell(4).getStringCellValue();
		Integer stockI = Integer.valueOf(stockS);		
		String urlImage = row.getCell(0).getStringCellValue();
		String urlImageBig = row.getCell(0).getStringCellValue();
		
		
		ofertanueva.setArticulo(articulo);
		ofertanueva.setDescripcion(descripcion);
		ofertanueva.setName(name);
		ofertanueva.setPrecio(precioF);
		ofertanueva.setStock(stockI);
		ofertanueva.setUrlImage(urlImage);
		ofertanueva.setUrlImagebig(urlImageBig);
		
		DataFormatter formatter = new DataFormatter();

		ofertanueva.setCreationDate(new Date());
		try {
			ofertanueva.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(formatter.formatCellValue(row.getCell(9))));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		*/

		return ofer;
	}

}



//for(Row row : ofertaSheet) {
//	try {
//		ofer = serviceLocator.getOfertaServices().getTransferObject();
//		
//		ofer.setDescripcion(formatter.formatCellValue(row.getCell(1)));
//		ofer.setName(formatter.formatCellValue(row.getCell(2)));
//		ofer.setPrecio(Float.valueOf(formatter.formatCellValue(row.getCell(3))));
//		ofer.setStock(Integer.valueOf(formatter.formatCellValue(row.getCell(4))));
//		ofer.setUrlImage(formatter.formatCellValue(row.getCell(5)));
//		ofer.setUrlImagebig(formatter.formatCellValue(row.getCell(6)));
//		arti = serviceLocator.getArticuloServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(7))));
//		ofer.setArticulo(arti);
//		ofer.setCreationDate(hoy);
//		ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(formatter.formatCellValue(row.getCell(9))));
//		
//		ofertaList.add(ofer);
//		counter++;				
//		
//	}catch(Throwable t) {
//		String msg = "skiped row : " + row.getRowNum();
//		System.out.println(msg);
//		createFacesMsg(msg);
//		createFacesMsg(t.getMessage());
//	}
//}
