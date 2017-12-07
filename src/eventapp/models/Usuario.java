package eventapp.models;

import java.util.ArrayList;
import eventapp.excecoes.UsuarioExcecao;
    
public class Usuario {
    
    private long id;
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    
    public Usuario(String nome, String usuario, String email, String senha, String confirmaSenha) throws Exception{ 
        if (senha.equals("")){
            throw new UsuarioExcecao("A senha não pode ser vazia");
        }
        if (!senha.equals(confirmaSenha)){
            throw new UsuarioExcecao("A senha e a senha de confirmação devem ser iguais");
        }
        if (nome.equals("")){
            throw new UsuarioExcecao("O nome não pode ser vazio");
        }
        if (usuario.equals("")){
            throw new UsuarioExcecao("O usuário não pode ser vazio");
        }
        if(email.equals("")){
            throw new UsuarioExcecao("O email não deve ser vazio");
        }
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;    
    }
    
    public Usuario(String nome, String usuario, String email, String senha){ 
        this.nome = nome;
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;    
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
    
    /* Método de teste */
    public void imprimeUsuario(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Usuario: "+this.usuario);
        System.out.println("Email: "+this.email);
    }

    
    
    
    
    
}
