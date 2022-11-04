package com.mycompany.aulabancodados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

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
        //as interrogações são placeholders, que o MySQL vai entender como valores que serão colocados  
        String sql = "INSERT INTO tb_pessoa(nome, fone, email) VALUES (?,?,?)";
        
        //2: Abrir uma conexão com o banco de dados
        ConnectionFactory factory = new ConnectionFactory();
        
        //outro objeto
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
    public void atualizar(){
        //1-Definir o comando SQL
        String sql = "UPDATE tb_pessoa SET nome = ?, fone = ?, email = ? WHERE codigo = ?";
        //atualize a tabela pessoa onde o nome, fone, email onde o código seja =
        
        //2-Abrir uma conexão
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            //pré compilamento
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4- prrenche os dados nos place holders
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            ps.setInt(4, codigo);
            
            //5- executar o comando SQL
            ps.execute();
            
        }catch(Exception e){
            
        }
    }
    public void deletar(){
        //1-Definir o comando SQL
        String sql = "DELETE FROM tb_pessoa WHERE codigo = ?";
        
        //2- Abrir uma conexão 
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            //3- Pré compilamento do código SQL
            PreparedStatement ps = c.prepareStatement(sql);
            
            //4-Preencher os place holders
            ps.setInt(1, codigo);
            
            //5- Executar o comando
            ps.execute();
            
        }catch(Exception e){
            
        }
    }
    public void listar(){
        //1-Definir o comando SQL
        String sql = "SELECT * FROM tb_pessoa";
        
        //2- Abrir uma conexão 
        ConnectionFactory factory = new ConnectionFactory();
        
        try(Connection c = factory.obtemConexao()){
            
            //3- Pré compilamento
            PreparedStatement ps = c.prepareStatement(sql);
            
            //importar a classe ResultSet
            ResultSet rs = ps.executeQuery();
            
            //enquanto existir um próximo valor ler os itens da lista
            while(rs.next()){
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String fone = rs.getString("fone");
                String email = rs.getString("email");
                
                String aux = String.format("Código: %d, Nome: %s, Fone: %s, Email: %s", codigo, nome, fone, email);
                //String aux = "Código: " + codigo + "Nome: " + nome;
                JOptionPane.showMessageDialog(null, aux);
            }
            
        }catch(Exception e){
            
        }
    }
}
