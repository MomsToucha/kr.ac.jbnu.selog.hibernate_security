package kr.ac.jbnu.selog.service;

import java.util.List;

import kr.ac.jbnu.selog.model.UserProfile;


public interface UserProfileService {

	UserProfile findById(int id);

	UserProfile findByType(String type);
	
	List<UserProfile> findAll();
	
}
