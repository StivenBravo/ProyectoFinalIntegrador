
package com.example.Salud.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "establecimientos_salud")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EstablecimientoSalud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "codigo_renace", nullable = false, unique = true)
    private String codigoRenace;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String categoria;
}
