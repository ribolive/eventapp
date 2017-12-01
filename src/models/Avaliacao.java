package models;

public class Avaliacao {
    private int idUsuario;
    private int nota;

    public Avaliacao(int idUsuario, int nota) {
        this.idUsuario = idUsuario;
        this.nota = nota;
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
