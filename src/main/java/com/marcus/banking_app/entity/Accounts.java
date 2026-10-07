package com.marcus.banking_app.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter 
@Setter 
public class Accounts {
  @Id 
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acc_id_sequence")
  @SequenceGenerator (name = "acc_id_sequence", sequenceName = "acc_id_sequence", initialValue = 100_000, allocationSize = 1)
  private Long id;

  @Column (unique = true)
  private String accountNumber;

  @Column (nullable = false)
  private String accountName;

  private Float balance;

  @OneToMany(mappedBy = "account")
  private List<Transactions> transactions;

  @CreationTimestamp 
  private LocalDateTime createdAt;
}