/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.dao;

import com.br.conexao.ConnectionFactory;
import com.br.models.model_clientepf;
import com.br.models.model_fornecedor;
import com.br.models.model_produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class dao_produto {

    private Connection con;

    public dao_produto() {
        this.con = new ConnectionFactory().getConnection();

    }

    public void cadastrar(model_produto obj) {
        try {
            String sql = "insert into tb_produtos(nome,preco,qtd_estoque,for_id)values(?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getPreco());
            stmt.setDouble(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId_fornecedor());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);

        }

    }

    public List<model_produto> listarproduto() {
        try {
            List<model_produto> lista = new ArrayList<>();
            String sql = "select p.id_produtos,p.nome,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                    + "inner join tb_fornecedor as f on(p.for_id = f.id_fornecedor)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model_produto obj = new model_produto();
                model_fornecedor f = new model_fornecedor();
                obj.setId_produtos(rs.getInt("p.id_produtos"));
                obj.setNome(rs.getString("p.nome"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getDouble("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));

                obj.setFornecedor(f);

                lista.add(obj);

            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }
        return null;

    }

    public void alterar(model_produto obj) {
        try {
            String sql = "update  tb_produtos set nome = ?,preco=?,qtd_estoque=?,for_id=? where id_produtos=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setDouble(2, obj.getPreco());
            stmt.setDouble(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId_fornecedor());
            stmt.setInt(5, obj.getId_produtos());

            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);

        }
    }

    public void excluir(model_produto obj) {
        try {
            String sql = "delete from tb_produtos where id_produtos=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId_produtos());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro:" + e);

        }
    }

    public List<model_produto> buscaproduto(String nome) {

        try {
            List<model_produto> lista = new ArrayList<>();
            String sql = "select p.id_produtos,p.nome,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                    + "inner join tb_fornecedor as f on(p.for_id = f.id_fornecedor)where p.nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                model_produto obj = new model_produto();
                model_fornecedor f = new model_fornecedor();
                obj.setId_produtos(rs.getInt("p.id_produtos"));
                obj.setNome(rs.getString("p.nome"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getDouble("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));

                obj.setFornecedor(f);

                lista.add(obj);

            }
            return lista;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);

        }
        return null;

    }

    public model_produto buscaprodutoporcodigo(int id_produtos) {

        try {

            String sql = "select p.id_produtos,p.nome,p.preco,p.qtd_estoque,f.nome from tb_produtos as p "
                    + "inner join tb_fornecedor as f on(p.for_id = f.id_fornecedor)where p.id_produtos= ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id_produtos);
            ResultSet rs = stmt.executeQuery();
            model_produto obj = new model_produto();
            model_fornecedor f = new model_fornecedor();
            if (rs.next()) {

                obj.setId_produtos(rs.getInt("p.id_produtos"));
                obj.setNome(rs.getString("p.nome"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getDouble("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));

                obj.setFornecedor(f);

            }
            return obj;

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;

        }

    }

    public void baixarEstoque(int id, int qtd_novo) {
        try {
            String sql = "update tb_produtos set qtd_estoque=? where id_produtos=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_novo);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }

    public int retornaEstoqueAtual(int id) {
        try {
            int qtd_estoque = 0;
            String sql = "SELECT qtd_estoque from tb_produtos where id_produtos=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
            return qtd_estoque;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
 public void adicionarEstoque(int id, Double qtd_novo) {
        try {
            String sql = "update tb_produtos set qtd_estoque=? where id_produtos=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setDouble(1, qtd_novo);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
        }
    }
    
}
