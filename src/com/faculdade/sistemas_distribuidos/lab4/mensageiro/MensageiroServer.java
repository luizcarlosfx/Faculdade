package com.faculdade.sistemas_distribuidos.lab4.mensageiro;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MensageiroServer {

  public MensageiroServer() {
    try {
      Mensageiro m = new MensageiroImpl();
      Registry r = LocateRegistry.createRegistry(2555);
      
      r.rebind("MensageiroService", m);
    }
    catch( Exception e ) {
      System.out.println( "Trouble: " + e );
    }
  }

  public static void main(String[] args) {
    new MensageiroServer();
  }
}