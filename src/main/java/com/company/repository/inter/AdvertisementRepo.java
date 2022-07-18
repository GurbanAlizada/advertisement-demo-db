package com.company.repository.inter;

import com.company.model.Advertisement;

import java.util.List;

public interface AdvertisementRepo {


     boolean saveAdvertisement(Advertisement advertisement);

     boolean updateAdvertisement(Advertisement advertisement);

     boolean removeAdvertisement(Advertisement advertisement);

     Advertisement findById(Integer id);

     List<Advertisement> findAdvertisementByUsername(String username);

     List<Advertisement> findAllAdvertisements();

}
