package com.vagner.meuprojetoapi.controllers;

import com.vagner.meuprojetoapi.models.Residuo;
import com.vagner.meuprojetoapi.services.ResiduoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/residuos")
@CrossOrigin(origins = "*") //  aqui vou conseguir fazer a integração com o Front-end futuramente..
public class ResiduoController {

    @Autowired
    private ResiduoService residuoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<Residuo> cadastrar(@RequestBody Residuo residuo) {
        return ResponseEntity.ok(residuoService.salvar(residuo));
    }

    @GetMapping("/todos")
    public ResponseEntity<List<Residuo>> listar() {
        return ResponseEntity.ok(residuoService.buscarTodos());
    }
}