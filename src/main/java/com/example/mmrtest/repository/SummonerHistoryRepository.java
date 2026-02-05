package com.example.mmrtest.repository;

import com.example.mmrtest.entity.SummonerHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SummonerHistoryRepository extends JpaRepository<SummonerHistory, Long> {
    Optional<SummonerHistory> findFirstByPuuidOrderBySearchTimeDesc(String puuid);
}