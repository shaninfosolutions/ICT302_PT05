package pt05.com.sg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.entity.Partner;
import pt05.com.sg.data.repository.PartnerRepository;
import pt05.com.sg.service.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService{
	
	@Autowired
	private  PartnerRepository partnerRepository;
	
	public List<Partner> getList() {
		return (List<Partner>) this.partnerRepository.findAll();
	}
	
	public Partner addOrUpdate(Partner partner) {
		return this.partnerRepository.save(partner);
	}

}
