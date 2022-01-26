package uff.ic.lleme.tcc00328.s20212.prova.p2.LuizMarceloPereiraTorre.Questao1;
import java.util.ArrayList;

public class Palavra {
    public String fonetica;
    public String grafia;
    public ArrayList<Sinonimo> lista_sinonimos;
    public Palavra(String fonetica, String grafia) {
        this.fonetica = fonetica;
        this.grafia = grafia;
        this.lista_sinonimos = new ArrayList<>();
    }
}
