package com.infosys.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "trades")
public class Trades {  // Renamed from 'trades' to 'Trades'
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tradeId;

    private String bookId;
    private Double price;
    private String secId;
    private String status;
    
    @Column(name = "settlement_date")
    private LocalDate settlementDate;

    // Getters and Setters
    public Long getTradeId() { return tradeId; }
    public void setTradeId(Long tradeId) { this.tradeId = tradeId; }

    public String getBookId() { return bookId; }
    public void setBookId(String bookId) { this.bookId = bookId; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getSecId() { return secId; }
    public void setSecId(String secId) { this.secId = secId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getSettlementDate() { return settlementDate; }
    public void setSettlementDate(LocalDate settlementDate) { this.settlementDate = settlementDate; }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeId=" + tradeId +
                ", bookId='" + bookId + '\'' +
                ", price=" + price +
                ", secId='" + secId + '\'' +
                ", status='" + status + '\'' +
                ", settlementDate=" + settlementDate +'}';
    }
}