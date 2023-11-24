/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.models;

/**
 *
 * @author USER
 */
public class model_itens_vendas {
    private int id_itens_vendas;
    private model_vendas venda;
    private model_produto produto;
    private Double qtd;
    private Double subtotal;

    public int getId_itens_vendas() {
        return id_itens_vendas;
    }

    public void setId_itens_vendas(int id_itens_vendas) {
        this.id_itens_vendas = id_itens_vendas;
    }

    public model_vendas getVenda() {
        return venda;
    }

    public void setVenda(model_vendas venda) {
        this.venda = venda;
    }

    public model_produto getProduto() {
        return produto;
    }

    public void setProduto(model_produto produto) {
        this.produto = produto;
    }

    public Double getQtd() {
        return qtd;
    }

    public void setQtd(Double qtd) {
        this.qtd = qtd;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
