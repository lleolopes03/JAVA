/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.conexao.ConnectionFactory;
import com.br.models.model_clientepf;
import com.br.models.model_funcionario;

import com.br.models.model_vendas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class dao_vendas {
     private Connection con;
    public dao_vendas(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    
    public void cadastrarvenda(model_vendas obj){
        try{
            String sql = "insert into tb_vendas(cliente_id,data_venda,total_venda,funcionarios_id)values(?,?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCliente().getId_clientes());
            stmt.setString(2, obj.getData_venda());
            stmt.setDouble(3, obj.getTotal_venda());
            stmt.setInt(4, obj.getFuncionario().getId_funcionarios());
            
            stmt.execute();
            stmt.close();
            
            
        }catch (Exception e ){
            JOptionPane.showMessageDialog(null,"Erro:"+ e);
            
        }
        
    
    
}
    public int retornaUltimaVenda(){
            try{
                int idvenda = 0;
                
                String sql = "select max(id_vendas)id_vendas from tb_vendas";
                PreparedStatement ps = con.prepareStatement(sql);
                
                ResultSet rs = ps.executeQuery();
                
                if(rs.next()){
                    model_vendas p = new model_vendas();
                    p.setId_vendas(rs.getInt("id_vendas"));
                    idvenda = p.getId_vendas();
                    
                }
                return idvenda;
                
                
                
            }catch(SQLException e ){
                throw new RuntimeException(e);
                
            }
        }
   
     public List<model_vendas> listarVendasPorPeriodo(LocalDate data_inicio,LocalDate data_fim) {

        try {
            List<model_vendas> lista = new ArrayList<>();
            String sql = "select v.id_vendas,date_format(v.data_venda,'%d/%m/%y')as data_formatada,c.nome,v.total_venda,f.nome from tb_vendas as v "
                    + "inner join tb_clientes as c on(v.cliente_id = c.id_clientes) "
                    + "inner join tb_funcionarios as f on(v.funcionarios_id = f.id_funcionarios)where v.data_venda BETWEEN?AND?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_inicio.toString());
            stmt.setString(2, data_fim.toString());
            
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model_vendas obj = new model_vendas();
                model_clientepf c = new model_clientepf();
                model_funcionario f = new model_funcionario();
                obj.setId_vendas(rs.getInt("v.id_vendas"));
                obj.setData_venda(rs.getString("data_formatada"));
                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));

                f.setNome(rs.getString("f.nome"));

                obj.setCliente(c);
                obj.setFuncionario(f);

                lista.add(obj);

            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }
        return null;

    }
     
     public Double retornarTotalVendaPorData(LocalDate data_venda){
         try{
             double totalvenda = 0;
             String sql = "select sum(total_venda)as total from tb_vendas where data_venda=?";
              PreparedStatement ps = con.prepareStatement(sql);
              ps.setString(1,data_venda.toString());
              
              ResultSet rs =ps.executeQuery();
              if(rs.next()){
                  totalvenda = rs.getDouble("total");
              }
             return totalvenda;
         }catch(Exception e ){
           throw new RuntimeException(e);  
         }
     }
}
