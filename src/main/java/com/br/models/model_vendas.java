/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.models;

/**
 *
 * @author USER
 */
public class model_vendas {
    private int id_vendas;
    private model_clientepf cliente;
    private String data_venda;
    private Double total_venda;
    private model_funcionario funcionario;

    public int getId_vendas() {
        return id_vendas;
    }

    public void setId_vendas(int id_vendas) {
        this.id_vendas = id_vendas;
    }

    public model_clientepf getCliente() {
        return cliente;
    }

    public void setCliente(model_clientepf cliente) {
        this.cliente = cliente;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    public Double getTotal_venda() {
        return total_venda;
    }

    public void setTotal_venda(Double total_venda) {
        this.total_venda = total_venda;
    }

    public model_funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(model_funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
    
    
    
    
}
