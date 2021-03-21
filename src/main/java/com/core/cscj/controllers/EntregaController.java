package com.core.cscj.controllers;

import com.core.cscj.models.entities.Devolucion;
import com.core.cscj.models.responses.EntregaResponse;
import com.core.cscj.services.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping(value="/{idEntrega}/devolucion")
    public EntregaResponse upsertDevolucion(@PathVariable("idEntrega") Integer idEntrega,
                                            @RequestBody Devolucion devolucion) {
        return entregaService.upsertEntregaDevolucion(idEntrega, devolucion);
    }

    @GetMapping(value="/{idEntrega}/devolucion")
    public Devolucion getDevolucionFromEntrega(@PathVariable("idEntrega") Integer idEntrega) {
        return entregaService.findEntregaDevolucion(idEntrega);
    }
}
