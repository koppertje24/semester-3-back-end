package com.persoonlijk.backendpersoonlijk;

import com.persoonlijk.backendpersoonlijk.DAO.CharacterSheetRepository;
import com.persoonlijk.backendpersoonlijk.DAO.DndPlayerInfoRepository;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterAbilityScores;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.CharacterSheet;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.DndPlayerInfo;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.EnumCharacterClass;
import com.persoonlijk.backendpersoonlijk.services.DndPlayerInfoService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class    DndPlayerInfoServiceTest {

    @Autowired
    private DndPlayerInfoService dndPlayerInfoService;

    @MockBean
    private DndPlayerInfoRepository playerInfoRepository;

    @MockBean
    private CharacterSheetRepository characterSheetRepository;

    private DndPlayerInfo testPlayer;

    @BeforeEach
    public void setup() {
        testPlayer = new DndPlayerInfo();
        testPlayer.setId(1l);
        testPlayer.setPlayerName("BOB");

        List<CharacterSheet> testSheets = new ArrayList<CharacterSheet>();

        for (short i = 1; i <= 5; i++) {
         CharacterSheet sheet = new CharacterSheet();
         sheet.setPlayerId(1l);
         sheet.setCharacterLevel(i);
         sheet.setCharacterClass(EnumCharacterClass.values()[i]);
         sheet.setAbilityScores(new CharacterAbilityScores());
         testSheets.add(sheet);
        }

        testPlayer.setPlayerCharacters(testSheets);

        when(playerInfoRepository.findById(1L)).thenReturn(Optional.of(testPlayer));
        when(playerInfoRepository.save(any(DndPlayerInfo.class))).thenAnswer(i -> i.getArguments()[0]);
    }

    @Test
    public void testGetCharacterSheetsByPlayerId() {
        DndPlayerInfo result = dndPlayerInfoService.getCharacterSheetsByPlayerId(1L);
        assertEquals(testPlayer, result);
    }

    @Test
    public void testCreateDndPlayerInfo() {
        DndPlayerInfo newPlayer = new DndPlayerInfo();
        newPlayer.setId(2L);
        newPlayer.setPlayerName("ALICE");

        DndPlayerInfo result = dndPlayerInfoService.createDndPlayerInfo(newPlayer);
        assertEquals(newPlayer, result);
    }

    @Test
    public void testUpdateDndPlayerInfo() {
        CharacterSheet updatedCharacter = new CharacterSheet();
        updatedCharacter.setPlayerId(1L);
        updatedCharacter.setCharacterLevel((short)10);
        updatedCharacter.setCharacterClass(EnumCharacterClass.values()[10]);
        updatedCharacter.setAbilityScores(new CharacterAbilityScores());

        DndPlayerInfo result = dndPlayerInfoService.updateDndPlayerInfo(1L, 3, updatedCharacter);
        assertEquals(testPlayer, result);
    }

    @Test
    public void testCreateDndCharacter() {
        CharacterSheet newCharacter = new CharacterSheet();
        newCharacter.setPlayerId(1L);
        newCharacter.setCharacterLevel((short)6);
        newCharacter.setCharacterClass(EnumCharacterClass.values()[6]);
        newCharacter.setAbilityScores(new CharacterAbilityScores());



        DndPlayerInfo result = dndPlayerInfoService.createDndCharacter(1L, newCharacter);
        assertEquals(testPlayer, result);
    }



    // Add more tests for other methods in the service
}
