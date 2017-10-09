package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.AddMarquee;

public interface MarqueeRepository {

	public boolean saveMarquee(AddMarquee addMarquee);

	public List<AddMarquee> getAllMarqueeDiscription();

	public List<AddMarquee> editMarqueeDescription(Integer marqueeId);

	public boolean deleteMarqueeDescription(Integer marqueeId);


}
