package models;

import java.util.ArrayList;

public class Usuario {
    
    private long id;
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    
    public Usuario(int id,String nome, String usuario, String email, String senha, String confirmaSenha){ 
        try {
            if (!senha.equals(confirmaSenha)){
                throw new Exception("A senha e a senha de confirmação devem ser iguais");
            }
            this.nome = nome;
            this.usuario = usuario;
            this.email = email;
            this.senha = senha;
            
        } catch (Exception e) {
            e.getMessage();
        }
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public long getId() {
        return id;
    }

    
    
    
    
    
}
