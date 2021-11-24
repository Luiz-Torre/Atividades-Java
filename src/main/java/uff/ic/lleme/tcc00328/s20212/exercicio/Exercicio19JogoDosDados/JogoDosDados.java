package uff.ic.lleme.tcc00328.s20212.exercicio.Exercicio19JogoDosDados;

import java.util.Scanner;

/**
 *
 * @author luizm
 */
public class JogoDosDados {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite a quantidade de jogadores que irão participar");
        int num_players = input.nextInt();
        for (int a = 0; a < num_players; a++) {

            Dados dados = new Dados();
            System.out.println("Informe o numero de dados que serão lançados");
            int num_dados = input.nextInt();
            int pontuacao = dados.setDados(num_dados);

            System.out.println("Informe o nome do jogador" + (a + 1));
            String name_player = input.next();
            Jogador jogador = new Jogador(name_player, pontuacao);

            int player_pontuacao = jogador.getPontuacao();
            boolean aux = jogador.getJogada();
            System.out.println(player_pontuacao + "e " + aux);
            if ((player_pontuacao == 7 || player_pontuacao == 11) && aux == false)
                System.out.println("O jogador " + jogador);

        }
        System.out.println("Digite o nome");
    }

}
