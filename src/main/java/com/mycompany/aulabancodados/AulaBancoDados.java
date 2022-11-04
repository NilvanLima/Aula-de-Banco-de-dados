package com.mycompany.aulabancodados;

import javax.swing.JOptionPane;

public class AulaBancoDados {

    public static void main(String[] args) {
        String menu = "1-Cadastrar\n2-Atualizar\n3-Apagar\n4-Listar\n0-Sair";
        int op;
        do{
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op){
                case 1:{
                    String nome = JOptionPane.showInputDialog("Qual é o nome?");
                    String fone = JOptionPane.showInputDialog("Qual é o telefone?");
                    String email = JOptionPane.showInputDialog("Qual é o email?");
                         
                    Pessoa p = new Pessoa();
                    p.setNome(nome);
                    p.setFone(fone);
                    p.setEmail(email);
                 
                    p.inserir();
                 break;
                }                    
                case 2:{
                    String nome = JOptionPane.showInputDialog("Qual é o nome?");
                    String fone = JOptionPane.showInputDialog("Qual é o telefone?");
                    String email = JOptionPane.showInputDialog("Qual é o email?");
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual é o código?"));
                 
                    Pessoa p = new Pessoa();
                    
                    p.setNome(nome);
                    p.setFone(fone);
                    p.setEmail(email);
                    p.setCodigo(codigo);
                    
                    p.atualizar();
                 
                 break;   
                }                    
                case 3:{
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Qual é o código?"));                    
                    Pessoa p = new Pessoa();                   
                    p.setCodigo(codigo);
                    p.deletar();
                    
                    break;   
                }                    
                case 4:{
                    Pessoa p = new Pessoa();
                    p.listar();
                    
                    break;   
                }                    
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida");
            }
        }while(op != 0);
    }
}
