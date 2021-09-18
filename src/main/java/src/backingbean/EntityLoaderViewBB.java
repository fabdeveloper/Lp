package src.backingbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import EShop.entityservices.dao.entityloader.loader.IEntityLoader;
import EShop.entityservices.dao.entityloader.loader.IProductLoaderFacade;
import src.entity.Articulo;
import src.entity.Oferta;
import src.entity.Product;
import src.util.Column;

@Named
@SessionScoped
public class EntityLoaderViewBB implements Serializable {
	
	@Inject
	private IProductLoaderFacade loaderFacade;
	
	
//	private List<Product> listaProductos;
//	private List<Articulo> listaArticulos;
//	private List<Oferta> listaOfertas;
	
	private List<Column> listaColumnasProducto;
	private List<Column> listaColumnasArticulo;
	private List<Column> listaColumnasOferta;

	
//	private String productFileName;
//	private String articulosFileName;
//	private String ofertasFileName;
//	
//	private Product productSelected;
//	private Articulo articuloSelected;
//	private Oferta ofertaSelected;
//	
//	private Product productParentSelected;
//	private Articulo articuloParentSelected;
	
//	private String productSheetName;
//	private String articuloSheetName;
//	private String ofertaSheetName;
	
	
	
	
	
	public String productSelectListener() {
		System.out.println("productSelectListener() - " + new Date() +  "\n" + "producto seleccionado = " + getProductSelected());
		return null;
	}
	
	public String articuloSelectListener() {
		System.out.println("articuloSelectListener() - " + new Date() +  "\n" + "articulo seleccionado = " + getArticuloSelected());

		return null;
	}
	
	public String ofertaSelectListener() {
		System.out.println("ofertaSelectListener() - " + new Date() +  "\n" + "oferta seleccionado = " + getOfertaSelected());

		return null;
	}
	
	public String actionLoadFileProduct() {
		getLoaderFacade().loadProductFromFile();
		return null;
	}
	
	public String actionLoadFileArticulo() {
		getLoaderFacade().loadArticulosFromFile();
		return null;
	}
	
	public String actionLoadFileOferta() {
		getLoaderFacade().loadOfertasFromFile();
		return null;
	}
	
	public Boolean actionloadfileProductDisabled() {
		return false;
	}
	
	public Boolean actionloadfileArticuloDisabled() {
		return false;
	}
	
	public Boolean actionloadfileOfertaDisabled() {
		return false;
	}
	
//	public Boolean inputProductparentselectedDisabled() {
//		return null;
//	}
//	
//	public Boolean inputArticuloparentselectedDisabled() {
//		return null;
//	}
	
	public String actionbindtoparentProduct() {
		getLoaderFacade().bindArticulosListToParentProduct();
		return null;
	}
	
	public String actionbindtoparentArticulo() {
		getLoaderFacade().bindOfertasListToParentArticulo();
		return null;
	}
	
	public Boolean actionbindtoparentProductDisabled() {
		return false;
	}
	
	public Boolean actionbindtoparentArticuloDisabled() {
		return false;
	}
	
	@Transactional
	public String actioncreateallProduct() {
		getLoaderFacade().createProducts();
		return null;
	}
	
	@Transactional
	public String actioncreateallArticulo() {
		getLoaderFacade().createArticulos();
		return null;
	}
	
	@Transactional
	public String actioncreateallOferta() {
		getLoaderFacade().createOfertas();
		return null;
	}
	
	public Boolean actioncreateallProductDisabled() {
		return false;
	}
	
	public Boolean actioncreateallArticuloDisabled() {
		return false;
	}
	
	public Boolean actioncreateallOfertaDisabled() {
		return false;
	}
	
	
	
	/*******************************************************************
	 * 
	 * GETTERS AND SETTERS
	 * 
	 */

	public IProductLoaderFacade getLoaderFacade() {
		return loaderFacade;
	}

	public void setLoaderFacade(IProductLoaderFacade loaderFacade) {
		this.loaderFacade = loaderFacade;
	}
	
	// LISTAS

	public List<Product> getListaProductos() {
		return getLoaderFacade().getProductLoader().getList();
	}

	public void setListaProductos(List<Product> listaProductos) {
		getLoaderFacade().getProductLoader().setList(listaProductos);
	}

	public List<Articulo> getListaArticulos() {
		return getLoaderFacade().getArticuloLoader().getList();
	}

	public void setListaArticulos(List<Articulo> listaArticulos) {
		getLoaderFacade().getArticuloLoader().setList(listaArticulos);
	}

	public List<Oferta> getListaOfertas() {
		return getLoaderFacade().getOfertaLoader().getList();
	}

	public void setListaOfertas(List<Oferta> listaOfertas) {
		getLoaderFacade().getOfertaLoader().setList(listaOfertas);
	}
	
	
	// FILE NAMES

	public String getProductFileName() {  // productFileName
		return getLoaderFacade().getProductLoader().getFileName();
	}

	public void setProductFileName(String productFileName) {
		getLoaderFacade().getProductLoader().setFileName(productFileName);
	}

	public String getArticulosFileName() {
		return getLoaderFacade().getArticuloLoader().getFileName();
	}

	public void setArticulosFileName(String articulosFileName) {
		getLoaderFacade().getArticuloLoader().setFileName(articulosFileName);
	}

	public String getOfertasFileName() {
		return getLoaderFacade().getOfertaFileName();
	}

	public void setOfertasFileName(String ofertasFileName) {
		getLoaderFacade().setOfertaFileName(ofertasFileName);
	}
	
	
	// ENTITY SELECTED

	public Product getProductSelected() {
		return getLoaderFacade().getSelectedProduct();
	}

	public void setProductSelected(Product productSelected) {
		getLoaderFacade().setSelectedProduct(productSelected);
	}

	public Articulo getArticuloSelected() {
		return getLoaderFacade().getSelectedArticulo();
	}

	public void setArticuloSelected(Articulo articuloSelected) {
		getLoaderFacade().setSelectedArticulo(articuloSelected);
	}

	public Oferta getOfertaSelected() {
		return getLoaderFacade().getSelectedOferta();
	}

	public void setOfertaSelected(Oferta ofertaSelected) {
		getLoaderFacade().setSelectedOferta(ofertaSelected);
	}
	
	
	/************************************************
	 * 
	 * PROPIO
	 */



	public List<Column> getListaColumnasProducto() {
		if(listaColumnasProducto == null) {
			listaColumnasProducto = new ArrayList<Column>();
					listaColumnasProducto.add(new Column("ID", "id"));
					listaColumnasProducto.add(new Column("NAME", "name"));
					listaColumnasProducto.add(new Column("TYPE", "type"));
					listaColumnasProducto.add(new Column("URL IMAGE", "urlImage"));

					

		}
		return listaColumnasProducto;
	}

	public void setListaColumnasProducto(List<Column> listaColumnasProducto) {
		this.listaColumnasProducto = listaColumnasProducto;
	}

	public List<Column> getListaColumnasArticulo() {
		if(listaColumnasArticulo == null) {
			listaColumnasArticulo = new ArrayList<Column>();
			listaColumnasArticulo.add(new Column("ID", "id"));
			listaColumnasArticulo.add(new Column("NAME", "name"));
			listaColumnasArticulo.add(new Column("DESCRIPCION", "descripcion"));
			listaColumnasArticulo.add(new Column("PRICE", "price"));
			listaColumnasArticulo.add(new Column("PRODUCT_ID", "product"));


		}
		return listaColumnasArticulo;
	}

	public void setListaColumnasArticulo(List<Column> listaColumnasArticulo) {
		this.listaColumnasArticulo = listaColumnasArticulo;
	}

	public List<Column> getListaColumnasOferta() {
		if(listaColumnasOferta == null) {
			listaColumnasOferta = new ArrayList<Column>();
			listaColumnasOferta.add(new Column("ID", "id"));
			listaColumnasOferta.add(new Column("NAME", "name"));
			listaColumnasOferta.add(new Column("PRECIO", "precio"));
			listaColumnasOferta.add(new Column("STOCK", "stock"));
			listaColumnasOferta.add(new Column("ARTICULO_ID", "articulo"));


		}
		return listaColumnasOferta;
	}

	public void setListaColumnasOferta(List<Column> listaColumnasOferta) {
		this.listaColumnasOferta = listaColumnasOferta;
	}


	
	// SHEET NAME
	
	public String getProductSheetName() {
		return getLoaderFacade().getProductSheetName();
	}

	public void setProductSheetName(String productSheetName) {
		getLoaderFacade().setProductSheetName(productSheetName);
	}

	public String getArticuloSheetName() {
		return getLoaderFacade().getArticuloSheetName();
	}

	public void setArticuloSheetName(String articuloSheetName) {
		getLoaderFacade().setArticuloSheetName(articuloSheetName);
	}

	public String getOfertaSheetName() {
		return getLoaderFacade().getOfertaSheetName();
	}

	public void setOfertaSheetName(String ofertaSheetName) {
		getLoaderFacade().setOfertaSheetName(ofertaSheetName);
	}
	
	
	/******************************************/




	
	public void loadProductFromDB() {
		getLoaderFacade().loadProductFromDB();		
	}

	
	public void loadArticulosFromDB() {
		getLoaderFacade().loadArticulosFromDB();		
	}

	
	public void loadOfertasFromDB() {
		getLoaderFacade().loadOfertasFromDB();		
	}




}
