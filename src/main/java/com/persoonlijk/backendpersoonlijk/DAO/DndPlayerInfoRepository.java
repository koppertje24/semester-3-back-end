package com.persoonlijk.backendpersoonlijk.DAO;

import com.persoonlijk.backendpersoonlijk.DatabaseModels.DndPlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// een DAO is de repository verbinding en uitberijdingen opdrachten.

public interface DndPlayerInfoRepository extends JpaRepository<DndPlayerInfo, Long> {

}
