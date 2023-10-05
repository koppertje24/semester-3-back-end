package com.persoonlijk.backendpersoonlijk.DAO;

import com.persoonlijk.backendpersoonlijk.models.DndPlayerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DndPlayerInfoRepository extends JpaRepository<DndPlayerInfo, Long> {
    // Define a custom method to retrieve all character sheets for a player by player ID
    List<DndPlayerInfo> findDndPlayerInfoById(Long playerId);
}
