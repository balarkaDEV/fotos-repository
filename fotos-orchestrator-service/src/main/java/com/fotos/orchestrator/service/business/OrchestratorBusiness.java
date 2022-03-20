package com.fotos.orchestrator.service.business;

import com.fotos.orchestrator.service.advice.OrchestratorAdvice;
import com.fotos.orchestrator.service.exception.OrchestratorBusinessException;
import com.fotos.orchestrator.service.model.EquipmentMaster;
import com.fotos.orchestrator.service.model.OrchestratorEntity;
import com.fotos.orchestrator.service.model.PhotographerMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrchestratorBusiness {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrchestratorBusiness.class);

    @Autowired
    private WebClient.Builder webClientBuilder;

    public OrchestratorEntity save(OrchestratorEntity orchestratorEntity){
        PhotographerMaster photographerMaster;
        try{
            photographerMaster = createPhotographer(orchestratorEntity.getPhotographerMaster());
        } catch (Exception e){
            LOGGER.error("Exception occurred while saving photographer master details");
            e.printStackTrace();
            throw new OrchestratorBusinessException("Exception occurred while saving photographer master details.Transaction aborted.");
        }

        if(photographerMaster == null)
            throw new OrchestratorBusinessException("Photographer master details not saved properly.Transaction aborted.");

        LOGGER.debug("Photographer master details saved successfully");

        List<EquipmentMaster> retEqMasters = new ArrayList<>();

        try {
            for(EquipmentMaster each :  orchestratorEntity.getEquipmentMasters()){
                each.setPhotographerId(photographerMaster.getId());
                EquipmentMaster equipmentMaster = createEquipment(each);
                retEqMasters.add(equipmentMaster);
            }
        } catch (Exception e){
            LOGGER.error("Exception occurred while saving equipment details.Aborting transaction");
            deletePhotographer(photographerMaster.getId());
            retEqMasters.forEach(element -> deleteEquipment(element.getId()));

            LOGGER.error("Transaction aborted.");

            throw new OrchestratorBusinessException("Exception occurred while saving equipment details.Transaction aborted.");
        }

        orchestratorEntity.setEquipmentMasters(retEqMasters);
        orchestratorEntity.setPhotographerMaster(photographerMaster);

        LOGGER.debug("All details saved successfully");

        return orchestratorEntity;
    }

    private PhotographerMaster createPhotographer(PhotographerMaster photographer){
        PhotographerMaster photographerMaster =
                webClientBuilder.build()
                    .post()
                        .uri("http://PHOTOGRAPHER-MASTER-SERVICE/service/fotos/v1/photographer")
                            .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                    .body(BodyInserters.fromValue(photographer))
                                        .retrieve()
                                            .bodyToMono(PhotographerMaster.class)
                                                .block();
        return photographerMaster;
    }

    private EquipmentMaster createEquipment(EquipmentMaster equipment){
        EquipmentMaster equipmentMaster =
                webClientBuilder.build()
                    .post()
                        .uri("http://EQUIPMENT-MASTER-SERVICE/service/fotos/v1/equipment")
                            .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                    .body(BodyInserters.fromValue(equipment))
                                        .retrieve()
                                            .bodyToMono(EquipmentMaster.class)
                                                .block();

        return equipmentMaster;
    }

    private void deletePhotographer(long id){
        webClientBuilder.build()
                .delete()
                    .uri("http://PHOTOGRAPHER-MASTER-SERVICE/service/fotos/v1/photographer/{id}", id)
                        .retrieve()
                            .bodyToMono(PhotographerMaster.class)
                                .block();
    }

    private void deleteEquipment(long id){
        webClientBuilder.build()
                .delete()
                    .uri("http://EQUIPMENT-MASTER-SERVICE/service/fotos/v1/equipment/{id}", id)
                        .retrieve()
                            .bodyToMono(EquipmentMaster.class)
                                .block();
    }
}
