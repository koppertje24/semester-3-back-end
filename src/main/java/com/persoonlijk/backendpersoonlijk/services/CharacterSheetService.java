package com.persoonlijk.backendpersoonlijk.services;

import com.persoonlijk.backendpersoonlijk.DAO.CharacterSheetRepository;
import com.persoonlijk.backendpersoonlijk.DAO.DndPlayerInfoRepository;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterSheet;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.DndPlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterSheetService {

    private final DndPlayerInfoRepository playerInfoRepository;
    private final CharacterSheetRepository characterSheetRepository;

    @Autowired
    public CharacterSheetService(DndPlayerInfoRepository playerInfoRepository, CharacterSheetRepository characterSheetRepository) {

        this.playerInfoRepository = playerInfoRepository;
        this.characterSheetRepository = characterSheetRepository;
    }

    public CharacterSheet getCharacterSheetById(Long id) {
        Optional<CharacterSheet> characterSheetOptional = characterSheetRepository.findById(id);

        // Check if the CharacterSheet exists in the database
        if (characterSheetOptional.isPresent()) {
            return characterSheetOptional.get();
        } else {
            // Handle the case where the CharacterSheet does not exist
            return null;
        }
    }

    public CharacterSheet createCharacterSheet(CharacterSheet newCharacterSheet) {
        // Save the new character sheet to the database using the repository's save method
        return characterSheetRepository.save(newCharacterSheet);
    }

    public CharacterSheet updateCharacterSheet(Long id, CharacterSheet updatedCharacterSheet) {
        CharacterSheet existingCharacterSheet = characterSheetRepository.findById(id)
                .orElse(createCharacterSheet(updatedCharacterSheet));

        // Update the fields of the existing character sheet with the new data
        existingCharacterSheet.setCharacterName(updatedCharacterSheet.getCharacterName());

        // Save the updated character sheet to the database
        return characterSheetRepository.save(existingCharacterSheet);
    }

    public boolean deleteCharacterSheet(Long  userId , Long characterIndexId)
    {
        DndPlayerInfo existingDndPlayerInfo = playerInfoRepository.findById(userId)
                .orElse(null);

        if (existingDndPlayerInfo != null && (existingDndPlayerInfo.getPlayerCharacters().size() >= characterIndexId && characterIndexId >= 0 ))
        {
            CharacterSheet sheet = existingDndPlayerInfo.getPlayerCharacters().get(characterIndexId.intValue());
            if (characterSheetRepository.existsById(sheet.getId()))
            {
                characterSheetRepository.deleteById(sheet.getId());
                return true;
            }
        }
        else
        {
            return false;
        }

        return false;
    }
}
