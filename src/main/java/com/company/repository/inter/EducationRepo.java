package com.company.repository.inter;

import com.company.model.Education;
import com.company.model.User;

import java.util.List;

public interface EducationRepo {

    boolean saveEducation(Education education);

    boolean updateEducation(Education education);

    boolean removeEducation(Education education);

    List<Education> findAllEducation();

    Education findEducationByIdWithAdvertisement();


}
