package com.example.Salud.Entidades;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String dni;

    private LocalDate fechaRegistro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "obstetra_id", nullable = false)
    private Obstetra obstetra;

    @ManyToOne(optional = false)
    @JoinColumn(name = "especialidad_id", nullable = false)
    private Especialidad especialidad;

    @ManyToOne
    @JoinColumn(name = "establecimiento_id")
    private EstablecimientoSalud establecimiento;

    @Enumerated(EnumType.STRING)
    private TipoAtencion tipoAtencion;

    private LocalDate fechaAtencion;
}
