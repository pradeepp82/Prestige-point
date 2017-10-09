package com.aartek.prestigepoint.service;

import java.util.List;

import com.aartek.prestigepoint.model.Batch;

public interface BatchService {

	public List<Batch> getAllBatchName();

	public Batch editBatch(Integer batchId);

	public boolean saveBatch(Batch batch);

	public boolean deleteBatch(Integer batchId);

}
