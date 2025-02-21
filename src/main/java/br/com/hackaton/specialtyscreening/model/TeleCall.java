package br.com.hackaton.specialtyscreening.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "telecall")
public class TeleCall {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private UUID id;
    private LocalDateTime initialDateTime;
    private LocalDateTime finalDateTime;
}
