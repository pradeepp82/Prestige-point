package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.CurrentBatch;

public interface CurrentBatchService {

	public boolean saveCurrentBatch(CurrentBatch currentBatch);

	public List<CurrentBatch> getAllCurrentBatch();

	public boolean deleteCurrentBatch(Integer currentBatchId);

	public CurrentBatch updateCurrentBatch(Integer currentBatchId);

}
