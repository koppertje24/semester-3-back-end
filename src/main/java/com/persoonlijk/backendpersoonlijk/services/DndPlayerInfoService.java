package com.persoonlijk.backendpersoonlijk.services;

import com.persoonlijk.backendpersoonlijk.DAO.DndPlayerInfoRepository;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.DndPlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


// een service zorgt voor het zware werk en kunnen komplexe veranderingen in gebeuren.
@Service
public class DndPlayerInfoService {

    private final DndPlayerInfoRepository playerInfoRepository;

    @Autowired
    public DndPlayerInfoService(DndPlayerInfoRepository playerInfoRepository) {
        this.playerInfoRepository = playerInfoRepository;
    }

    public List<DndPlayerInfo> getCharacterSheetsByPlayerId(Long playerId) {
        return playerInfoRepository.findDndPlayerInfoById(playerId);
    }
}
