/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.topicos_especiais.prova;

/**
 *
 * @author Rubens
 */

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class questao1 {
    private BufferedImage img;
    private int W;
    private int H;
    private double larg;
    private double rend;
    private double precoLata;
    
    public questao1(String arquivo) {
        try {
            img = ImageIO.read(new File(arquivo));
            W = img.getWidth();
            H = img.getHeight();
            larg = 60.0;
            rend = 150.0;
            precoLata = 200.00;
            
	} catch (IOException e) {
            System.out.println(e);
            System.exit(0);
	}
    }
    
    public int[] Pixel(int x, int y) { 
        int pixel;
	int rgb[] = new int[3];
	pixel = img.getRGB(x, y);
	rgb[0] = (pixel >> 16) & 0xFF;
	rgb[1] = (pixel >> 8) & 0xFF;
	rgb[2] = pixel & 0xFF;
	return rgb;
    }
    
    public boolean preto(int[] p) {
        return (p[0] + p[1] + p[2])/3 < 50;
    }
    
    public  boolean isBlack(int [] colVal) {

        if (colVal[0] == 0 && colVal[1] == 0 && colVal[2] == 0) {

            return true;

        }

        return false;

    } 

    public void responde() {
        
        int x, y;
        int cont;
        int[] pix;
        int minX, maxX;
        
        minX = W;
        maxX = 0;
        cont = 0;
        for (y=0; y < H; y++) {
            for (x = 0; x < W; x++) {
                pix = Pixel(x,y);
                if (preto(pix)) {
                    cont++;
                    if (x > maxX) {
                        maxX = x;
                    }
                    if (x < minX) {
                        minX = x;
                    }
                }
            }
        }
        double tamPix  = larg/((maxX-minX+1));
        double areaPix = tamPix*tamPix;
        double areaTotal = cont*areaPix;
        int nLatas = (int)Math.ceil(areaTotal/rend);
        double custo = precoLata*nLatas;
        
        System.out.println("cont pretos = " + cont);
        System.out.println("tamPix = " + tamPix);
        System.out.println("Largura = " + (maxX-minX+1));
        System.out.println("Area total = " + areaTotal);
        System.out.println("Latas de tinta = " + nLatas);
        System.out.println("Custo total = " + custo);
        
    }
    
    public static void main(String[] args)
	{
		questao1 q1 = new questao1("tinta2.png");
		
		q1.responde();
	}
}
