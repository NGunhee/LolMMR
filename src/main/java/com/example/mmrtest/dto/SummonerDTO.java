package com.example.mmrtest.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SummonerDTO {
    private String id; // encrypted id (티어 조회용)
    private String puuid;
    private String name;
    private int summonerLevel;
    private String tier;   // GOLD
    private String rank;   // IV
    private int leaguePoints;
}
