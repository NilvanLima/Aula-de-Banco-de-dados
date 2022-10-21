package com.mycompany.aulabancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Pessoa {
    private int codigo;
    private String nome;
    private String fone;
    private String email;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getFone() {
        return fone;
    }

    public String getEmail() {
        return email;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void inserir(){
        //1: Definir o comando do SQL
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?,?,?)";
        
        //2: Abrir uma conexão com o banco de dados
        ConnectionFactory factory = new ConnectionFactory();
        try(Connection c = factory.obtemConexao()){
            
            //3: Pré compila o comando
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4: Preenchimento de dados 
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            
            //5: executar o no MySQL
            ps.execute();
        }catch(Exception e){
            //essa exception só conseguimos usar no catch
            
        }
    }
}
