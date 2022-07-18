package com.company.service.inter;

import com.company.model.Advertisement;

import java.util.List;

public interface AdvertisementService {


     boolean saveAdvertisement(Advertisement advertisement);

     boolean updateAdvertisement(Advertisement advertisement);

     boolean removeAdvertisement(Advertisement advertisement);

     Advertisement findById(Integer id);

     List<Advertisement> findAdvertisementByUsername(String username);

     List<Advertisement> findAllAdvertisements();

}
