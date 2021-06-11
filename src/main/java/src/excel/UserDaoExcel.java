package src.excel;

import javax.annotation.PostConstruct;

import org.apache.poi.ss.usermodel.Row;

import src.entity.User;

public class UserDaoExcel extends AbstractDaoExcel<User> {

	@Override
	public User rowToEntity(Row row) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@PostConstruct
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

}
