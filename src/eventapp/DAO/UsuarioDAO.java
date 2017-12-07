package eventapp.DAO;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import eventapp.models.Usuario;
import eventapp.util.Conn;
import eventapp.util.Seguranca;


  
public class UsuarioDAO {  
   
    public void insere(Usuario usuario){
        String sql = "INSERT into usuario (nome, usuario, email, senha) VALUES(?,?,?,?)";
        PreparedStatement ps;
        try{
            ps = Conn.conectar().prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getUsuario());
            ps.setString(3,usuario.getEmail());
            String senhaCodificada = Seguranca.getInstance().hash("MD5", usuario.getSenha());
            ps.setString(4,senhaCodificada);
            ps.executeUpdate();
            Conn.fecharConexao();
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    public Usuario select(String login, String senha){
        try{
            String sql = "SELECT * from usuario where usuario = ? and senha = ?";
            PreparedStatement ps = Conn.conectar().prepareStatement(sql);
            ps.setString(1, login);
            senha = Seguranca.getInstance().hash("MD5", senha);
            System.out.println(senha);
            ps.setString(2,senha);
            ResultSet rs = ps.executeQuery();
            Conn.fecharConexao();
            Usuario usuario = null;
            while(rs.next()){
                usuario = new Usuario(rs.getString("nome"), rs.getString("usuario"), rs.getString("email"), rs.getString("senha"));
            }
            return usuario;
        } catch (SQLException e) {
            System.err.println();
            return null;
        }
    }
}