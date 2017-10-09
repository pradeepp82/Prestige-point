package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.Batch;
import com.aartek.prestigepoint.repository.BatchRepository;
import com.aartek.prestigepoint.util.IConstant;
@SuppressWarnings("unused")
@Repository
public class BatchRepositoryImpl implements BatchRepository {
	private static final Logger logger = Logger.getLogger(BatchRepositoryImpl.class);
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/**
	 * Get all batch name from data base.
	 */

	@SuppressWarnings("unchecked")
	public List<Batch> getAllBatchName() {
		logger.info("This is getAllBatchName!");
		List<Batch> batchList = hibernateTemplate.find("from Batch where IS_DELETED=" + IConstant.IS_DELETED);
		return batchList;
	}

	/**
	 * Get batch information for edit batch details.
	 */
	
	public Batch editBatch(Integer batchId) {
		Batch batch = hibernateTemplate.get(Batch.class, batchId);
		return batch;
	}

	/**
	 * Method use for save batch details into database.
	 */
	public boolean saveBatch(Batch batch) {
		if (batch != null) {
			hibernateTemplate.saveOrUpdate(batch);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method for delete batch information.
	 * 
	 * @return
	 */
	
	public boolean deleteBatch(Integer batchId) {
		Batch batch = (Batch) hibernateTemplate.get(Batch.class, batchId);
		batch.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
		if (null != batch) {
			hibernateTemplate.update(batch);
			return true;
		} else {
			return false;
		}
	}

}
