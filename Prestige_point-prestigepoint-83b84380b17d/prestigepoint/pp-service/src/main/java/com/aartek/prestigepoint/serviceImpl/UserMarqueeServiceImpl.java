package com.aartek.prestigepoint.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AddMarquee;
import com.aartek.prestigepoint.repository.UserMarqueeRepository;
import com.aartek.prestigepoint.service.UserMarqueeService;
@Service
public class UserMarqueeServiceImpl implements UserMarqueeService {


	@Autowired
	private UserMarqueeRepository userMarqueeRepository;
	
	public List<AddMarquee> fatchMarqueeDescription() {
		
		List<AddMarquee> list = new ArrayList<AddMarquee>();
		list = userMarqueeRepository.fatchMarqueeDescription();
	
		return list;
	}

}
