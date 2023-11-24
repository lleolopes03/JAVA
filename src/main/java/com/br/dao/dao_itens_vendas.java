/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.conexao.ConnectionFactory;
import com.br.models.model_clientepf;
import com.br.models.model_funcionario;
import com.br.models.model_itens_vendas;
import com.br.models.model_produto;
import com.br.models.model_vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class dao_itens_vendas {
    private Connection con;
    public dao_itens_vendas(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    public void cadastraitem(model_itens_vendas obj){
         try{
            String sql = "insert into tb_itensvendas(vendas_id,produto_id,qtd,subtotal)values(?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getVenda().getId_vendas());
            stmt.setInt(2, obj.getProduto().getId_produtos());
            stmt.setDouble(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());
            
            stmt.execute();
            stmt.close();
            
            
        }catch (Exception e ){
            JOptionPane.showMessageDialog(null,"Erro:"+ e);
            
        }
        
    
    

    }
    
  public List<model_itens_vendas> listarItensPorVenda(int venda_id) {

        try {
            List<model_itens_vendas> lista = new ArrayList<>();
            String sql = "select i.id_itens_vendas,p.nome,i.qtd,p.preco,i.subtotal from tb_itensvendas as i "
                    + "inner join tb_produtos as p on(i.produto_id =p.id_produtos)where i.vendas_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, venda_id);
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model_itens_vendas item = new model_itens_vendas();
                model_produto prod = new model_produto();
                
                item.setId_itens_vendas(rs.getInt("i.id_itens_vendas"));
                prod.setNome(rs.getString("p.nome"));
                item.setQtd(rs.getDouble("i.qtd"));
                prod.setPreco(rs.getDouble("p.preco"));
                item.setSubtotal(rs.getDouble("i.subtotal"));
                item.setProduto(prod);
                
                
               
                
                
                
                lista.add(item);

            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }
        return null;

    }   
    
}
