package com.faculdade.linguagem_programacao.lab11;

public class Conta{
    
    //atributos
    private String codigo;
    private String nome;
    private String senha;
    private String endereco;
    private double saldo;

    //construtor com todos os parametros
    public Conta( String c, String n,String se, String e, double v){
       codigo = c;
       nome = n;
       senha=se;
       endereco=e;
       saldo = v;
    }
    
    //construtor vazio
    public Conta(){
    }
    
    //métodos de acesso
    public String getCodigo() { 
        return codigo;
    }
    
    public String getNome() { 
        return nome;
    }
    
    public String getSenha() { 
        return senha;
    }
    
    public String getEndereco() { 
        return endereco;
    }
    
    public double getSaldo() { 
        return saldo;
    }
    
    public void setCodigo(String c) { 
        codigo = c;
    }
    
     public void setNome(String n){
        nome = n;
    }
    
     public void setSenha(String se){
        senha = se;
    }
     
    public void setEndereco(String e){
        endereco = e;
    }
  
    public void setSaldo(double v) { 
        saldo = v;
    }
    
}