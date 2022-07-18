package com.company.service.impl;

import com.company.model.Education;
import com.company.repository.impl.EducationImpl;
import com.company.repository.inter.EducationRepo;
import com.company.service.inter.EducationService;

import java.util.List;

public class EducationServiceImpl implements EducationService {

    private EducationRepo educationRepo = new EducationImpl();


    @Override
    public boolean saveEducation(Education education) {
        return this.educationRepo.saveEducation(education);
    }

    @Override
    public boolean updateEducation(Education education) {
        return this.educationRepo.updateEducation(education);
    }

    @Override
    public boolean removeEducation(Education education) {
        return this.removeEducation(education);
    }

    @Override
    public List<Education> findAllEducation() {
        return this.educationRepo.findAllEducation();
    }

    @Override
    public Education findEducationByIdWithAdvertisement() {
        return this.educationRepo.findEducationByIdWithAdvertisement();
    }
}
