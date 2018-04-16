package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.History;

public interface HisoryService {
	
	void save(History history);
	
	History findBy(Long id);
	
	List<History> findAll();
	
}
