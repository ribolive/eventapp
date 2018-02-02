package eventapp.models;

public class Avaliacao {
    private int idUsuario;
    private String nome;
    private int nota;
    private String comentario;
    
    public Avaliacao(int idUsuario, int nota) {
        this.idUsuario = idUsuario;
        this.nota = nota;
    }

    public Avaliacao(int idUsuario, String nome, int nota, String comentario) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.nota = nota;
        this.comentario = comentario;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
    
}
