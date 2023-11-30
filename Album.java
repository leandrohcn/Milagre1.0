import java.util.ArrayList;
import java.util.Scanner;
public class Album {
    private String titulo;
    private String artista;
    private int quantidadeMusicas;
    private ArrayList<String> musicas;
    private Scanner scan = new Scanner(System.in);

    public Album(String titulo, String artista, int quantidadeMusicas) {
        this.titulo = titulo;
        this.artista = artista;
        this.quantidadeMusicas = quantidadeMusicas;
        musicas = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getQuantidadeMusicas() {
        return quantidadeMusicas;
    }

    public void setQuantidadeMusicas(int quantidadeMusicas) {
        this.quantidadeMusicas = quantidadeMusicas;
    }

    public void adicionarMusica(String m) {
        musicas.add(m);
    }

    public ArrayList<String> getMusicas() {
        return musicas;
    }

    public boolean checarMusicaNoAlbum(String musica){
        return musicas.contains(musica);
    }

    public String verificarMusicaNaPosicaoN(int n){

        if(n >= 1 && n <= musicas.size()){
            return musicas.get(n - 1);
        }

        return "Musica não encontrada.";
    }

    public void imprimirDados(){
        System.out.println("Titulo: " + this.titulo);
        System.out.println("Artista: " + this.artista);
        System.out.println("Lista de músicas: ");
        for (int i = 0; i < getQuantidadeMusicas() ; i++) {
            System.out.println("Musica: " + (i+1) + getMusicas().get(i));
        }
    }
    public void trocarPosicaoN(int antigaPos, int novaPos){
        String aux;
        aux = musicas.get(antigaPos - 1);
        musicas.set(antigaPos - 1, musicas.get(novaPos - 1));
        musicas.set(novaPos - 1, aux);
    }
}