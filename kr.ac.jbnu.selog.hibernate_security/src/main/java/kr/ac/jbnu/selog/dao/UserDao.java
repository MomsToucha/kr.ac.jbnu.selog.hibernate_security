package kr.ac.jbnu.selog.dao;

import java.util.List;

import kr.ac.jbnu.selog.model.User;


public interface UserDao {

	User findById(int id);
	
	User findBySSO(String sso);
	
	void save(User user);
	
	void deleteBySSO(String sso);
	
	List<User> findAllUsers();

}

