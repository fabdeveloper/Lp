package src.backingbean;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import src.entity.Articulo;
import src.entity.Oferta;
import src.entity.Product;
import src.excel.AbstractDaoExcel;

@Named
@SessionScoped
public class Loaderbb implements Serializable {
	
	@Inject 
	private AbstractDaoExcel<Product> productDaoExcel;
	@Inject 
	private AbstractDaoExcel<Articulo> articuloDaoExcel;	
	@Inject 
	private AbstractDaoExcel<Oferta> ofertaDaoExcel;
	
	
	private String cadena = "NO_INICIADO";

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}
	
	@Transactional
	public String actionTest() {
		persistOfertasList();
		
		return "";
	}
	
	public String persistProductsList() {
		getProductDaoExcel().persistList();		
		return "";
	}
	
	public String persistArticulosList() {
		getArticuloDaoExcel().persistList();
		return "";
	}
	
	public String persistOfertasList() {
		getOfertaDaoExcel().persistList();
		return "";
	}

	public AbstractDaoExcel<Product> getProductDaoExcel() {
		return productDaoExcel;
	}

	public void setProductDaoExcel(AbstractDaoExcel<Product> productDaoExcel) {
		this.productDaoExcel = productDaoExcel;
	}

	public AbstractDaoExcel<Articulo> getArticuloDaoExcel() {
		return articuloDaoExcel;
	}

	public void setArticuloDaoExcel(AbstractDaoExcel<Articulo> articuloDaoExcel) {
		this.articuloDaoExcel = articuloDaoExcel;
	}

	public AbstractDaoExcel<Oferta> getOfertaDaoExcel() {
		return ofertaDaoExcel;
	}

	public void setOfertaDaoExcel(AbstractDaoExcel<Oferta> ofertaDaoExcel) {
		this.ofertaDaoExcel = ofertaDaoExcel;
	}
	
	

}
