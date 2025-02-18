package br.com.hackaton.specialtyscreening.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

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
}
