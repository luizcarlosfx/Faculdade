package com.faculdade.computacaografica.lab1;

import java.awt.*;
import javax.swing.*;

public class Painel extends JPanel {

    
    public Painel() {
        initComponents();
    }
    
    @Override
    public void paint(Graphics g) {
        int compr; // comprimento da linha
        int alt = 0; // altura da linha
        for (compr = 100; compr <= 300; compr += 100) {
            alt += 20;
            g.drawLine(0, alt, compr, alt);
        }
        Font font = new Font("Serif", Font.BOLD, 14); // cria a fonte para escrever a frase
        g.setFont(font); // estabelece a fonte que será usada a partir daqui.
        alt += 200; // define a altura 200 pixels abaixo da ultima linha desenhada.
        g.drawString("Foram impressas 3 linhas de comprimentos 100, 200 e 300 pixels", 50, alt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
