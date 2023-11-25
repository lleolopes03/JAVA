/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.conexao.ConnectionFactory;
import com.br.models.model_clientepf;
import com.br.models.model_funcionario;
import com.br.views.view_menu;

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
public class dao_funcionario {
      private Connection con;
    public dao_funcionario(){
        this.con = new ConnectionFactory().getConnection();  
    }
    public void cadastrarfuncionario(model_funcionario obj){
        try{
            String sql = "insert into tb_funcionarios(nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado,nascimento,naturalidade)" 
                    +"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8,obj.getTelefone());
            stmt.setString(9,obj.getCelular());
            stmt.setString(10,obj.getCep());
            stmt.setString(11,obj.getEndereco());
            stmt.setString(12,obj.getNumero());
            stmt.setString(13,obj.getComplemento());
            stmt.setString(14,obj.getBairro());
            stmt.setString(15,obj.getCidade());
            stmt.setString(16,obj.getEstado());
            stmt.setString(17,obj.getNascimento());
            stmt.setString(18,obj.getNaturalidade());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
 
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro:"+erro);
        }
        
    }
    public List<model_funcionario>listarfuncionario(){
        try{
            List<model_funcionario> lista  = new ArrayList<>();
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                model_funcionario obj = new model_funcionario();
                obj.setId_funcionarios(rs.getInt("id_funcionarios"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
     public void excluirfuncionario(model_funcionario obj){
        try{
            String sql = "delete from tb_funcionarios where id_funcionarios = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_funcionarios());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido coom sucesso!");
        } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro:"+ erro);
        }
    }
    public void alterarfuncionario(model_funcionario obj){
        try{
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?,senha=?,cargo=?,nivel_acesso=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=?, nascimento=?, naturalidade=? where id_funcionarios=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getSenha());
            stmt.setString(6,obj.getCargo());
            stmt.setString(7,obj.getNivel_acesso());
            stmt.setString(8,obj.getTelefone());
            stmt.setString(9,obj.getCelular());
            stmt.setString(10,obj.getCep());
            stmt.setString(11,obj.getEndereco());
            stmt.setString(12,obj.getNumero());
            stmt.setString(13,obj.getComplemento());
            stmt.setString(14,obj.getBairro());
            stmt.setString(15,obj.getCidade());
            stmt.setString(16,obj.getEstado());
            stmt.setString(17,obj.getNascimento());
            stmt.setString(18,obj.getNaturalidade());
            stmt.setInt(19, obj.getId_funcionarios());
            
            
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "AlTERADO COM SUCESSO");
            
            
         } catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"Erro"+erro);
        }
        }
     public List<model_funcionario>buscafuncionario(String nome){
        try{
            
            List<model_funcionario> lista  = new ArrayList<>();
            String sql = "select * from tb_funcionarios where nome like?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                model_funcionario obj = new model_funcionario();
                obj.setId_funcionarios(rs.getInt("id_funcionarios"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
      public model_funcionario buscafuncionariocodigo(int id_funcionarios){
        try{
            
            List<model_funcionario> lista  = new ArrayList<>();
            String sql = "select * from tb_funcionarios where id_funcionarios=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_funcionarios);
            ResultSet rs = stmt.executeQuery();
            model_funcionario obj = new model_funcionario();
            if(rs.next()){
                
                obj.setId_funcionarios(rs.getInt("id_funcionarios"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
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
            JOptionPane.showMessageDialog(null,"Funcionario não encontrado!");
        
        }
        return null;
        
     }
      
      public void efetuaLogin(String email, String senha){
          
          try{
              String sql = "select * from tb_funcionarios where email=?and senha=?";
              PreparedStatement stmt = con.prepareStatement(sql);
              stmt.setString(1, email);
              stmt.setString(2, senha);
              
              ResultSet rs = stmt.executeQuery();
              
              if(rs.next()){
                  if(rs.getString("nivel_acesso").equals("ADMIN")){
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!");
                  view_menu tela = new view_menu();
                  tela.usuariologado = rs.getString("nome");
                  tela.setVisible(true); 
                  }
                  else if(rs.getString("nivel_acesso").equals("USUARIO")){
                  JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema!");
                  view_menu tela = new view_menu();
                  tela.usuariologado = rs.getString("nome");
                  tela.menu_clientes.setEnabled(false);
                  tela.menu_fornecedores.setEnabled(false);
                  tela.menu_produtos.setEnabled(false);
                  tela.setVisible(true);    
                      
                  }
                  
                  
                
                  
              }else{
                  JOptionPane.showMessageDialog(null, "Dados incorretos!");
                  
              }
          }catch(SQLException erro ){
              JOptionPane.showMessageDialog(null, "Erro:"+erro);
          }
          
      }
    
    
    
}
