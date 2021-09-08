package src.loader;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

import src.entity.Articulo;
import src.entity.Oferta;

@SessionScoped
public class OfertasLoader extends AbstractProductLoader<Oferta, Articulo> implements Serializable {


	@Override
	public void bindToParentEntity(Articulo parent_entity) {
		for(Oferta of : getList()) {
			of.setArticulo(parent_entity);
		}		
	}

}
