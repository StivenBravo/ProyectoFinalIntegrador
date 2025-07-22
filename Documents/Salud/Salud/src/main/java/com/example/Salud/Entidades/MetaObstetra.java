
package com.example.Salud.Entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metas_obstetra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetaObstetra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "obstetra_id", nullable = false)
    private Obstetra obstetra;

    private int metaPap;
    private int metaIvaa;
    private int metaVph;
    private int metaMama;
    private int metaConsejeria;

    private int anio;
}
