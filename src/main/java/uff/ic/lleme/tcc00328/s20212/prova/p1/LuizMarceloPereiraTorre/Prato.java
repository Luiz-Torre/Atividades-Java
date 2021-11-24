package uff.ic.lleme.tcc00328.s20212.prova.p1.LuizMarceloPereiraTorre;

public class Prato {
   private String nome;
   private Double preco;

    Prato(Double preco, String nome) {
        this.nome = nome;
        this.preco = preco;    }
    
    public static String getNomePrato(Prato prato){
        return prato.nome;
    }
    
    public static Double getPrecoPrato(Prato prato){
        return prato.preco;
    }
    
}
