package ua.springboot.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.CarMake;

@Repository
public interface CarMakeRepository extends JpaRepository<CarMake, Long>{
	@Query("SELECT m.make FROM CarMake m")
	public List<String> findCarMake();
}
