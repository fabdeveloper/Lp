package src.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import src.entity.Product;

@SessionScoped
public class ProductLoader extends AbstractProductLoader<Product, Product> implements Serializable{


	@Override
	public void bindToParentEntity(Product parent_entity) {
		// TODO Auto-generated method stub
		
	}

}
