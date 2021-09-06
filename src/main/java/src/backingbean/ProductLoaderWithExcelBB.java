package src.backingbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;

import src.entity.Articulo;
import src.entity.Oferta;
import src.entity.Product;
import src.inter.IServiceLocator;

@Named
@SessionScoped
public class ProductLoaderWithExcelBB implements Serializable {
	

	private static final long serialVersionUID = 106L;

	@Inject
	private IServiceLocator serviceLocator;
	
//	private String fileLocation = "NO_INICIADO";

	private String fileLocation = "C:/Users/fabo_/OneDrive/Escritorio/rs3db.xls";
	
	private List<Product> productList;
	private List<Articulo> articuloList;
	private List<Oferta> ofertaList;
	
	private Workbook workbook;
	private Sheet productSheet;
	private Sheet articuloSheet;
	private Sheet ofertaSheet;
	
	private final String CADENA_PRODUCT = "products"; 
	private final String CADENA_ARTICULO = "articulos"; 
	private final String CADENA_OFERTA = "ofertas"; 

	
	public String refreshModel() {		
		createFacesMsg("fileLocation = " + fileLocation);
		return "";
	}
	
	public void createFacesMsg(String msg) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
	}
	
	public String loadExcelFile() throws IOException {
		FileInputStream file = new FileInputStream(new File(fileLocation));
		workbook = new HSSFWorkbook(file);
		createFacesMsg("Loaded file: " + fileLocation);
		return "";		
	}
	
	public String createProductList() throws IOException {		
		
		productSheet = workbook.getSheet(CADENA_PRODUCT);
		productList = new ArrayList<Product>();
		Product prod;
		for(Row row : productSheet) {
			prod = serviceLocator.getProductServices().getTransferObject();
	
//			prod.setId(Integer.getInteger(row.getCell(0).getRichStringCellValue().getString()));
			prod.setName(row.getCell(1).getRichStringCellValue().getString());
			prod.setType(row.getCell(2).getRichStringCellValue().getString());
			prod.setUrlImage(row.getCell(3).getRichStringCellValue().getString());
			
			productList.add(prod);			
		}	
		createFacesMsg("created product list");			
		return "";		
	}
	
	public String createArticuloList() {
		articuloSheet = workbook.getSheet(CADENA_ARTICULO); 
		articuloList = new ArrayList<Articulo>();
		Articulo art;
		Product prod;
		Date hoy = new Date();
		DataFormatter formatter = new DataFormatter();
		int counter = 0;
		for(Row row : articuloSheet) {
			try {
				art = serviceLocator.getArticuloServices().getTransferObject();
				
				art.setDescripcion(formatter.formatCellValue(row.getCell(1)));
				art.setName(formatter.formatCellValue(row.getCell(2)));
				art.setPrice(Float.valueOf(formatter.formatCellValue(row.getCell(3))));
				art.setUrlImage(formatter.formatCellValue(row.getCell(4)));
				
				prod = serviceLocator.getProductServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(5))));
				art.setProduct(prod);
				art.setCreationDate(hoy);
				
				articuloList.add(art);
				counter++;
				
			}catch(Throwable t) {
				String msg = "skiped row : " + row.getRowNum();
				System.out.println(msg);
				createFacesMsg(msg);
				createFacesMsg(t.getMessage());
			}

		}
		createFacesMsg("created articulo list - registros= " + counter);	
		return "";		
	}
	
	public String createOfertaList() {
		ofertaSheet = workbook.getSheet(CADENA_OFERTA);
		ofertaList = new ArrayList<Oferta>();
		Oferta ofer;
		Articulo arti;
		Date hoy = new Date();
		DataFormatter formatter = new DataFormatter();
		int counter = 0;
		for(Row row : ofertaSheet) {
			try {
				ofer = serviceLocator.getOfertaServices().getTransferObject();
				
				ofer.setDescripcion(formatter.formatCellValue(row.getCell(1)));
				ofer.setName(formatter.formatCellValue(row.getCell(2)));
				ofer.setPrecio(Float.valueOf(formatter.formatCellValue(row.getCell(3))));
				ofer.setStock(Integer.valueOf(formatter.formatCellValue(row.getCell(4))));
				ofer.setUrlImage(formatter.formatCellValue(row.getCell(5)));
				ofer.setUrlImagebig(formatter.formatCellValue(row.getCell(6)));
				arti = serviceLocator.getArticuloServices().read(Integer.valueOf(formatter.formatCellValue(row.getCell(7))));
				ofer.setArticulo(arti);
				ofer.setCreationDate(hoy);
				ofer.setExpirationDate(new SimpleDateFormat("yyyy/MM/dd").parse(formatter.formatCellValue(row.getCell(9))));
				
				ofertaList.add(ofer);
				counter++;				
				
			}catch(Throwable t) {
				String msg = "skiped row : " + row.getRowNum();
				System.out.println(msg);
				createFacesMsg(msg);
				createFacesMsg(t.getMessage());
			}
		}
		createFacesMsg("created oferta list - registros= " + counter);	
		return "";	
		
	}
	
	@Transactional
	public String persistProductList() {
		
		for(Product prod : productList) {
			serviceLocator.getProductServices().persist(prod);
		}
		serviceLocator.getEntityManager().flush();
		createFacesMsg("persisted product list");
		return "";
		
	}
	
	@Transactional
	public String persistArticuloList() {
		int counter = 0;
		for(Articulo art : articuloList) {
			try {
				serviceLocator.getArticuloServices().persist(art);
				counter++;
			}catch(Throwable t) {
				String msg = "error grabando registro " + counter + ", " + t.getMessage();
				System.out.println(msg);
				createFacesMsg(msg);				
			}
		}
		serviceLocator.getEntityManager().flush();
		createFacesMsg("persisted articulo list - registros= " + counter);
		return "";
	}
	
	@Transactional
	public String persistOfertaList() {
		int counter = 0;
		for(Oferta of : ofertaList) {
			try {
				serviceLocator.getOfertaServices().persist(of);
				counter++;
			}catch(Throwable t) {
				String msg = "error grabando registro " + counter + ", " + t.getMessage();
				System.out.println(msg);
				createFacesMsg(msg);				
			}
		}
		serviceLocator.getEntityManager().flush();
		createFacesMsg("persisted oferta list - registros= " + counter);
		return "";		
		
		
	}

	public IServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(IServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Articulo> getArticuloList() {
		return articuloList;
	}

	public void setArticuloList(List<Articulo> articuloList) {
		this.articuloList = articuloList;
	}

	public List<Oferta> getOfertaList() {
		return ofertaList;
	}

	public void setOfertaList(List<Oferta> ofertaList) {
		this.ofertaList = ofertaList;
	}

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public Sheet getProductSheet() {
		return productSheet;
	}

	public void setProductSheet(Sheet productSheet) {
		this.productSheet = productSheet;
	}

	public Sheet getArticuloSheet() {
		return articuloSheet;
	}

	public void setArticuloSheet(Sheet articuloSheet) {
		this.articuloSheet = articuloSheet;
	}

	public Sheet getOfertaSheet() {
		return ofertaSheet;
	}

	public void setOfertaSheet(Sheet ofertaSheet) {
		this.ofertaSheet = ofertaSheet;
	}

	public String getCADENA_PRODUCT() {
		return CADENA_PRODUCT;
	}

	public String getCADENA_ARTICULO() {
		return CADENA_ARTICULO;
	}

	public String getCADENA_OFERTA() {
		return CADENA_OFERTA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

	

}
