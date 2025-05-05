package com.coudevi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    @Column(name = "nombre_completo",nullable = false, length = 100, unique = true)
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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_name")
    )
    private Set<Rol> roles;
}