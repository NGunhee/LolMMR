package com.example.mmrtest.controller;
import com.example.mmrtest.dto.SummonerDTO;
import com.example.mmrtest.service.SummonerService;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class SummonerController {

    private final SummonerService summonerService;

    public SummonerController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("/mmr")
    public Map<String, Object> getMmrAnalysis(@RequestParam("name") String name) {
        try {
            // 1. 디코딩 및 이름/태그 분리
            String decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8);
            String gameName;
            String tagLine;

            if (decodedName.contains("#")) {
                String[] parts = decodedName.split("#");
                gameName = parts[0];
                tagLine = parts[1];
            } else {
                gameName = decodedName;
                tagLine = "KR1";
            }

            // 2. 서비스의 통합 분석 메서드 호출
            // (이 메서드 안에서 SummonerInfo, MatchSummaries, LP 변동 추적, DB 저장이 모두 일어납니다)
            Map<String, Object> analysisResult = summonerService.getMmrAnalysis(gameName, tagLine);

            // 3. 추가로 컨트롤러에서 넣고 싶은 데이터가 있다면 추가
            int standardMmr = summonerService.convertTierToMmr(
                    ((SummonerDTO) analysisResult.get("summoner")).getTier(),
                    ((SummonerDTO) analysisResult.get("summoner")).getRank()
            );
            analysisResult.put("standardMmr", standardMmr);

            return analysisResult;

        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResult = new HashMap<>();
            errorResult.put("error", "조회 실패: " + e.getMessage());
            return errorResult;
        }
    }
}