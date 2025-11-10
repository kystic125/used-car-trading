package com.usedcar.trading.domain.settlement.entity;

import com.usedcar.trading.domain.company.entity.Company;
import com.usedcar.trading.domain.transaction.entity.Transaction;
import com.usedcar.trading.global.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
public class Settlement extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long settlementId;

    @Column(nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private BigDecimal commissionAmount;

    @Column(nullable = false)
    private BigDecimal settlementAmount;

    @Enumerated(EnumType.STRING)
    private SettlementStatus settlementStatus = SettlementStatus.PENDING;

    private LocalDateTime settledAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id", unique = true, nullable = false)
    private Transaction transaction;
}
