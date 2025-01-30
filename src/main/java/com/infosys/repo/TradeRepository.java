package com.infosys.repo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.infosys.entity.Trades;  // Renamed

@Repository
public interface TradeRepository extends JpaRepository<Trades, Long> {
    List<Trades> findByStatus(String status);
    List<Trades> findBySettlementDateBetween(LocalDate startDate, LocalDate endDate);
}