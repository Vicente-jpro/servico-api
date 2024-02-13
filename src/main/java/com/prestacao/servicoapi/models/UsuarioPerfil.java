package com.prestacao.servicoapi.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import com.prestacao.servicoapi.enums.GeneroEnum;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario_perfil")
public class UsuarioPerfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telemovel1")
    private String telemovel1;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private GeneroEnum genero;

    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
