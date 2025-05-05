package com.coudevi.domain.repository;

import com.coudevi.domain.entity.Solicitud;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISolicitudRepository extends JpaRepository<Solicitud, Long> {
}
