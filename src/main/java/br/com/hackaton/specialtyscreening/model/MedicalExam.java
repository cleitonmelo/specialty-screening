package br.com.hackaton.specialtyscreening.model;

import jakarta.persistence.*;

@Entity
public class MedicalExam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String status;
    private String result;
}
