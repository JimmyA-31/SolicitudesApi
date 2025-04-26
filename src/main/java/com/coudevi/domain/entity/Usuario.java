package com.coudevi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;
    @Column(name = "nombre_completo",nullable = false, length = 100)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String correo;
    @Column(nullable = false, length = 50)
    private String contrasena;
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
    @ManyToOne
    @JoinColumn(name = "id_area")
    private Area area;

}