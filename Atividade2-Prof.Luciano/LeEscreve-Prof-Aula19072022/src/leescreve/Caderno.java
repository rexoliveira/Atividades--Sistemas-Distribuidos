package leescreve;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Caderno {

    Object chaveEscrita = new Object();
    Object chaveLeitura = new Object();

    public void Atualiza() {
        synchronized (chaveLeitura) {
            synchronized (chaveEscrita) {
                try {
                    System.out.println(Thread.currentThread().getName() + " Comecou a atualizar");
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + " Terminou de atualizar");
                } catch (InterruptedException ex) {
                    Logger.getLogger(Caderno.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public void Ler() {

        synchronized (chaveLeitura) {
            try {
                System.out.println(Thread.currentThread().getName() + " Comecou a ler");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " Terminou de ler");
            } catch (InterruptedException ex) {
                Logger.getLogger(Caderno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Escrever() {

        synchronized (chaveEscrita) {
            try {
                System.out.println(Thread.currentThread().getName() + " Comecou a escrever");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " Terminou de escrever");
            } catch (InterruptedException ex) {
                Logger.getLogger(Caderno.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
