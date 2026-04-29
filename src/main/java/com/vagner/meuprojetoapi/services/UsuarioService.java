package com.vagner.meuprojetoapi.services;

import com.vagner.meuprojetoapi.models.Usuario;
import com.vagner.meuprojetoapi.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario autenticar(String email, String senha) {
        // Busca o usuário no banco pelo e-mail
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);

        // Se encontrar e a senha bater, retorna o usuário
        if (usuario.isPresent() && usuario.get().getSenha().equals(senha)) {
            return usuario.get();
        }
        return null; // Retorna null se o login falhar
    }
    public List<Usuario> buscarTodos() {
        // O repository já tem o método findAll() por padrão do JPA
        return usuarioRepository.findAll();
    }
}