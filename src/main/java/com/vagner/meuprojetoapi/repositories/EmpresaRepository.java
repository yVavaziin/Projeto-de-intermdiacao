package com.vagner.meuprojetoapi.repositories;

import com.vagner.meuprojetoapi.models.Empresa; // <--- Importa Empresa
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Agora este repositório cuida da tabela de Empresas
}