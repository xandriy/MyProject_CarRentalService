package ua.springboot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Fuel;

@Repository
public interface FuelRepository extends JpaRepository<Fuel, Long>{
	@Query("SELECT f.fuel FROM Fuel f")
	public List<String> findFuelString();
	
}
