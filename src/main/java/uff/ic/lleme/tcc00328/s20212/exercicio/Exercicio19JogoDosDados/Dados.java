package uff.ic.lleme.tcc00328.s20212.exercicio.Exercicio19JogoDosDados;
import java.util.Random;

public class Dados {
    private int soma_dados;
    
    public int setDados(int numero_de_dados){
        Random random = new Random();
        for(int a = 0;a<numero_de_dados;a++ ){
            this.soma_dados += (random.nextInt(5)+1);
    }

        
        
        return this.soma_dados;
    }
    
}
