package com.vagner.meuprojetoapi.repositories;

import com.vagner.meuprojetoapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // O Spring gera o SQL automaticamente para buscar por e-mail
    Optional<Usuario> findByEmail(String email);
}