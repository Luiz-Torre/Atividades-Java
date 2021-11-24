package uff.ic.lleme.tcc00328.s20212.prova.p1.LuizMarceloPereiraTorre;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;
public class Restaurante {
    static Prato[] todos_os_pratos = new Prato [5];

    public static void main(String[] args) {
        carregarPratos("src/main/java/uff/ic/lleme/tcc00328/s20212/prova/p1/LuizMarceloPereiraTorre/Pratos");
        carregarPedidos("src/main/java/uff/ic/lleme/tcc00328/s20212/prova/p1/LuizMarceloPereiraTorre/Pedidos");
    }
    
    public static void carregarPratos(String nomeArquivo){
        int quant = 0;
        Double preco = null;
        try {
            File file = new File(nomeArquivo);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] line_arq = line.split(" ",2);
                if (!line_arq[0].isEmpty()) {
                    preco = Double.parseDouble(line_arq[0]);
                }
                Prato prato_atual = new Prato(preco,line_arq[1]);
                Restaurante.todos_os_pratos[quant] = prato_atual;
                quant++;
            }
        }catch (FileNotFoundException ex) {
            System.out.println("Erro na leitura do arquivo " + nomeArquivo);
         }
        
    }
    
    public static void carregarPedidos(String nomeArquivo){
        int quant = 0;
        int num_pedido = 1;
        int quant_pratos = 0;
        Item item_atual = null;
        Double preco_total = 0.0;
        try {
            File file = new File(nomeArquivo);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                if(!"#".equals(line)){
                
                String[] line_arq = line.split(" ",2);
                if (!line_arq[0].isEmpty()) {
                    quant_pratos = Integer.parseInt(line_arq[0]);
                }
                for(int i =0;i<Restaurante.todos_os_pratos.length;i++){
                    if(Prato.getNomePrato(todos_os_pratos[i]).equals(line_arq[1])){
                       item_atual = new Item(quant_pratos,todos_os_pratos[i]);
                    }
                }
                Pedido item_do_pedido = new Pedido(quant,item_atual);
                quant++;
                }
                else{
                    Item[] pedidos = Pedido.getPedidos();
                    for(int i = 0;i<pedidos.length;i++){
                        if(pedidos[i] != null){
                            preco_total += Prato.getPrecoPrato(Item.getPratoItem(pedidos[i])) * Item.getQuantItem(pedidos[i]);
                        }
                    }
                    System.out.println("O preço do " + num_pedido+ "° pedido foi de R$"+preco_total);
                    calcPercentual(pedidos);

                    num_pedido++;
                    quant = 0;
                    quant_pratos = 0;
                    item_atual = null;
                    preco_total = 0.0;
                    Pedido.limparPedidos();
                    
                }
            }
        }catch (FileNotFoundException ex) {
            System.out.println("Erro na leitura do arquivo " + nomeArquivo);
         }
    }
    
    public static void calcPercentual(Item[] pedidos){
        Double quant_total = 0.0;
        Double porcent = 0.0;
        for(int i = 0;i<pedidos.length;i++){
            if(pedidos[i] != null){
                quant_total += Item.getQuantItem(pedidos[i]);
            }
        }
        for(int i = 0;i<pedidos.length;i++){
            if(pedidos[i] != null){
                porcent = (Item.getQuantItem(pedidos[i])/quant_total)*100;
                
                System.out.println("O prato " + Prato.getNomePrato(Item.getPratoItem(pedidos[i])) + " corresponde a " + new DecimalFormat("#,##0.00").format(porcent) + "% do total de pratos do pedido ");
            }
        }

    }
}