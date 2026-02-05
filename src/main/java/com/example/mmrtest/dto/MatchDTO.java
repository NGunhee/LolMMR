package com.example.mmrtest.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatchDTO {
    private Metadata metadata;
    private Info info;

    @Getter @Setter
    public static class Metadata {
        private String matchId;
    }

    @Getter @Setter
    public static class Info {
        private List<Participant> participants;
        private String gameMode;
    }

    @Getter @Setter
    public static class Participant {
        private String puuid;
        private String summonerName;
        private int win; // 승리 여부 (1이면 승, 0이면 패 또는 boolean)
        private boolean winBoolean; // 최근 API는 boolean으로 줌
        // MMR 계산에 필요한 데이터들 (KDA, 티어 등등)
    }
}
