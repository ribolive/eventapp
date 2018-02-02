package eventapp.DAO;

import eventapp.excecoes.ErroLoginException;
import eventapp.excecoes.sqlExcecao;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import eventapp.models.Usuario;
import eventapp.util.Conn;
import eventapp.util.Seguranca;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;


  
public class UsuarioDAO {  
   
    public void insere(Usuario usuario)throws Exception{
        String sql = "INSERT into usuario (nome, usuario, email, senha) VALUES(?,?,?,?)";
        PreparedStatement ps;
        ps = Conn.conectar().prepareStatement(sql);
        ps.setString(1,usuario.getNome());
        ps.setString(2,usuario.getUsuario());
        ps.setString(3,usuario.getEmail());
        String senhaCodificada = Seguranca.getInstance().hash("MD5", usuario.getSenha());
        ps.setString(4,senhaCodificada);
        ps.executeUpdate();
        Conn.fecharConexao();
    }
    
    public Usuario select(String login, String senha)throws ErroLoginException, SQLException, ClassNotFoundException, NoSuchAlgorithmException, sqlExcecao, IOException{
        String sql = "SELECT * from usuario where usuario = ? and senha = ?";
        PreparedStatement ps = Conn.conectar().prepareStatement(sql);
        ps.setString(1, login);
        senha = Seguranca.getInstance().hash("MD5", senha);
        ps.setString(2, senha);
        ResultSet rs = ps.executeQuery();
        Conn.fecharConexao();
        Usuario usuario = null;
        while(rs.next()){
            usuario = new Usuario(  rs.getInt("id"),
                                    rs.getString("nome"),
                                    rs.getString("usuario"),
                                    rs.getString("email"),
                                    rs.getString("senha"));
        }
        if (usuario == null) {
            throw new ErroLoginException("Usuario ou senha incorretos");
        }
        return usuario;
    }
}