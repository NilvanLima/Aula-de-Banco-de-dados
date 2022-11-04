package com.mycompany.aulabancodados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//classe especifica para a conexão com o banco de dados, nessa classe definimos a String de conexão com o banco de dados, usando a biblioteca DriverManager do MySQL
public class ConnectionFactory {
    private String usuario = "root";
    private String senha = "senha";
    private String host = "localhost";
    private String porta = "3306";
    private String bd = "db_pessoas";
    
    public Connection obtemConexao(){
        try{
            //"jdbc:mysql://localhost:3306/db_pessoas" caso a gente não contatenassemos 
            Connection c = DriverManager.getConnection("jdbc:mysql://" + host + ":" + porta + "/" + bd, usuario, senha);
            //um objeto recebe o valor de uma outra classe acima
            return c;
        }catch(SQLException e){
            return null;
        }
    }
}
