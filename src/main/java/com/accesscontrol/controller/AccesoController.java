package com.accesscontrol.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accesscontrol.dto.AccesoRequestDTO;
import com.accesscontrol.model.Acceso;
import com.accesscontrol.service.AccesoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/accesos")
public class AccesoController {

    private final AccesoService service;

    public AccesoController(AccesoService service) {
        this.service = service;
    }

    @PostMapping
    public Acceso crear(@RequestBody Acceso acceso) {
        return service.guardar(acceso);
    }

    @GetMapping
    public List<Acceso> listar() {
        return service.listar();
    }

    @GetMapping("/usuario/{id}")
    public List<Acceso> porUsuario(@PathVariable Long id) {
        return service.porUsuario(id);
    }

    @GetMapping("/rango")
    public List<Acceso> porRangoFecha(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return service.porRangoFecha(inicio, fin);
    }
    @PostMapping("/dto")
    public Acceso crearDesdeDTO(@RequestBody AccesoRequestDTO dto) {
        return service.guardarDesdeDTO(dto);
    }
}