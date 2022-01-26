package uff.ic.lleme.tcc00328.s20212.prova.p2.LuizMarceloPereiraTorre.Questao1;

public class Main {
    public static void main(String[] args) {
        Dicionario dicionario = new Dicionario();
        Sinonimo significado1 = new Substantivo("coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por meio de cola, costura etc., formando um volume que se recobre com capa resistente.");
        Sinonimo significado2 = new Substantivo("obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.].");
        Sinonimo significado3 = new Substantivo("aquilo que resulta de um trabalho, de uma ação.");
        
        Palavra palavra1 = new Palavra("livro", "livro");
        palavra1.lista_sinonimos.add(significado1);
        palavra1.lista_sinonimos.add(significado2);
        significado1.lista_sinonimos_palavras.add(palavra1);
        significado2.lista_sinonimos_palavras.add(palavra1);

        Palavra palavra2 = new Palavra("obra", "obra");
        palavra2.lista_sinonimos.add(significado2);
        palavra2.lista_sinonimos.add(significado3);
        significado1.lista_sinonimos_palavras.add(palavra2);
        significado2.lista_sinonimos_palavras.add(palavra2);
        
        dicionario.lista_palavras.add(palavra1);
        dicionario.lista_palavras.add(palavra2);
        
        for(Palavra palavra_atual: dicionario.lista_palavras){
            System.out.println("Grafia da palavra: "+palavra_atual.grafia);
            int i = 1;
            for (Sinonimo sinonimo_atual: palavra_atual.lista_sinonimos)
                System.out.println("Significado " + (i++)+": " + sinonimo_atual.significado);
            System.out.println("\n");
        }
        }
    }

