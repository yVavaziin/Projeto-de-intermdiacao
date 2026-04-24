package com.vagner.meuprojetoapi.services;

import com.vagner.meuprojetoapi.models.Empresa;
import com.vagner.meuprojetoapi.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa salvar(Empresa empresa) {
        // Você poderia adicionar uma lógica aqui para validar o CNPJ
        return empresaRepository.save(empresa);
    }
}