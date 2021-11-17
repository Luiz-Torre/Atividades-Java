
package uff.ic.lleme.tcc00328.s20212.exercicio.tutorialOO.LuizMarceloPereiraTorre;

import java.util.Scanner;
import java.io.File;  
import java.io.FileNotFoundException;

public class SistemaAcademico {
    static Aluno[] vetor_alunos = new Aluno [1];
    static Disciplina[] vetor_disciplina = new Disciplina [1];
    static Inscricao[] vetor_inscricao = new Inscricao [1];

    public static void main(String[] args) {
        System.out.println("Digite o nome do arquivo de alunos");
        Scanner input = new Scanner(System.in);
        String nome_arquivo = input.nextLine();
        carregarAlunos(nome_arquivo);
        System.out.println("Digite o nome do arquivo de Disciplinas");
        nome_arquivo = input.nextLine();
        carregarDisciplinas(nome_arquivo);
        System.out.println("Digite o nome do arquivo de Inscricao");
        nome_arquivo = input.nextLine();
        carregarInscricoes(nome_arquivo);
        informarNotasDeAlunos();
        calcularMedias();
    }
    
    
    public static void carregarAlunos(String nomeArquivo){
        int quant_alunos = 0;
          try {
            File file = new File(nomeArquivo);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] line_arq = line.split(" ",4);
                
                Aluno aluno_atual = new Aluno();
                aluno_atual.cpf = line_arq[0]; 
                aluno_atual.matricula = Integer.parseInt(line_arq[1]);
                aluno_atual.unidade = line_arq[2];
                aluno_atual.nome = line_arq[3];


                
                if(quant_alunos> 0){
                     Aluno [] aux_vetor_alunos = SistemaAcademico.vetor_alunos.clone();
                    SistemaAcademico.vetor_alunos = new Aluno[quant_alunos+1];
                    System.arraycopy(aux_vetor_alunos, 0, SistemaAcademico.vetor_alunos, 0, aux_vetor_alunos.length); 
                    SistemaAcademico.vetor_alunos[quant_alunos] = aluno_atual;
                }
                else{
                    SistemaAcademico.vetor_alunos[quant_alunos] = aluno_atual ;
                }
                
                quant_alunos++;
            }

            input.close();

        } catch (FileNotFoundException ex) {
        System.out.println("Deu erro");
        }
      
    }

    public static void carregarDisciplinas(String nomeArquivo){
        int quant_disciplina = 0;
          try {
            File file = new File(nomeArquivo);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] line_arq = line.split(" ",3);
                
                Disciplina disciplina_atual = new Disciplina();
                disciplina_atual.codigo = line_arq[0]; 
                disciplina_atual.sigla = line_arq[1];
                disciplina_atual.nome = line_arq[2];


                
                if(quant_disciplina> 0){
                     Disciplina [] aux_vetor_disciplina = SistemaAcademico.vetor_disciplina.clone();
                    SistemaAcademico.vetor_disciplina = new Disciplina[quant_disciplina+1];
                    System.arraycopy(aux_vetor_disciplina, 0, SistemaAcademico.vetor_disciplina, 0, aux_vetor_disciplina.length); 
                    SistemaAcademico.vetor_disciplina[quant_disciplina] = disciplina_atual;
                }
                else{
                    SistemaAcademico.vetor_disciplina[quant_disciplina] = disciplina_atual ;
                }
                
                quant_disciplina++;
            }

            input.close();

        } catch (FileNotFoundException ex) {
        System.out.println("Deu erro");
        }
  
    }

    public static void carregarInscricoes(String nomeArquivo){
        int quant_inscricao = 0;
          try {
            File file = new File(nomeArquivo);
            Scanner input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
                String[] line_arq = line.split(" ",3);
                
                Inscricao inscricao_atual = new Inscricao();
                inscricao_atual.data_matricula = line_arq[2]; 
                
                for(int i = 0; i< SistemaAcademico.vetor_alunos.length; i++){
                    if(SistemaAcademico.vetor_alunos[i].matricula == Integer.parseInt(line_arq[1])){
                        inscricao_atual.aluno = SistemaAcademico.vetor_alunos[i]; 
                    }
                }
                for(int i = 0; i< SistemaAcademico.vetor_disciplina.length; i++){
                    if(SistemaAcademico.vetor_disciplina[i].codigo.equals(line_arq[0])){
                        inscricao_atual.disciplina = SistemaAcademico.vetor_disciplina[i];
                    }
                }


                
                if(quant_inscricao> 0){
                    Inscricao [] aux_vetor_inscricao = SistemaAcademico.vetor_inscricao.clone();
                    SistemaAcademico.vetor_inscricao = new Inscricao[quant_inscricao+1];
                    System.arraycopy(aux_vetor_inscricao, 0, SistemaAcademico.vetor_inscricao, 0, aux_vetor_inscricao.length); 
                    SistemaAcademico.vetor_inscricao[quant_inscricao] = inscricao_atual;
                }
                else{
                    SistemaAcademico.vetor_inscricao[quant_inscricao] = inscricao_atual;
                }
                
                quant_inscricao++;
            }

            input.close();

        } catch (FileNotFoundException ex) {
        System.out.println("Deu erro");
        }
    
    }
    
    public static void informarNotasDeAlunos(){
        int[] vetor_matriculas = new int[SistemaAcademico.vetor_alunos.length];
        String[] vetor_codigos = new String[1];

        int cont = 0;
        int i = 0;
        for (Aluno single_aluno : SistemaAcademico.vetor_alunos) { 
            vetor_matriculas[i] = single_aluno.matricula; 
            i++;      
        }

        for(int j = 0; j<SistemaAcademico.vetor_disciplina.length;j++){
            for(i = 0; i<SistemaAcademico.vetor_inscricao.length;i++){
                if(SistemaAcademico.vetor_disciplina[j].codigo.equals(SistemaAcademico.vetor_inscricao[i].disciplina.codigo )){
                    if(cont > 0){
                        String [] aux_vetor_codigos= vetor_codigos.clone();
                        vetor_codigos = new String[cont+1];
                        System.arraycopy(aux_vetor_codigos, 0, vetor_codigos, 0, aux_vetor_codigos.length); 
                        vetor_codigos[cont] = SistemaAcademico.vetor_disciplina[j].codigo;
                    }

                    else{
                        vetor_codigos[cont] = SistemaAcademico.vetor_disciplina[j].codigo;
                    }
                    break;
                }
            }
            cont++;
        }
        Scanner input = new Scanner(System.in);
        for(int matricula : vetor_matriculas){
            for(Aluno single_aluno : SistemaAcademico.vetor_alunos)
                if (matricula == single_aluno.matricula){
                    for(Inscricao disciplinas : SistemaAcademico.vetor_inscricao){
                        if(disciplinas.aluno.matricula == matricula){
                            System.out.println("Aluno: " + single_aluno.nome + "\n" +"Informe a nota da P1 " + "da disciplina: " + disciplinas.disciplina.nome);
                            disciplinas.notas[0] = input.nextFloat();
                            System.out.println("Informa a nota da P2");
                            disciplinas.notas[1] = input.nextFloat();
                        }
                    }
                }
        }
        }
    
    public static void calcularMedias(){
        for(Inscricao aux_media : SistemaAcademico.vetor_inscricao){
            float media = (aux_media.notas[0] + aux_media.notas[1])/2;
            System.out.println("A media do aluno " + aux_media.aluno.nome + " que frequenta a disciplina "+ aux_media.disciplina.nome + " é " + media);            
        }

    }
    
}
    
