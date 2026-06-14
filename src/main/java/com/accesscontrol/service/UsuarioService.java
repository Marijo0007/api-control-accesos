package com.accesscontrol.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.accesscontrol.model.Usuario;
import com.accesscontrol.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listar() {
        return repository.findAll();
    }
}