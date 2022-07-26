package leescreve;

public class LeEscreve {

    public static void main(String[] args) {

        Caderno caderno = new Caderno();

        EstudanteEscreve e1 = new EstudanteEscreve(caderno);
        EstudanteLe e2 = new EstudanteLe(caderno);
        EstudanteEscreve e3 = new EstudanteEscreve(caderno);
        EstudanteEscreve e4 = new EstudanteEscreve(caderno);
        EstudanteLe e5 = new EstudanteLe(caderno);
        EstudanteLe e6 = new EstudanteLe(caderno);
        Professor p1= new Professor(caderno);
        
        
        Thread t1 = new Thread(e1, "ESTUDANTE#1");
        Thread t2 = new Thread(e2, "ESTUDANTE#2");
        Thread t3 = new Thread(e3, "ESTUDANTE#3");
        Thread t4 = new Thread(e4, "ESTUDANTE#4");
        Thread t5 = new Thread(e5, "ESTUDANTE#5");
        Thread t6 = new Thread(e6, "ESTUDANTE#6");
         Thread t7 = new Thread(p1, "PROFESSOR");

        t1.start();
        t2.start();
        t7.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();

    }

}
