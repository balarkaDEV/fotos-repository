package com.fotos.orchestrator.service.business;

import com.fotos.orchestrator.service.advice.OrchestratorAdvice;
import com.fotos.orchestrator.service.exception.OrchestratorBusinessException;
import com.fotos.orchestrator.service.model.EquipmentMaster;
import com.fotos.orchestrator.service.model.OrchestratorEntity;
import com.fotos.orchestrator.service.model.PhotographerMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrchestratorBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrchestratorBusiness.class);

    @Autowired
    private WebClient.Builder webClientBuilder;

    public OrchestratorEntity save(OrchestratorEntity orchestratorEntity){
        PhotographerMaster photographerMaster = null;
        try{
            photographerMaster = webClientBuilder.build()
                                    .post()
                                        .uri("http://photographer-master-service/service/fotos/v1/photographer")
                                            .contentType(MediaType.APPLICATION_JSON)
                                                .accept(MediaType.APPLICATION_JSON)
                                                    .body(BodyInserters.fromValue(orchestratorEntity.getPhotographerMaster()))
                                                        .retrieve()
                                                            .bodyToMono(PhotographerMaster.class)
                                                                .block();
        } catch (Exception e){
            LOGGER.error("Exception occurred while saving photographer master details");
            e.printStackTrace();
            throw new OrchestratorBusinessException("Exception occurred while saving photographer master details");
        }

        if(photographerMaster == null)
            throw new OrchestratorBusinessException("Photographer master details not saved properly.Aborting transaction");

        LOGGER.debug("Photographer master details saved successfully");

        List<EquipmentMaster> equipmentMasters = orchestratorEntity.getEquipmentMasters();
        List<EquipmentMaster> retEqMasters = new ArrayList<>();

        try {
            for(EquipmentMaster each : equipmentMasters){
                each.setPhotographerId(photographerMaster.getId());
                EquipmentMaster equipmentMaster = webClientBuilder.build()
                                                    .post()
                                                        .uri("http://EQUIPMENT-MASTER-SERVICE/service/fotos/v1/equipment")
                                                            .contentType(MediaType.APPLICATION_JSON)
                                                                .accept(MediaType.APPLICATION_JSON)
                                                                    .body(BodyInserters.fromValue(each))
                                                                        .retrieve()
                                                                            .bodyToMono(EquipmentMaster.class)
                                                                                .block();

                retEqMasters.add(equipmentMaster);
            }
        } catch (Exception e){
            LOGGER.error("Exception occurred while saving equipment details");

            throw new OrchestratorBusinessException("Exception occurred while saving equipment details");
        }

        orchestratorEntity.setEquipmentMasters(retEqMasters);
        orchestratorEntity.setPhotographerMaster(photographerMaster);

        return orchestratorEntity;
    }
}
