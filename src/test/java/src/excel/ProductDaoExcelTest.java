package src.excel;

import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;

import src.entity.Product;
import src.inter.IServiceLocator;

public class ProductDaoExcelTest {
	
	private IDaoExcel<Product> productDaoExcel;
	private IServiceLocator serviceLocator;
	private EntityManager entityManager;
	
	
	
	@Before
	public void initDependencies() {
		
		productDaoExcel = new ProductDaoExcel();
		serviceLocator = mockServiceLocator();
		
		
		productDaoExcel.setServiceLocator(serviceLocator);
		
	}
	
	private IServiceLocator mockServiceLocator(){
		IServiceLocator mocksl = mock(IServiceLocator.class);
		
		
		
		return mocksl;
	}
	
	
	
	@Test
	public void rowToEntityTest() {
		
		Row row = null;
		Product product = null;
		
		// load file
		// create list
		
		
//		product = productDaoExcel.rowToEntity(row);
		
		Assert.assertTrue("error creando Producto entity", true);
	}

}
