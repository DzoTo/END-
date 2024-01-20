package kz.singularity.bankappdelivery.model.transaction;

import jakarta.persistence.*;
import lombok.*;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "transactions")
@Getter
@Setter
@RequiredArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
}
