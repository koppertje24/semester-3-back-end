package com.persoonlijk.backendpersoonlijk;

import com.persoonlijk.backendpersoonlijk.DAO.DndPlayerInfoRepository;
import com.persoonlijk.backendpersoonlijk.services.DndPlayerInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class DndPlayerInfoServiceTest {

    @Autowired
    private DndPlayerInfoService myService;

    @MockBean
    private DndPlayerInfoRepository someRepository;


    @Test
    public void buildTest() {
        assertTrue(false);
    }

    // Add more tests for other methods in the service
}
