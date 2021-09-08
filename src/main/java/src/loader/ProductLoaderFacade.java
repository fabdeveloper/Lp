package src.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import src.entity.Articulo;
import src.entity.Oferta;
import src.entity.Product;

@SessionScoped
public class ProductLoaderFacade implements IProductLoaderFacade, Serializable  {
	
	@Inject 
	private IProductLoader<Product, Product> productLoader;
	@Inject
	private IProductLoader<Articulo, Product> articuloLoader;
	@Inject
	private IProductLoader<Oferta, Articulo> ofertaLoader;
	
	private Product selectedProduct;
	private Articulo selectedArticulo;
	private Oferta selectedOferta;
	
	

	@Override
	public void setProductFileName(String productFileName) {
		getProductLoader().setFileName(productFileName);
	}

	@Override
	public String getProductFileName() {
		return getProductLoader().getFileName();
	}

	@Override
	public void setArticuloFileName(String articuloFileName) {
		getArticuloLoader().setFileName(articuloFileName);		
	}

	@Override
	public String getArticuloFileName() {
		return getArticuloLoader().getFileName();
	}

	@Override
	public void setOfertaFileName(String ofertaFileName) {
		getOfertaLoader().setFileName(ofertaFileName);		
	}

	@Override
	public String getOfertaFileName() {
		return getOfertaLoader().getFileName();
	}

	@Override
	public void loadProductFromFile() {
		getProductLoader().loadFromXLSFile();		
	}

	@Override
	public void loadArticulosFromFile() {
		getArticuloLoader().loadFromXLSFile();		
	}

	@Override
	public void loadOfertasFromFile() {
		getOfertaLoader().loadFromXLSFile();		
	}

	@Override
	public void bindArticulosListToParentProduct() {
		getArticuloLoader().bindToParentEntity(getSelectedProduct());		
	}

	@Override
	public void bindOfertasListToParentArticulo() {
		getOfertaLoader().bindToParentEntity(getSelectedArticulo());		
	}

	@Override
	public void createProducts() {
		getProductLoader().persistListToDB();		
	}

	@Override
	public void createArticulos() {
		getArticuloLoader().persistListToDB();		
	}

	@Override
	public void createOfertas() {
		getOfertaLoader().persistListToDB();		
	}

	@Override
	public IProductLoader<Product, Product> getProductLoader() {
		return productLoader;
	}

	@Override
	public IProductLoader<Articulo, Product> getArticuloLoader() {
		return articuloLoader;
	}

	@Override
	public IProductLoader<Oferta, Articulo> getOfertaLoader() {
		return ofertaLoader;
	}

	public void setProductLoader(IProductLoader<Product, Product> productLoader) {
		this.productLoader = productLoader;
	}

	public void setArticuloLoader(IProductLoader<Articulo, Product> articuloLoader) {
		this.articuloLoader = articuloLoader;
	}

	public void setOfertaLoader(IProductLoader<Oferta, Articulo> ofertaLoader) {
		this.ofertaLoader = ofertaLoader;
	}

	@Override
	public Product getSelectedProduct() {
		return this.selectedProduct;
	}

	@Override
	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	@Override
	public Articulo getSelectedArticulo() {
		return this.selectedArticulo;
	}

	@Override
	public void setSelectedArticulo(Articulo selectedArticulo) {
		this.selectedArticulo = selectedArticulo;
	}

	@Override
	public void setSelectedOferta(Oferta selectedOferta) {
		this.selectedOferta = selectedOferta;
	}

	@Override
	public Oferta getSelectedOferta() {
		return this.selectedOferta;
	}


}
