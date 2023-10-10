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

    public DndPlayerInfo createDndPlayerInfo(DndPlayerInfo newDndPlayerInfo) {
        // Save the new character sheet to the database using the repository's save method
        return playerInfoRepository.save(newDndPlayerInfo);
    }

    public DndPlayerInfo updateDndPlayerInfo(Long id, int characterId, CharacterSheet updatedDndPlayerInfo) {
        DndPlayerInfo existingDndPlayerInfo = playerInfoRepository.findById(id)
                .orElse(null);

        // get the character sheet that needs updating
        List<CharacterSheet> characterSheets = existingDndPlayerInfo.getPlayerCharacters();
        CharacterSheet item = characterSheets.get(characterId);
        // Update the fields of the character sheet with the new data
        item.setCharacterName(updatedDndPlayerInfo.getCharacterName());
        characterSheets.set(characterId, item);

        // save the info in the database.
        existingDndPlayerInfo.setPlayerCharacters(characterSheets);

        // Save the updated character sheet to the database
        return playerInfoRepository.save(existingDndPlayerInfo);
    }
}
