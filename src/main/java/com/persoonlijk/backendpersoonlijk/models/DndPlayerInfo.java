package com.persoonlijk.backendpersoonlijk.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class DndPlayerInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CharacterName")
    private String PlayerName;

    @OneToMany
    @JoinColumn(name = "Sheet_Id", referencedColumnName = "id")
    private List<CharacterSheet> PlayerCharacters;

    public Long GetId() {
        return id;
    }

    public String getPlayerName() {
        return PlayerName;
    }

    public List<CharacterSheet> GetPlayerSheets(){
        return PlayerCharacters;
    }
}
