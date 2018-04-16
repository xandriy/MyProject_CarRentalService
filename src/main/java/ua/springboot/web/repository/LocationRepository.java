package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long>{

}
