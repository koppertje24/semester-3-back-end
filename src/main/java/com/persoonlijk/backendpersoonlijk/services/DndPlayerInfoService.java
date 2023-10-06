package com.persoonlijk.backendpersoonlijk.services;

import com.persoonlijk.backendpersoonlijk.DAO.DndPlayerInfoRepository;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterSheet;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.DndPlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


// een service zorgt voor het zware werk en kunnen komplexe veranderingen in gebeuren.
@Service
public class DndPlayerInfoService {

    private final DndPlayerInfoRepository playerInfoRepository;

    @Autowired
    public DndPlayerInfoService(DndPlayerInfoRepository playerInfoRepository) {
        this.playerInfoRepository = playerInfoRepository;
    }

    public DndPlayerInfo getCharacterSheetsByPlayerId(Long playerId) {
        //return playerInfoRepository.getReferenceById(playerId);
        Optional<DndPlayerInfo> characterSheetOptional = playerInfoRepository.findById(playerId);

        // Check if the CharacterSheet exists in the database
        if (characterSheetOptional.isPresent()) {
            return characterSheetOptional.get();
        } else {
            // Handle the case where the CharacterSheet does not exist
            return null;
        }
    }
}
