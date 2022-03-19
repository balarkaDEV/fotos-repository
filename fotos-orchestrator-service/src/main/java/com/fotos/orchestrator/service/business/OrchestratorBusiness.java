package com.fotos.orchestrator.service.business;

import com.fotos.orchestrator.service.model.EquipmentMaster;
import com.fotos.orchestrator.service.model.OrchestratorEntity;
import com.fotos.orchestrator.service.model.PhotographerMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class OrchestratorBusiness {

    @Autowired
    private WebClient.Builder webClientBuilder;

    public OrchestratorEntity save(OrchestratorEntity orchestratorEntity){

        PhotographerMaster photographerMaster =
                    webClientBuilder.build()
                        .post()
                            .uri("http://photographer-master-service/service/fotos/v1/photographer")
                                .contentType(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON)
                                        .body(BodyInserters.fromValue(orchestratorEntity.getPhotographerMaster()))
                                            .retrieve()
                                                .bodyToMono(PhotographerMaster.class)
                                                    .block();

        EquipmentMaster eqMasterRequest = orchestratorEntity.getEquipmentMaster();
        eqMasterRequest.setPhotographerId(photographerMaster.getId());

        EquipmentMaster equipmentMaster =
                    webClientBuilder.build()
                        .post()
                            .uri("http://equipment-master-service/service/fotos/v1/equipment")
                                .contentType(MediaType.APPLICATION_JSON)
                                    .accept(MediaType.APPLICATION_JSON)
                                        .body(BodyInserters.fromValue(eqMasterRequest))
                                            .retrieve()
                                                .bodyToMono(EquipmentMaster.class)
                                                    .block();

        orchestratorEntity.setPhotographerMaster(photographerMaster);
        orchestratorEntity.setEquipmentMaster(equipmentMaster);

        return orchestratorEntity;
    }
}
