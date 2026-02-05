package com.example.mmrtest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MatchSummary {
    private boolean win;
    private int kills;
    private int deaths;
    private int assists;
    private String championName;
    private List<Integer> items;
    private List<String> teamMembers;
    private List<String> teamChamps; // 10명의 챔피언 이름 리스트
    private int gameDurationMinutes;
    private int spell1Id;
    private int spell2Id;
    private int mainRuneId;
    private int subRuneId;
    private int totalCs;            // 추가: CS
    private int goldEarned;         // 추가: 골드
    private long gameEndTimeStamp;  // 추가: 게임 종료 시각 (몇 시간 전 계산용)
    private int performanceScore;   // 분석용 점수
}