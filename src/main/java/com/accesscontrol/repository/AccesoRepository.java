package com.accesscontrol.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesscontrol.model.Acceso;

public interface AccesoRepository extends JpaRepository<Acceso, Long> {
    List<Acceso> findByUsuarioId(Long usuario);
    List<Acceso> findByTipo(String tipo);
    List<Acceso> findByEstado(String estado);
    List<Acceso> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);
}
