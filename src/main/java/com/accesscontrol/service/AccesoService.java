package com.accesscontrol.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesscontrol.dto.AccesoRequestDTO;
import com.accesscontrol.model.Acceso;
import com.accesscontrol.model.Usuario;
import com.accesscontrol.repository.AccesoRepository;
import com.accesscontrol.repository.UsuarioRepository;

@Service
public class AccesoService {

    private final AccesoRepository repository;

    public AccesoService(AccesoRepository repository) {
        this.repository = repository;
    }

    public Acceso guardar(Acceso acceso) {
        return repository.save(acceso);
    }

    public List<Acceso> listar() {
        return repository.findAll();
    }

    public List<Acceso> porUsuario(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }

    public List<Acceso> porRangoFecha(LocalDateTime inicio, LocalDateTime fin){
        return repository.findByFechaHoraBetween(inicio, fin);
    }

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Acceso guardarDesdeDTO(AccesoRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Acceso acceso = new Acceso();
        acceso.setUsuario(usuario);
        acceso.setTipo(dto.getTipo());
        acceso.setPuntoAcceso(dto.getPuntoAcceso());
        acceso.setEstado(dto.getEstado());
        acceso.setFechaHora(LocalDateTime.now());

        return repository.save(acceso);
    }
}