package br.com.hackaton.specialtyscreening.model;

import br.com.hackaton.specialtyscreening.enums.ScreeningStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Screening implements BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patientCode;

    private String patientName;

    @ManyToOne
    @JoinColumn(name = "specialistDoctorId")
    private SpecialistDoctor specialistDoctor;

    @ManyToOne
    @JoinColumn(name = "specialtyId")
    private Specialty specialty;

    @Column(nullable = false)
    private ScreeningStatus status;

    @OneToOne
    @JoinColumn(name = "diagnosisId")
    private Diagnosis diagnosis;

    private String telecall;
}
