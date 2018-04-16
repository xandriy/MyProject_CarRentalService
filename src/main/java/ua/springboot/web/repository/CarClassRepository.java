package ua.springboot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.CarClass;

@Repository
public interface CarClassRepository extends JpaRepository<CarClass, Long>{
	
	@Query("SELECT c.carClass FROM CarClass c")
	public List<String> findCarClassString();
	
}
