package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.AddMarquee;

public interface MarqueeService {

	public boolean saveMarquee(AddMarquee addMarquee);

	public List<AddMarquee> getAllMarqueeDescription();

	public AddMarquee editMarqueeDescription(Integer marqueeId);

	public boolean deleteMarqueeDescription(Integer marqueeId);

	public void changeMarqueeStatus(String marqueeIdValue, Integer marqueeValue);

}
