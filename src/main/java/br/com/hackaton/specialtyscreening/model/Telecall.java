package br.com.hackaton.specialtyscreening.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Telecall implements BaseModel {
    @Id
    private Long id;

    private String status;

    private String description;

    private LocalDateTime initialDateTime;

    private LocalDateTime finalDateTime;
}
