package com.vagner.meuprojetoapi.models;

import jakarta.persistence.*;
import java.time.LocalDateTime; // Para trabalhar com datas e horas

@Entity
@Table(name = "tb_residuo")
public class Residuo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // Ex: "Orgânico", "Plástico", "Vidro"
    private Double quantidade; // Usamos Double para aceitar quilos (ex: 10.5 kg)

    private LocalDateTime dataColeta; // Armazena a data e a hora exata

    public Residuo() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Double getQuantidade() { return quantidade; }
    public void setQuantidade(Double quantidade) { this.quantidade = quantidade; }

    public LocalDateTime getDataColeta() { return dataColeta; }
    public void setDataColeta(LocalDateTime dataColeta) { this.dataColeta = dataColeta; }
}