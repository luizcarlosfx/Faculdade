package com.faculdade.computacaografica.lab5;
// Exemplo de uso da classe Graphics
// Adaptado do original de Frans Coenen
// Dept. of Comp. Sci., University of Liverpool
import java.awt.*; // Font, Color
import javax.swing.*;

class Painel extends JPanel {

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(50, 50, 60, 60); // Cabeça
        g.drawRect(80, 225, 140, 5); // Cauda
        g.setColor(Color.white);
        g.fillOval(20, 110, 120, 120); // corpo é um circulo branco
        g.setColor(Color.black);
        g.drawOval(20, 110, 120, 120); // circunferencia do corpo em preto
        g.fillOval(75, 75, 10, 10); // nariz
        g.setColor(Color.blue);
        g.fillOval(60, 60, 10, 10); // olhos
        g.fillOval(90, 60, 10, 10);
        g.setColor(Color.black);
        g.drawLine(50, 50, 60, 30); // orelhas
        g.drawLine(60, 30, 70, 50);
        g.drawLine(110, 50, 100, 30);
        g.drawLine(100, 30, 90, 50);
        g.setColor(Color.red);
        g.drawArc(60, 80, 40, 20, 180, 180); // Boca
        g.setColor(Color.black);
        Font serif = new Font("Serif", Font.BOLD, 18);
        g.setFont(serif);
        g.drawString("Gato Java", 200, 50);
    }
}

class Gui extends JFrame {

    public Gui(String text) {
        super(text);
        setBackground(Color.yellow); // fundo amarelo
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Painel());
    }
}

class DesenhaGato {

    public static void main(String[] args) {
        Gui gui = new Gui("Gato");
        gui.setSize(300, 300);
        gui.setVisible(true);
    }
}
