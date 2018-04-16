package ua.springboot.web.service;

import java.util.List;

import ua.springboot.web.entity.Transmission;

public interface TransmissionService {
	
void save(Transmission transmission);
	
	Transmission findById(Long id);
	
	List<Transmission> findAll();
	
	List<String> findAllTransmission();
	
}
