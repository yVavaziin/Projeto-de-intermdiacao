package com.vagner.meuprojetoapi.repositories;

import com.vagner.meuprojetoapi.models.Residuo; // <--- Importa Residuo
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResiduoRepository extends JpaRepository<Residuo, Long> {
    // Este cuida da tabela de Resíduos
}