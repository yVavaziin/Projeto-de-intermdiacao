package com.vagner.meuprojetoapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vagner.meuprojetoapi.models.Empresa;
import com.vagner.meuprojetoapi.repositories.EmpresaRepository;

@RestController
@RequestMapping("/empresas")
@CrossOrigin(origins = "*")
public class EmpresController {

    @Autowired
    private EmpresaRepository empresaRepository;

    // 🔹 LISTAR TODAS AS EMPRESAS
    @GetMapping
    public List<Empresa> listarEmpresas() {
        return empresaRepository.findAll();
    }

    // 🔹 CADASTRAR EMPRESA
    @PostMapping
    public Empresa cadastrarEmpresa(@RequestBody Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    // 🔹 DELETAR EMPRESA
    @DeleteMapping("/{id}")
    public void deletarEmpresa(@PathVariable Long id) {
        empresaRepository.deleteById(id);
    }
}