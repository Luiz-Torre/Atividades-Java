package uff.ic.lleme.tcc00328.s20212.prova.p1.LuizMarceloPereiraTorre;
public class Pedido {
    private static Item[] itens_do_pedido = new Item [15];
    
    Pedido(int quant,Item item ){
        this.itens_do_pedido[quant] = item;
    }
    
    public static Item[] getPedidos(){
       return itens_do_pedido;
    }
    
    public static void limparPedidos(){
        Pedido.itens_do_pedido = new Item [15];
    }


}
