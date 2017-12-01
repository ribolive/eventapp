package br.ufla.dcc.ppoo.modelos;
import java.util.ArrayList;

public class Evento {
    
    private String nome;
    private String descricao;
    private String dataInicio; 
    private String hora;
    private Usuario idUsuario;
    private ArrayList<String> palavrasChave;
    private ArrayList<Avaliacao> avaliacoes;
    private String local; 

 
    public Evento(String nome, String descricao, String dataInicio, String hora, Usuario idUsuario, ArrayList<String> palavrasChave, String local) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.idUsuario = idUsuario;
        this.palavrasChave = palavrasChave;
        this.local = local;
    }
  
    
    
    
    
    
    
}