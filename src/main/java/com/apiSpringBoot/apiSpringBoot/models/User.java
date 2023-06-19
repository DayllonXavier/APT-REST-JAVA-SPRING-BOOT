package com.apiSpringBoot.apiSpringBoot.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nomeCompleto;
    @Column(nullable = false)
    private String nomeSocial;
    private String dataNasc;
    @Column(unique = true, nullable = false)
    private Long codigo;
    @Column(nullable = true)
    private String sexo;
    @Column(nullable = false)
    private String email;
    private String estado;
    private String municipio;
    //@Column(nullable = false, columnDefinition = "default 0")
    @Value("0")
    private Long numAcessos;
    private String situacao;
    @Column(nullable = false)
    private String dataVinculo;

    public User(){
    }

    public User(Long id, String nomeCompleto, String nomeSocial, String dataNasc, Long codigo, String sexo, String email, String estado, String municipio, Long numAcessos, String situacao, String dataVinculo) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.dataNasc = dataNasc;
        this.codigo = codigo;
        this.sexo = sexo;
        this.email = email;
        this.estado = estado;
        this.municipio = municipio;
        this.numAcessos = numAcessos;
        this.situacao = situacao;
        this.dataVinculo = dataVinculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public Long getNumAcessos() {
        return numAcessos;
    }

    public void setNumAcessos(Long numAcessos) {
        this.numAcessos = numAcessos;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDataVinculo() {
        return dataVinculo;
    }

    public void setDataVinculo(String dataVinculo) {
        this.dataVinculo = dataVinculo;
    }
}
