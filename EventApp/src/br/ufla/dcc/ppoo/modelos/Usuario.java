package br.ufla.dcc.ppoo.modelos;

import java.util.ArrayList;

public class Usuario {
    
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Evento> eventos;
    
    public Usuario(String nome, String email, String senha, String confirmaSenha){ 
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }
    
    
    
    
}
