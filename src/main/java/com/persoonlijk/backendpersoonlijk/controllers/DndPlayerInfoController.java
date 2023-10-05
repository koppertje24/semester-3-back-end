package com.persoonlijk.backendpersoonlijk.controllers;

import com.persoonlijk.backendpersoonlijk.models.DndPlayerInfo;
import com.persoonlijk.backendpersoonlijk.services.DndPlayerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/players")
public class DndPlayerInfoController {

    private final DndPlayerInfoService playerInfoService;

    @Autowired
    public DndPlayerInfoController(DndPlayerInfoService playerInfoService) {
        this.playerInfoService = playerInfoService;
    }

    @GetMapping("/{id}/characters")
    public List<DndPlayerInfo> getCharacterSheetsByPlayerId(@PathVariable Long id) {
        return playerInfoService.getCharacterSheetsByPlayerId(id);
    }
}
