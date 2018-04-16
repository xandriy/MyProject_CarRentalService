package ua.springboot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Transmission;

@Repository
public interface TransmissionRepository extends JpaRepository<Transmission, Long>{
	
	@Query("SELECT t.transmission FROM Transmission t")
	public List<String> findTransmissionString();
	
}
