package com.coudevi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "solicitud")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Long id;
    @ManyToOne
    @Column(name = "id_usuario")
    private Usuario usuario;
    @Column(name="fecha_inicio", nullable = false)
    private LocalDate fechaInicio;
    @Column(name="fecha_fin", nullable = false)
    private LocalDate fechaFin;
    @Column(nullable = false, length = 100)
    private String motivo;
    @Column(nullable = false, length = 20)
    private String estado;
    @Column(nullable = false, length = 200)
    private String observaciones;
    @Column(name="fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;
    @Column(name="fecha_resolucion", nullable = false)
    private LocalDate fechaResolucion;
    @ManyToOne
    @Column(name = "revisado_por")
    private Usuario revisadopor;
}
