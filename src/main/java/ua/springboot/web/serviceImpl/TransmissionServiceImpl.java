package ua.springboot.web.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.springboot.web.entity.Transmission;
import ua.springboot.web.repository.TransmissionRepository;
import ua.springboot.web.service.TransmissionService;

@Service
public class TransmissionServiceImpl implements TransmissionService{

	private TransmissionRepository transmissionRepository;
	
	@Autowired
	public TransmissionServiceImpl(TransmissionRepository transmissionRepository) {
		this.transmissionRepository = transmissionRepository;
	}

	@Override
	public void save(Transmission transmission) {
		transmissionRepository.save(transmission);
	}

	@Override
	public Transmission findById(Long id) {
		return transmissionRepository.findOne(id);
	}

	@Override
	public List<Transmission> findAll() {
		return transmissionRepository.findAll();
	}

	@Override
	public List<String> findAllTransmission() {
		return transmissionRepository.findTransmissionString();
	}

	
}
