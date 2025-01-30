package com.infosys.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infosys.entity.Trades;  // Renamed
import com.infosys.repo.TradeRepository;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    @Autowired
    private TradeRepository tradeRepository;

    @GetMapping("/open")
    public ResponseEntity<List<Trades>> getOpenTrades() {
        try {
            List<Trades> trades = tradeRepository.findByStatus("open");
            System.out.println("Fetched open trades: " + trades);
            
            if (trades.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            
            return ResponseEntity.ok(trades);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/settlement/next-5-days")
    public ResponseEntity<List<Trades>> getTradesWithSettlementInNext5Days() {
        try {
            LocalDate today = LocalDate.now();
            LocalDate fiveDaysLater = today.plusDays(5);
            
            List<Trades> trades = tradeRepository.findBySettlementDateBetween(today, fiveDaysLater);
            
            if (trades.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            
            return ResponseEntity.ok(trades);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}