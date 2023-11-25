/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.br.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Leandro Lopes
 */
public class ConnectionFactory {
    
    
        public Connection getConnection(){
           try{
               return DriverManager.getConnection("jdbc:mysql://localhost/lglsystems","root","lion250393");
           } catch(Exception erro ){
               throw new RuntimeException(erro);
           }
        }
    
    
}
