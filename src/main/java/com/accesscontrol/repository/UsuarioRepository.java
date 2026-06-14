package com.accesscontrol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accesscontrol.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
