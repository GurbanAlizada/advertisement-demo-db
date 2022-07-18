package com.company.service.impl;

import com.company.model.Advertisement;
import com.company.repository.impl.AdvertisementImpl;
import com.company.repository.inter.AdvertisementRepo;
import com.company.service.inter.AdvertisementService;

import java.util.List;

public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepo advertisementRepo = new AdvertisementImpl();


    @Override
    public boolean saveAdvertisement(Advertisement advertisement) {

        return this.advertisementRepo.saveAdvertisement(advertisement);
    }

    @Override
    public boolean updateAdvertisement(Advertisement advertisement) {
        return this.advertisementRepo.updateAdvertisement(advertisement);
    }

    @Override
    public boolean removeAdvertisement(Advertisement advertisement) {
        return this.advertisementRepo.removeAdvertisement(advertisement);
    }

    @Override
    public Advertisement findById(Integer id) {
        return this.advertisementRepo.findById(id);
    }

    @Override
    public List<Advertisement> findAdvertisementByUsername(String username) {
        return this.advertisementRepo.findAdvertisementByUsername(username);
    }

    @Override
    public List<Advertisement> findAllAdvertisements() {
        return this.advertisementRepo.findAllAdvertisements();
    }
}
