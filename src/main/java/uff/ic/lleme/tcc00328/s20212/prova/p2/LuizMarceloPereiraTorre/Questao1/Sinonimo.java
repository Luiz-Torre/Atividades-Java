package uff.ic.lleme.tcc00328.s20212.prova.p2.LuizMarceloPereiraTorre.Questao1;
import java.util.ArrayList;
public class Sinonimo {
    public String significado;
    public ArrayList<Palavra> lista_sinonimos_palavras;
    
    public Sinonimo(String significado) {
        this.significado = significado;
        this.lista_sinonimos_palavras = new ArrayList<>();
    }
}
