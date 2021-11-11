package uff.ic.lleme.tcc00328.s20212.exercicio.Exercicio15;
import java.util.Scanner;

/**
 *
 * @author luizm
 */
public class HistogramaEx15 {
   Scanner input = new Scanner(System.in); //Declarei aqui para ser uma variavel de classe e poder utilizar em diversas funções se necessário.

   public static int categoria (float numero, float[] categs){
       int tam = categs.length;
       for(int count = 0; count<tam-1;count++){
       
        if (numero > categs[count] && numero<categs[count+1]){
            return count;
        }
        }
        return -1;

    }
   
   public static float[] histograma(float[] numeros, float[] categorias){
        int tam_num = numeros.length;
        int tam_catg = categorias.length;
        float[] histograma = new float[tam_catg];

        for(int contador = 0; contador < tam_catg;contador++) 
            histograma[contador] = 0;

        for(int contador = 0; contador < tam_num;contador++){
        for(int count = 0; count<tam_catg-1;count++){
       
            if (numeros[contador] > categorias[count] && numeros[contador]<categorias[count+1]){
                histograma[count]++;
                break;
            }
        }
        }
        return histograma;
   }
   
   
    public static void main(String[] args) {

        System.out.println("Digite o tamanho do vetor de categorias");

        Scanner input = new Scanner(System.in);
        int tam_vetor = input.nextInt();
        float[] num = new float [tam_vetor];
        
        for (int i = 0; i < tam_vetor; i++) {
            System.out.println("Informe o numero que fica na posição " + i + " da categoria");
            num[i] = input.nextFloat();
        }
        
        
        System.out.println("Digite o tamanho do vetor de numeros");
        tam_vetor = input.nextInt();

        float[] num_gerais = new float [tam_vetor];

        
        for (int i = 0; i < tam_vetor; i++) {
            System.out.println("Informe o numero que fica na posição " + i + " dos numeros");
            num_gerais[i] = input.nextFloat();
        }


        int tam_geral = num_gerais.length;
        for(int i=0;i<tam_geral;i++){
        int resp = categoria(num_gerais[i], num);
        if (resp != -1){
        System.out.println("O " + num_gerais[i] + " está entre" + num[resp] + " e " + num[resp+1]);
        }
        else{
            System.out.println("O " + num_gerais[i] + " não encontra-se em nenhuma categoria");
      
        }
        }

        float[] histograma = histograma(num_gerais,num);
        float porcent;
        int total_num_histo = 0;
        int tam_histo = histograma.length;
        
        
        for(int aux = 0; aux<tam_histo;aux++){
            porcent = (histograma[aux]/tam_geral)*100;
            System.out.println("Na " + (aux+1) + "° categoria, encontra-se " +porcent +"% dos numeros");
        }
    }
    
}
