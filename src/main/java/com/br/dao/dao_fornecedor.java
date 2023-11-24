/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.conexao.ConnectionFactory;
import com.br.models.model_fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class dao_fornecedor {
     private Connection con;
    public dao_fornecedor(){
        this.con = new ConnectionFactory().getConnection();
        
    }
    public void cadastrarfornecedor(model_fornecedor obj){
        try{
            String sql = "insert into tb_fornecedor(nome,cnpj,ie,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)" 
                    +"values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getCnpj());
            stmt.setString(3,obj.getIe());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setString(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getEstado());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
 
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro:"+erro);
        }
        
    }
    public List<model_fornecedor>listarfornecedor(){
        try{
            List<model_fornecedor> lista  = new ArrayList<>();
            String sql = "select * from tb_fornecedor";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                model_fornecedor obj = new model_fornecedor();
                obj.setId_fornecedor(rs.getInt("id_fornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setIe(rs.getString("ie"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                
                lista.add(obj);
                
                
            }
            return lista;
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro:"+ erro);
        
        }
        return null;
        
    }
     public void excluirfornecedor(model_fornecedor obj){
        try{
            String sql = "delete from tb_fornecedor where id_fornecedor = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_fornecedor());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido coom sucesso!");
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro:"+ erro);
        }
    }
    public void alterarfornecedor(model_fornecedor obj){
        
        try{
            String sql = "update tb_fornecedor set nome=?,cnpj=?,ie=?,email=?,telefone=?,celular=?,cep=?,endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id_fornecedor=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2,obj.getCnpj());
            stmt.setString(3,obj.getIe());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setString(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(11,obj.getBairro());
            stmt.setString(12,obj.getCidade());
            stmt.setString(13,obj.getEstado());
            
            stmt.setInt(14, obj.getId_fornecedor());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "ALTERADO COM SUCESSO");
            
            
         } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro"+erro);
        }
        }
     public List<model_fornecedor> buscafornecedor(String nome){
        try{
            List<model_fornecedor> lista = new ArrayList<>();
            String sql = "select * from tb_fornecedor where nome like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            
            
            while(rs.next()){
                model_fornecedor obj = new model_fornecedor();
                
                obj.setId_fornecedor(rs.getInt("id_fornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setIe(rs.getString("ie"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
                
                lista.add(obj);
                
                
            }
            return lista;
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro:"+ erro);
        
        }
        return null;
     }
    
    
    public model_fornecedor consultaPorNome(String nome){
        try{
            String sql = "select * from tb_fornecedor where nome =? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            model_fornecedor obj = new model_fornecedor();
            
            if(rs.next()){
                obj.setId_fornecedor(rs.getInt("id_fornecedor"));
                obj.setNome(rs.getString("nome"));
                obj.setCnpj(rs.getString("cnpj"));
                obj.setIe(rs.getString("ie"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
                
            }
            return obj;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Fornecedor não encontrado!");
            return null;
        }
    }
    
}
