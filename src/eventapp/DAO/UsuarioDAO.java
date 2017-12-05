package eventapp.DAO;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import eventapp.models.Usuario;
import eventapp.util.Conn;
import eventapp.util.Seguranca;


  
public class UsuarioDAO {  
   
    public Usuario insere(Usuario usuario){
        String sql = "INSERT into usuario (nome, usuario, email, senha) VALUES(?,?,?,?)";
        PreparedStatement ps;
        try{
            ps = Conn.conectar().prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getUsuario());
            ps.setString(3,usuario.getEmail());
            ps.setString(4,usuario.getSenha());
            ps.executeUpdate();
            Conn.fecharConexao();
            System.out.println("Cadastrado com sucesso!");
            return null;
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public Usuario select(String login, String senha){
        try{
            String sql = "SELECT * from usuario where login = ? and senha = ?";
            PreparedStatement ps = Conn.conectar().prepareStatement(sql);
            ps.setString(1, login);
            senha = Seguranca.getInstance().hash("MD5", senha);
            ps.setString(2,senha);
            ResultSet rs = ps.executeQuery();
            Conn.fecharConexao();
            Usuario usuario;
            while(rs.next()){
                usuario = new Usuario(rs.getString("nome"), rs.getString("usuario"), rs.getString("email"), rs.getString("senha"));
                return usuario;
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}