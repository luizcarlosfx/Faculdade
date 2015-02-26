/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.compiladores.trabalhov2;


/**
 *
 * @author professores
 */

public class Reversa2 {

    /**
     * @param args the command line arguments
     */
    private String expressao;
    private int p = -1;
    private int  tam;
    private String prox;
    private int linha;
    
    private String proximo_caracter() {
        p++;   
        if (p >= tam) return null;   // Retorna null se for fim da string
        return expressao.charAt(p) + "";
    }
    
    private boolean digito(String s) {//testa se é um dígito
        
        return (s != null) && (s.charAt(0) >= '0') && (s.charAt(0)<= '9');
    }
    
    private boolean letra(String s) { //Testa se é letra
        return (s!=null) && ((s.charAt(0) >= 'a') && (s.charAt(0)<= 'z')) ||
                ((s.charAt(0) >= 'A') && (s.charAt(0)<= 'Z'));
    }
    
    private  boolean branco(String s) {//Testa se é branco
        
        return (s != null) && ((s.charAt(0) == ' ') || (s.charAt(0) == '\t') || 
                (s.charAt(0) == '\n'));
    }
    
    public cToken analex() {
        String x;
        
        if (prox == null) return null; 
        
        //Remove brancos
        while (branco(prox)) {
            prox = proximo_caracter();
            if (prox.equals(" ") || prox.equals("\t")) {
                
            } else if (prox.equals("\n")) {
                linha++;
            } else {
                break;
            }
        }
        
        //Trata números
        if (digito(prox)) {
            x = "";
            do {
                x += prox;
                prox = proximo_caracter();
            } while (digito(prox));
            
            return new cToken(x,"num");
        }
        //Trata strings de letras
        if (letra(prox)) {
            x = "";
            do {
                x += prox;
                prox = proximo_caracter();
            } while (letra(prox)||digito(prox));
            
            return new cToken(x,"id");
        }
        if (prox.equals("+")) {
            prox = proximo_caracter();
            return new cToken("","+");
        }
        if (prox.equals("-")) {
            prox = proximo_caracter();
            return new cToken("","-");
        }
        if (prox.equals("*")) {
            prox = proximo_caracter();
            return new cToken("","*");
        }
        if (prox.equals("/")) {
            prox = proximo_caracter();
            return new cToken("","/");
        }
        if (prox.equals("(")) {
            prox = proximo_caracter();
            return new cToken("","(");
        }
        if (prox.equals(")")) {
            prox = proximo_caracter();
            return new cToken("",")");
        }
        return null;
    }
    
    public Reversa2(String expressao)
	{
		this.expressao = expressao;
		this.prox = " ";
		this.tam = expressao.length();
	}
    
    /*public static void main(String[] args) {
        // TODO code application logic here
        
        cToken t;
        
        X = "2*(idade + 3)/123";
        
        
        //Valores iniciais para entrar no analex.
        prox=" ";
        p = -1;
        tam = X.length();
        
        //Identifica todas as tokens na string X.
        do {
            t = analex();
            if (t == null) break;
            System.out.println("token= " + t);
            
        } while (true);
        
    }*/
}
