package com.fotos.photographer.master.service.business;

import com.fotos.photographer.master.service.exception.PhotoGMasterBusinessException;
import com.fotos.photographer.master.service.model.PhotographerMaster;
import com.fotos.photographer.master.service.repository.PhotoGMasterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PhotoGMasterBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoGMasterBusiness.class);

    @Autowired
    private PhotoGMasterRepository photoGMasterRepository;

    public List<PhotographerMaster> findAllRecords(){
        return Optional.of(photoGMasterRepository.findAll()).orElseThrow(PhotoGMasterBusinessException::new);
    }

    public PhotographerMaster findRecordById(long id){
        return photoGMasterRepository.findById(id).orElseThrow(PhotoGMasterBusinessException::new);
    }

    public PhotographerMaster save(PhotographerMaster photographerMaster) {
        return photoGMasterRepository.save(photographerMaster);
    }

    public List<PhotographerMaster> findRecordsByQuery(Map<String, String> queryParams){
        if (queryParams.get("name") != null && queryParams.get("city") != null)
            return Optional.of(
                    photoGMasterRepository.findByNameAndCity(queryParams.get("name"), queryParams.get("city")))
                        .orElseThrow(PhotoGMasterBusinessException::new);
        else if (queryParams.get("name") != null)
            return Optional.of(
                    photoGMasterRepository.findByName(queryParams.get("name")))
                        .orElseThrow(PhotoGMasterBusinessException::new);
        else
            return Optional.of(
                    photoGMasterRepository.findByCity(queryParams.get("city")))
                        .orElseThrow(PhotoGMasterBusinessException::new);
    }

    public void deleteById(long id){
        photoGMasterRepository.deleteById(id);
    }
}
