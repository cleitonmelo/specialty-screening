package br.com.hackaton.specialtyscreening.model;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Screening {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long patientCode;

    private String patientName;

    @Column(nullable = true)
    private int specialistDoctorId;

    @Column(nullable = false)
    private String specialtyCode;

    @Column(nullable = false)
    private ScreeningStatus status;

}
