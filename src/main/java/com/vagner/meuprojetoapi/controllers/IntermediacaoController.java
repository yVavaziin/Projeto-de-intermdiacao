package com.vagner.meuprojetoapi.controllers;
// Define o pacote onde essa classe está (organização do projeto)
import java.util.List;
import org.springframework.web.bind.annotation.*;
// Importa várias anotações usadas para criar APIs (rotas)

import org.springframework.http.ResponseEntity;
// Classe usada para montar respostas HTTP (status + dados)

import org.springframework.beans.factory.annotation.Autowired;
// Permite que o Spring injete automaticamente objetos (dependências)

import com.vagner.meuprojetoapi.models.Usuario;
// Importa a classe Usuario (modelo de dados)

import com.vagner.meuprojetoapi.services.UsuarioService;
// Importa o serviço que contém a lógica do usuário

@RestController
// Diz que essa classe é um controlador REST (API)

@RequestMapping("/api/usuarios")
// Define o caminho base da API (todas as rotas começam com isso)

@CrossOrigin(origins = "*")
// Permite que qualquer site acesse essa API (evita erro de CORS)

public class IntermediacaoController {

    @Autowired
    // O Spring cria automaticamente o objeto UsuarioService
    private UsuarioService usuarioService;

    // ============================
    // ROTA DE CADASTRO
    // ============================

    @PostMapping("/cadastrar")
    // Define uma rota POST em: /api/usuarios/cadastrar
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {

        // Recebe os dados enviados no corpo da requisição (JSON)
        // e transforma em um objeto Usuario

        Usuario novoUsuario = usuarioService.salvar(usuario);
        // Chama o service para salvar o usuário no sistema

        return ResponseEntity.ok(novoUsuario);
        // Retorna status 200 (OK) junto com o usuário criado
    }

    // ============================
    // ROTA DE LOGIN
    // ============================

    @PostMapping("/login")
    // Define uma rota POST em: /api/usuarios/login
    public ResponseEntity<?> login(@RequestBody Usuario loginData) {

        // Recebe email e senha enviados no corpo da requisição
        Usuario usuario = usuarioService.autenticar(
                loginData.getEmail(),
                loginData.getSenha()
        );
        // Chama o service para verificar se o usuário existe

        if (usuario != null) {
            // Se encontrou o usuário (login válido)

            return ResponseEntity.ok(usuario);
            // Retorna status 200 com os dados do usuário

        } else {
            // Se não encontrou (login inválido)

            return ResponseEntity.status(401).body("E-mail ou senha incorretos");
            // Retorna erro 401 (não autorizado) com mensagem
        }
    }
    // ============================
    // ROTA DE LISTAGEM TOTAL
    // ============================

    @GetMapping("/todos")
    // Define uma rota GET em: /api/usuarios/todos
    public ResponseEntity<List<Usuario>> listarTodos() {

        // Chama o service para buscar a lista completa no banco
        List<Usuario> lista = usuarioService.buscarTodos();

        // Retorna status 200 (OK) com a lista de usuários
        return ResponseEntity.ok(lista);
    }
}