package com.persoonlijk.backendpersoonlijk.services;

import com.persoonlijk.backendpersoonlijk.DAO.DndPlayerInfoRepository;
import com.persoonlijk.backendpersoonlijk.models.DndPlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
