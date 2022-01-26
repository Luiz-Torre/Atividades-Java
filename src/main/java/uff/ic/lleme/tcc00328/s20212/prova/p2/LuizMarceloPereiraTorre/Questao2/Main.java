package uff.ic.lleme.tcc00328.s20212.prova.p2.LuizMarceloPereiraTorre.Questao2;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Double> lista_valores_1 = new ArrayList<>();
        ArrayList<Double> lista_valores_2 = new ArrayList<>();
        ArrayList<Double> lista_valores_3 = new ArrayList<>();

        
        for(double i =0;i<5;i++){
            lista_valores_1.add(i);
            lista_valores_2.add(i);
            lista_valores_3.add(i);
        }
        double tam = lista_valores_1.size() + lista_valores_2.size() + lista_valores_3.size();
        Tarefa tarefa1 = new Tarefa(lista_valores_1);
        Tarefa tarefa2 = new Tarefa(lista_valores_2);
        Tarefa tarefa3 = new Tarefa(lista_valores_3);
        
        Thread thread1 = new ThreadMedia(tarefa1,tam);
        Thread thread2 = new ThreadMedia(tarefa2,tam);
        Thread thread3 = new ThreadMedia(tarefa3,tam);
      
        
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        
        double resultado_final = tarefa1.resultado + tarefa2.resultado + tarefa3.resultado;
        System.out.println("A media dos valores no ArrayList é: " + resultado_final);               
    }
    
}
