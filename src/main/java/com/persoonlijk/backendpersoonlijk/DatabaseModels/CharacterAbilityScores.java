package com.persoonlijk.backendpersoonlijk.DatabaseModels;

import jakarta.persistence.Embeddable;

@Embeddable
public class CharacterAbilityScores {
    public boolean strengthSaveProficiency = false;
    public int strength = 10;
    public boolean dexteritySaveProficiency = false;
    public int dexterity = 10;
    public boolean constitutionSaveProficiency = false;
    public int constitution = 10;
    public boolean intelligenceSaveProficiency = false;
    public int intelligence = 10;
    public boolean wisdomSaveProficiency = false;
    public int wisdom = 10;
    public boolean charismaSaveProficiency = false;
    public int charisma = 10;

}
