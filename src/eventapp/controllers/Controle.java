package eventapp.controllers;

import java.util.ArrayList;
import eventapp.models.Usuario;

public class Controle {
    
    private ArrayList<Usuario> usuarios;
    private Usuario usuarioLogado;

    public Controle() {
        usuarios = new ArrayList<Usuario>();
        usuarioLogado = null;
    }
       
    //Tratar exceções
    public boolean cadastar(String nome, String email, String senha, String confirmaSenha){
//        if (this.usuarios != null){
//            for (Usuario usuario : this.usuarios) {
//                if (usuario.getEmail().equals(email)){
//                    return false;
//                }
//            }
//        }
//        if (senha.length() >= 4 && senha.equals(confirmaSenha)){
//            Usuario novo = new Usuario(nome,email,senha,confirmaSenha);
//            this.usuarios.add(novo);
//            return true;
//        }
        return false;      
    }
    
    
    public boolean autenticar(String email, String senha){
        for(Usuario usuario : this.usuarios){
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha) ){
                this.usuarioLogado = usuario;
                return true;  
            } else {
                return false;
                //Tratar exceção
            }
        }
        //tratar exceção
        return false;
    }
    
    public boolean cadastraEvento(String nome, String descricao, String dataInicio, String hora, ArrayList<String> palavrasChave, String local){
        
        
        return true;
    }
    
    
}
