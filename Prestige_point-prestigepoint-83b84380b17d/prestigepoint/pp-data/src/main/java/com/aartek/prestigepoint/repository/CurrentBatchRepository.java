package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.CurrentBatch;

public interface CurrentBatchRepository {

	public boolean saveCurrentBatch(CurrentBatch currentBatch);

	public List<CurrentBatch> getAllCurrentBatch();

	public boolean deleteCurrentBatch(Integer currentBatchId);

	public List<CurrentBatch> updateCurrentBatch(Integer currentBatchId);

}
