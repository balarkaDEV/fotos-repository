package com.fotos.award.master.service.business;

import com.fotos.award.master.service.model.AwardMaster;
import com.fotos.award.master.service.repository.AwardMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardMasterBusiness {

    @Autowired
    private AwardMasterRepository awardMasterRepository;

    public List<AwardMaster> findAll(){
        return awardMasterRepository.findAll();
    }
}
