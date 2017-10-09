package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.repository.BatchRepository;
import com.aartek.prestigepoint.service.BatchService;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class BatchServiceImpl implements BatchService {

	private static final Logger logger = Logger.getLogger(BatchServiceImpl.class);

	@Autowired
	private BatchRepository batchRepository;

	/**
	 * Method get all batch list form database and display in table.
	 */
	public List<Batch> getAllBatchName() {
		logger.info("This is Info service!");
		List<Batch> list = batchRepository.getAllBatchName();
	     return list;
	}

	/**
	 * Get batch information for edit batch details.
	 * 
	 * @param batchId
	 */
	public Batch editBatch(Integer batchId) {
		Batch batch  = batchRepository.editBatch(batchId);
		if (batch != null) 
			return batch;
		else 
			return null;
	    }

	/**
	 * Method use for save batch information.
	 * 
	 * @param batch
	 */
	public boolean saveBatch(Batch batch) {
		boolean status = false;
		if (batch != null) {
			batch.setIsDeleted(IConstant.IS_DELETED);
			status = batchRepository.saveBatch(batch);
			return status;
		} else {
			return status;
		}
	}

	/**
	 * Delete batch information.
	 * 
	 * @param batchId
	 * @return 
	 */
	public boolean deleteBatch(Integer batchId) {
		boolean status = false;
		status =batchRepository.deleteBatch(batchId);
		if(status)
			return status;
	   else
			return status;
	}

}
