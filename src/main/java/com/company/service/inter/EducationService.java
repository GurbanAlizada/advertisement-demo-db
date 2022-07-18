package com.company.service.inter;

import com.company.model.Education;

import java.util.List;

public interface EducationService {

    boolean saveEducation(Education education);

    boolean updateEducation(Education education);

    boolean removeEducation(Education education);

    List<Education> findAllEducation();

    Education findEducationByIdWithAdvertisement(int id);


}
