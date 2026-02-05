package com.example.mmrtest;

import com.example.mmrtest.dto.SummonerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;


@FeignClient(name = "riotSummoner", url = "https://kr.api.riotgames.com")
public interface SummonerClient {
    @GetMapping("/lol/summoner/v4/summoners/by-name/{summonerName}")
    SummonerDTO getSummonerByName(
            @PathVariable("summonerName") String summonerName,
            @RequestHeader("X-Riot-Token") String apiKey
    );
}
