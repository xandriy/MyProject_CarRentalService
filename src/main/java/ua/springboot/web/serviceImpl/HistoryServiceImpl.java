package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.History;
import ua.springboot.web.repository.HistoryRepository;
import ua.springboot.web.service.HisoryService;

@Service
public class HistoryServiceImpl implements HisoryService{

	@Autowired
	private HistoryRepository historyRepository;
	
	@Override
	public void save(History history) {
		historyRepository.save(history);
	}

	@Override
	public History findBy(Long id) {
		return historyRepository.findOne(id);
	}

	@Override
	public List<History> findAll() {
		return historyRepository.findAll();
	}

}
