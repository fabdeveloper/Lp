package src.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import src.entity.Articulo;
import src.entity.Product;

@SessionScoped
public class ArticulosLoader extends AbstractProductLoader<Articulo, Product> implements Serializable {


	@Override
	public void bindToParentEntity(Product parent_entity) {
		for(Articulo art : getList()) {
			art.setProduct(parent_entity);
		}		
	}

}
