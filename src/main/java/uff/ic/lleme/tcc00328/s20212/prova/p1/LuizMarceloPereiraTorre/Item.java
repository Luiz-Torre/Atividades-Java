package uff.ic.lleme.tcc00328.s20212.prova.p1.LuizMarceloPereiraTorre;

public class Item {
    private Prato prato;
    private int quant;
    
    Item( int quant,Prato prato){
        this.prato = prato;
        this.quant = quant;
    }
    
    public static Prato getPratoItem(Item item){
        return item.prato;
    }
    public static int getQuantItem(Item item){
        return item.quant;
    }
}
