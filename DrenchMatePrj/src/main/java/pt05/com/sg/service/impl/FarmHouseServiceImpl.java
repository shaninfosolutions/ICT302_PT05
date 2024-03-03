package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.Animal;
import pt05.com.sg.data.entity.FarmHouse;
import pt05.com.sg.data.repository.FarmHouseRepository;
import pt05.com.sg.service.FarmHouseService;

@Service
public class FarmHouseServiceImpl implements FarmHouseService{
	
	@Autowired
	private FarmHouseRepository farmHouseRepository;
	
	
	public List<FarmHouse> getList() {
		return (List<FarmHouse>) this.farmHouseRepository.findAll();
	}
	
	public FarmHouse addOrUpdate(FarmHouse farmHouse) {
		return this.farmHouseRepository.save(farmHouse);
	}

}
