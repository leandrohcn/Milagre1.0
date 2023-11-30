import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;


public class Menu {
    Scanner scan = new Scanner(System.in);
    ArrayList<String> musicas = new ArrayList<>();
    ArrayList<Album> albuns = new ArrayList<>();

    public void lerOpcoes() {
        int opcao;

        do {
            System.out.println("O que deseja fazer?");
            imprimirMenu();
            opcao = Integer.parseInt(scan.nextLine());
            switch (opcao){
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                case 1:
                    checarMusicaNoAlbum();
                    break;
                case 2:
                    verificarMusicaNaPosicaoN();
                    break;
                case 3:
                    imprimirDadosAlbum();
                    break;
                case 4:
                    trocarPosicao();
                    break;
                case 5:
                    criarAlbum();
                    break;
                default:
                    System.out.println("Opção Inválida.");
                    break;

            }
        } while (opcao != 0);


    }

    private void imprimirMenu(){
        System.out.println("(1) Checar se uma música está no álbum");
        System.out.println("(2) Verificar o nome da n-ésima música do álbum");
        System.out.println("(3) Imprimir os dados do álbum");
        System.out.println("(4) Alterar a posição da música na lista");
        System.out.println("(5) Adicionar álbum");
        System.out.println("(0) Sair do programa");
    }

    private void checarMusicaNoAlbum(){
        Album album = verificarAlbum();

        if (album != null){
            System.out.println("Digite o nome da musica que você quer");
            String nomeMusica = scan.nextLine();
            if(album.checarMusicaNoAlbum(nomeMusica)){
                System.out.println("Música está no Album");
            } else
                System.out.println("Música não está no Album");
        }
    }

    private void verificarMusicaNaPosicaoN(){
        Album album = verificarAlbum();

        if (album != null){
            System.out.println("Insira o numero n:");
            int n = Integer.parseInt(scan.nextLine());
            System.out.println("Música: " + album.verificarMusicaNaPosicaoN(n));
        }
    }


    private void criarAlbum(){
        System.out.println("insira o titulo:");
        String nomeAlbum = scan.nextLine();
        System.out.println("insira o artista");
        String artista = scan.nextLine();
        System.out.println("número de músicas:");
        int quantidadeMusicas = Integer.parseInt(scan.nextLine());
        Album album = new Album(nomeAlbum,artista,quantidadeMusicas);
        for(int i = 0; i< quantidadeMusicas;i++){
            System.out.println("nome:");
            album.adicionarMusica(scan.nextLine());
        }

        albuns.add(album);

    }

    private void imprimirDadosAlbum(){
        Album album = verificarAlbum();
            if(album != null){
                album.imprimirDados();
            }
    }
    private void trocarPosicao(){
        Album album = verificarAlbum();

            if (album != null) {
                System.out.println("Qual a posição da música que você deseja trocar?");
                int antigaPos = Integer.parseInt(scan.nextLine());
                System.out.println("Qual a nova posição?");
                int novaPos = Integer.parseInt(scan.nextLine());
                album.trocarPosicaoN(antigaPos, novaPos);
            }
    }

    private Album verificarAlbum() {
        System.out.println("Digite o álbum:");
        String albumDesejado = scan.nextLine();
        for (Album a : albuns) {
            if (a.getTitulo().equals((albumDesejado))) {
                return a;
            }
        }
        System.out.println("Album não encontrado");
        return null;
    }
}