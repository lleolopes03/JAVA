/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.conexao.ConnectionFactory;
import com.br.models.model_clientepf;

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
public class dao_clientepf {
    
    private Connection con;
    public dao_clientepf(){
        this.con = new ConnectionFactory().getConnection();  
    }
    public void cadastrarclientepf(model_clientepf obj){
        try{
            String sql = "insert into tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,nascimento,naturalidade)"
                    
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
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
            stmt.setString(14,obj.getNascimento());
            stmt.setString(15,obj.getNaturalidade());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "CADASTRADO COM SUCESSO");
            
            
         } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro"+erro);
        }
        
    }
    
    public List<model_clientepf>listarclientespf(){
        try{
            List<model_clientepf> lista  = new ArrayList<>();
            String sql = "select * from tb_clientes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                model_clientepf obj = new model_clientepf();
                obj.setId_clientes(rs.getInt("id_clientes"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
                obj.setNascimento(rs.getString("nascimento"));
                obj.setNaturalidade(rs.getString("naturalidade"));
                
                lista.add(obj);
                
                
            }
            return lista;
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro:"+ erro);
        
        }
        return null;
        
    }
    
    public void excluirClientepf(model_clientepf obj){
        try{
            String sql = "delete from tb_clientes where id_clientes = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_clientes());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido coom sucesso!");
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro:"+ erro);
        }
    }
    public void alterarClientepf(model_clientepf obj){
        try{
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, nascimento=?, naturalidade=? where id_clientes=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
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
            stmt.setString(14,obj.getNascimento());
            stmt.setString(15,obj.getNaturalidade());
            stmt.setInt(16, obj.getId_clientes());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "AlTERADO COM SUCESSO");
            
            
         } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro"+erro);
        }
        }
    
    public List<model_clientepf>buscaClientepf(String nome){
        try{
            
            List<model_clientepf> lista  = new ArrayList<>();
            String sql = "select * from tb_clientes where nome like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                model_clientepf obj = new model_clientepf();
                obj.setId_clientes(rs.getInt("id_clientes"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
                obj.setNascimento(rs.getString("nascimento"));
                obj.setNaturalidade(rs.getString("naturalidade"));
                
                lista.add(obj);
                
                
            }
            return lista;
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Erro:"+ erro);
        
        }
        return null;
        
     }
      public model_clientepf buscaClientepfcpf(String cpf){
        try{
            
            
            String sql = "select * from tb_clientes where cpf=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();
             model_clientepf obj = new model_clientepf();
            if(rs.next()){
               
                obj.setId_clientes(rs.getInt("id_clientes"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
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
                obj.setNascimento(rs.getString("nascimento"));
                obj.setNaturalidade(rs.getString("naturalidade"));
                
                
                
                
            }
            return obj;
            
        }catch(Exception erro){
            JOptionPane.showMessageDialog(null,"Cliente não encontrado!");
        return null;
        }
        
        
     }
    
}
