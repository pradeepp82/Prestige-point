package com.aartek.prestigepoint.repository;

import java.util.List;

import com.aartek.prestigepoint.model.Batch;

public interface BatchRepository {

	public List<Batch> getAllBatchName();

	public Batch editBatch(Integer batchId);

	public boolean saveBatch(Batch batch);

	public boolean deleteBatch(Integer batchId);

}
