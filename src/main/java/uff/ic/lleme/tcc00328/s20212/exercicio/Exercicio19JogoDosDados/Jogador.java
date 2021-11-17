
package uff.ic.lleme.tcc00328.s20212.exercicio.Exercicio19JogoDosDados;

public class Jogador {
    private String nome;
    private int pontuacao = 0;
    private boolean jogada = false;

    public Jogador(String nome, int pontuacao){
    this.nome = nome;
    this.pontuacao = pontuacao;
}
    public void setJogada(){
        this.jogada = true;
    }
    
    public boolean getJogada(){
        return this.jogada;
    }
    
    public int getPontuacao(){
        return this.pontuacao;
    }
    public String getNome(){
        return this.nome;
    }
    
}
