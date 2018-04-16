package ua.springboot.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ua.springboot.web.entity.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long>{

}
