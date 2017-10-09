package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.AddMarquee;
import com.aartek.prestigepoint.repository.MarqueeRepository;
import com.aartek.prestigepoint.service.MarqueeService;
import com.aartek.prestigepoint.util.IConstant;
@Service
public class MarqueeServiceImpI implements MarqueeService {

	@Autowired
	private MarqueeRepository addMarqueeRepository;
	
	public boolean saveMarquee(AddMarquee addMarquee) {
		boolean status = false;
		addMarquee.setIsDeleted(IConstant.IS_DELETED);
		addMarquee.setIsActive(IConstant.IS_DELETED_DEACTIVE);
		status = addMarqueeRepository.saveMarquee(addMarquee);
		if(status){
			return status;
		}else{
			return status;
		}
		}

	public List<AddMarquee> getAllMarqueeDescription() {
		List<AddMarquee> list = addMarqueeRepository.getAllMarqueeDiscription();
		return list;
	}
	

	public AddMarquee editMarqueeDescription(Integer marqueeId) {
		List<AddMarquee> allMaqqueeList = addMarqueeRepository.editMarqueeDescription(marqueeId);
		if(allMaqqueeList!=null)
		  return allMaqqueeList.get(0);
		else
			return null;
		
	}


	public boolean deleteMarqueeDescription(Integer marqueeId) {
		boolean status = false;
		status = addMarqueeRepository.deleteMarqueeDescription(marqueeId);
		if(status)
			return status;
		else
			return status;
	}

	public void changeMarqueeStatus(String marqueeIdValue, Integer marqueeValue) {
		if (marqueeIdValue != null && marqueeValue != null) {
			AddMarquee addMarquee = (AddMarquee) addMarqueeRepository.editMarqueeDescription(marqueeValue).get(0);
			if (marqueeIdValue.equals("true")) {
				addMarquee.setIsActive(IConstant.IS_DELETED);
				addMarqueeRepository.saveMarquee(addMarquee);
			} else {
				addMarquee.setIsActive(IConstant.IS_DELETED_DEACTIVE);
				addMarqueeRepository.saveMarquee(addMarquee);
			}

		}
		
	}
		
	}


