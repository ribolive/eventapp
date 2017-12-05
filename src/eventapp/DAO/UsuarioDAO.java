package eventapp.DAO;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import eventapp.models.Usuario;
import eventapp.util.Conn;


  
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
}  