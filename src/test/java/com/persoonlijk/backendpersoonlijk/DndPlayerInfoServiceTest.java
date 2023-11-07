package com.persoonlijk.backendpersoonlijk;

import com.persoonlijk.backendpersoonlijk.DAO.CharacterSheetRepository;
import com.persoonlijk.backendpersoonlijk.DAO.DndPlayerInfoRepository;
import com.persoonlijk.backendpersoonlijk.DatabaseModels.DndPlayerInfo;
import com.persoonlijk.backendpersoonlijk.services.DndPlayerInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest
public class DndPlayerInfoServiceTest {

    @InjectMocks
    DndPlayerInfoService dndPlayerInfoService;

    @Mock
    DndPlayerInfoRepository playerInfoRepository;

    @Mock
    CharacterSheetRepository characterSheetRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCharacterSheetsByPlayerId() {
        DndPlayerInfo dndPlayerInfo = new DndPlayerInfo();
        dndPlayerInfo.setId(1L);

        when(playerInfoRepository.findById(1L)).thenReturn(Optional.of(dndPlayerInfo));

        DndPlayerInfo result = dndPlayerInfoService.getCharacterSheetsByPlayerId(1L);

        assertEquals(dndPlayerInfo, result);
        verify(playerInfoRepository, times(1)).findById(1L);
    }

    // Add more tests for other methods in the service
}
