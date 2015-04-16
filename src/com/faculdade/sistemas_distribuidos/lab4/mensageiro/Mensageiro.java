package com.faculdade.sistemas_distribuidos.lab4.mensageiro;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mensageiro extends Remote {

  public void enviarMensagem( String msg ) throws RemoteException;
  public String lerMensagem() throws RemoteException;
}
