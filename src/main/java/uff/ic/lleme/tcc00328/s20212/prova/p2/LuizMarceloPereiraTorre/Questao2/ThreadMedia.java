package uff.ic.lleme.tcc00328.s20212.prova.p2.LuizMarceloPereiraTorre.Questao2;

public class ThreadMedia extends Thread {
    private Tarefa tarefa = null;
    private double tam = 0.0;
    public ThreadMedia(Tarefa tarefa, double tam){
        this.tarefa = tarefa;
        this.tam = tam;
    }
    
    @Override
    public void run(){
        tarefa.resultado = 0.0;
        for(Double numero : tarefa.lista_numeros){
            tarefa.resultado += numero;
        }
        tarefa.resultado /= tam;
    }
}
