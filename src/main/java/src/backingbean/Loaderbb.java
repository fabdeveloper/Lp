package src.backingbean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import src.entity.Articulo;
import src.entity.Grupo;
import src.entity.Oferta;
import src.entity.Product;
import src.excel.AbstractDaoExcel;

@Named
@SessionScoped
public class Loaderbb implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject 
	private AbstractDaoExcel<Product> productDaoExcel;
	@Inject 
	private AbstractDaoExcel<Articulo> articuloDaoExcel;	
	@Inject 
	private AbstractDaoExcel<Oferta> ofertaDaoExcel;
	@Inject 
	private AbstractDaoExcel<Grupo> grupoDaoExcel;
	
	
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
	
	@Transactional
	public String persistProductsList() {
		getProductDaoExcel().persistList();		
		return "";
	}
	
	@Transactional
	public String persistArticulosList() {
		getArticuloDaoExcel().persistList();
		return "";
	}
	
	@Transactional
	public String persistOfertasList() {
		getOfertaDaoExcel().persistList();
		return "";
	}
	
	@Transactional
	public String persistGruposList() {
		getGrupoDaoExcel().persistList();
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
	

	public AbstractDaoExcel<Grupo> getGrupoDaoExcel() {
		return grupoDaoExcel;
	}

	public void setGrupoDaoExcel(AbstractDaoExcel<Grupo> grupoDaoExcel) {
		this.grupoDaoExcel = grupoDaoExcel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
