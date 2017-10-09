package com.aartek.prestigepoint.repositoryImpl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.prestigepoint.model.AddPlacedStudent;
import com.aartek.prestigepoint.repository.PlacedStudentRepository;
import com.aartek.prestigepoint.util.IConstant;

@SuppressWarnings("unchecked")
@Repository
public class PlacedStudentRepositoryImp implements PlacedStudentRepository {
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(PlacedStudentRepositoryImp.class);
    @Autowired
    private HibernateTemplate hibernateTemplate;

    public List<AddPlacedStudent> getPlacedStudent() {
        List<AddPlacedStudent> list = hibernateTemplate.find("from AddPlacedStudent aps where aps.isDeleted="
                        + IConstant.IS_DELETED);
        return list;
    }

    public List<Object> editPlacedStudent(Integer studentId) {
        List<Object> list = hibernateTemplate.find("from AddPlacedStudent a where a.studentId=" + studentId);
        return list;
    }

    public void deletePlacedStudent(Integer studentId) {
        AddPlacedStudent addPlacedStudent = (AddPlacedStudent) hibernateTemplate.get(AddPlacedStudent.class, studentId);
        addPlacedStudent.setIsDeleted(IConstant.IS_DELETED_DEACTIVE);
        if (null != addPlacedStudent) {
            hibernateTemplate.update(addPlacedStudent);
        }
    }

    public List<AddPlacedStudent> generatePlacedStudentReportMonthlyWise(String fromDate, String toDate) {
        List<AddPlacedStudent> placedStudentList = hibernateTemplate.find("from AddPlacedStudent a WHERE a.isDeleted="
                        + IConstant.IS_DELETED + " AND a.releaseDateFromAartek BETWEEN '" + fromDate + "' AND '"
                        + toDate + "' ");
         return placedStudentList;

    }

    public void savePlacedStudent(AddPlacedStudent addPlacedStudent) {
        hibernateTemplate.saveOrUpdate(addPlacedStudent);
    }

}
