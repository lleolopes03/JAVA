/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.models;

/**
 *
 * @author USER
 */
public class model_produto {
    private int id_produtos;
    private String nome;
    private Double preco;
    private Double qtd_estoque;
    private model_fornecedor fornecedor;

    public int getId_produtos() {
        return id_produtos;
    }

    public void setId_produtos(int id_produtos) {
        this.id_produtos = id_produtos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQtd_estoque() {
        return qtd_estoque;
    }

    public void setQtd_estoque(Double qtd_estoque) {
        this.qtd_estoque = qtd_estoque;
    }

    public model_fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(model_fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
