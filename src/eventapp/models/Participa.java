package eventapp.models;

public class Participa {
    
    private int idUsuario;
    private int idEvento;
    private int avaliacao;
    private String comentario;

    public Participa(int idUsuario, int idEvento) {
        this.idUsuario = idUsuario;
        this.idEvento = idEvento;
        this.avaliacao = -1;
        this.comentario = null;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
        
}
