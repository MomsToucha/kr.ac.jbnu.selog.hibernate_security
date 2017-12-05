package kr.ac.jbnu.selog.dao;

import java.util.List;

import kr.ac.jbnu.selog.model.UserProfile;


public interface UserProfileDao {

	List<UserProfile> findAll();
	
	UserProfile findByType(String type);
	
	UserProfile findById(int id);
}
