package com.vagner.meuprojetoapi.models;
// Define o pacote onde essa classe está (organização do projeto)

import jakarta.persistence.*;
// Importa as anotações do JPA (usadas para conectar com o banco)

import java.util.Objects;
// Importa a classe usada para comparar objetos (equals e hashCode)

@Entity
// Diz que essa classe representa uma tabela no banco de dados

@Table(name = "tb_usuario")
// Define o nome da tabela no banco (tb_usuario)

public class Usuario {

    @Id
    // Define que esse campo é a chave primária (ID)

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // O banco gera automaticamente o ID (auto incremento)
    private Long id;

    @Column(nullable = false)
    // Campo obrigatório (não pode ser nulo)
    private String nome;

    @Column(nullable = false, unique = true)
    // Campo obrigatório e único (não pode repetir email)
    private String email;

    @Column(nullable = false)
    // Campo obrigatório
    private String senha;

    // ============================
    // NOVOS CAMPOS DO SISTEMA
    // ============================

    private String endereco;
    // Endereço do usuário

    private String tipoEstabelecimento;
    // Tipo de estabelecimento (ex: restaurante, mercado, etc)

    private String tiposResiduos;
    // Tipos de resíduos que ele gera

    // ============================
    // CONSTRUTOR PADRÃO
    // ============================

    public Usuario() {
        // Construtor vazio (obrigatório para o JPA funcionar)
    }

    // ============================
    // GETTERS E SETTERS
    // ============================

    public Long getId() { return id; }
    // Retorna o ID

    public void setId(Long id) { this.id = id; }
    // Define o ID

    public String getNome() { return nome; }
    // Retorna o nome

    public void setNome(String nome) { this.nome = nome; }
    // Define o nome

    public String getEmail() { return email; }
    // Retorna o email

    public void setEmail(String email) { this.email = email; }
    // Define o email

    public String getSenha() { return senha; }
    // Retorna a senha

    public void setSenha(String senha) { this.senha = senha; }
    // Define a senha

    public String getEndereco() { return endereco; }
    // Retorna o endereço

    public void setEndereco(String endereco) { this.endereco = endereco; }
    // Define o endereço

    public String getTipoEstabelecimento() { return tipoEstabelecimento; }
    // Retorna o tipo de estabelecimento

    public void setTipoEstabelecimento(String tipoEstabelecimento) {
        this.tipoEstabelecimento = tipoEstabelecimento;
    }
    // Define o tipo de estabelecimento

    public String getTiposResiduos() { return tiposResiduos; }
    // Retorna os tipos de resíduos

    public void setTiposResiduos(String tiposResiduos) {
        this.tiposResiduos = tiposResiduos;
    }
    // Define os tipos de resíduos

    // ============================
    // EQUALS E HASHCODE
    // ============================

    @Override
    public boolean equals(Object o) {
        // Verifica se é o mesmo objeto
        if (this == o) return true;

        // Verifica se é nulo ou de outra classe
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;
        // Converte o objeto para Usuario

        return Objects.equals(id, usuario.id);
        // Compara os IDs dos usuários
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
        // Gera um código baseado no ID (usado em listas, sets, etc)
    }
}