package com.aartek.prestigepoint.serviceImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.prestigepoint.model.CurrentBatch;
import com.aartek.prestigepoint.repository.CurrentBatchRepository;
import com.aartek.prestigepoint.service.CurrentBatchService;
import com.aartek.prestigepoint.util.CamelCase;
import com.aartek.prestigepoint.util.IConstant;

@Service
public class CurrentBatchServiceImpl implements CurrentBatchService {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(CurrentBatchServiceImpl.class);

	@Autowired
	private CurrentBatchRepository currentBatchRepository;

	/**
	 * use for add current batch information
	 * 
	 * @param currentBatch
	 */
	public boolean saveCurrentBatch(CurrentBatch currentBatch) {
		boolean status = false;
		if (currentBatch != null) {
			currentBatch.setIsDeleted(IConstant.IS_DELETED);
			String name = CamelCase.produceCamelCase(currentBatch.getBatchName());
			currentBatch.setBatchName(name);
			status = currentBatchRepository.saveCurrentBatch(currentBatch);
			return status;
		}
		return status;
	}

	/**
	 * get all current batch.
	 */
	public List<CurrentBatch> getAllCurrentBatch() {
		List<CurrentBatch> currentBatchs = currentBatchRepository.getAllCurrentBatch();
		return currentBatchs;
		
	}

	/**
	 * Delete current batch.
	 * 
	 * @return
	 */
	public boolean deleteCurrentBatch(Integer currentBatchId) {
		boolean status = false;
		status = currentBatchRepository.deleteCurrentBatch(currentBatchId);
		if (status)
			return status;
		else
			return status;
	}

	/**
	 * Update current batch information
	 */
	public CurrentBatch updateCurrentBatch(Integer currentBatchId) {
		List<CurrentBatch> currentBatchs = currentBatchRepository.updateCurrentBatch(currentBatchId);
		if (currentBatchs != null && !currentBatchs.isEmpty()) {
			return currentBatchs.get(0);
		}
		return null;
	}

}
