package eventapp.models;

import eventapp.excecoes.UsuarioExcecao;
import eventapp.excecoes.ConfirmaSenhaExcecao;
        
public class Usuario {
    
    private long id;
    private String nome;
    private String usuario;
    private String email;
    private String senha;
    
    public Usuario(String nome, String usuario, String email, String senha, String confirmaSenha) throws Exception{ 
        if (senha.equals("")){
            throw new UsuarioExcecao("senha");
        }
        if (!senha.equals(confirmaSenha)){
            throw new ConfirmaSenhaExcecao();
        }
        if (nome.equals("")){
            throw new UsuarioExcecao("nome");
        }
        if (usuario.equals("")){
            throw new UsuarioExcecao("usuário");
        }
        if(email.equals("")){
            throw new UsuarioExcecao("email");
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
