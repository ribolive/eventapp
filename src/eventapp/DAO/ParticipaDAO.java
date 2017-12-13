package eventapp.DAO;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import eventapp.models.Participa;
import eventapp.models.Usuario;
import eventapp.models.Evento;
import eventapp.util.Conn;
import java.util.ArrayList;



public class ParticipaDAO {
    
//    Insere uma nova participação no banco de dados
    public boolean insere(Participa participa){
        String sql = "INSERT into participa VALUES(?,?,?,?)";
        PreparedStatement ps;
        try{
            ps = Conn.conectar().prepareStatement(sql);
            ps.setInt(1,participa.getIdUsuario());
            ps.setInt(2,participa.getIdEvento());
            ps.setInt(3,participa.getAvaliacao());
            ps.setString(4,participa.getComentario());
            ps.executeUpdate();
            Conn.fecharConexao();
            return true;
        } catch (Exception ex) {
            System.err.println(ex);
            return false;
        }
    }
    
    // Insere uma nova nota no banco de dados
    public void insereAvaliacao(int idUsuario, int idEvento, int avaliacao){
        String sql = "UPDATE participa SET avaliacao = ? WHERE id_usuario = ? and id_evento = ?";
        PreparedStatement ps;
        try{
            ps = Conn.conectar().prepareStatement(sql);
            ps.setInt(1,avaliacao);
            ps.setInt(2,idUsuario);
            ps.setInt(3,idEvento);
            ps.executeUpdate();
            Conn.fecharConexao();
            System.out.println("Avaliacao guardada!");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    // Insere um novo comentário no banco de dados
    public void insereComentario(int idUsuario, int idEvento, String comentario){
        String sql = "UPDATE participa SET comentario = ? WHERE id_usuario = ? and id_evento = ?";
        PreparedStatement ps;
        try{
            ps = Conn.conectar().prepareStatement(sql);
            ps.setString(1,comentario);
            ps.setInt(2,idUsuario);
            ps.setInt(3,idEvento);
            ps.executeUpdate();
            Conn.fecharConexao();
            System.out.println("comentario guardado!");
        } catch (SQLException ex) {
            System.err.println(ex);
        }
    }
    
    // Retorna a avaliação média do evento
    public double notaMedia(int idEvento){
        String sql = "SELECT AVG(avaliacao)from participa where id_evento = ?";
        PreparedStatement ps;
        try{
            ps = Conn.conectar().prepareStatement(sql);
            ps.setInt(1,idEvento);
            ResultSet rs = ps.executeQuery();
            Conn.fecharConexao();
            rs.next();
            return (rs.getDouble("AVG(avaliacao)"));
        } catch (SQLException ex) {
            System.err.println(ex);
        }
        return 0.0;
    }
    
    // Retorna uma lista de usuários que está cadastrado no evento
    public ArrayList<Usuario> listaCadastrados(int idEvento){
        try {
            String sql = "SELECT usuario.nome, usuario.usuario, usuario.email FROM usuario INNER JOIN participa ON usuario.id = participa.id_usuario where participa.id_evento = ?";
            PreparedStatement ps = Conn.conectar().prepareStatement(sql);
            ps.setInt(1, idEvento);
            ResultSet rs = ps.executeQuery();
            Conn.fecharConexao();
            ArrayList<Usuario> usuarios = new ArrayList();
            while (rs.next()) {
                Usuario u = new Usuario(rs.getString("nome"), rs.getString("usuario"), rs.getString("email"), "---");
                usuarios.add(u);
            }
            return usuarios;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
    // Retorna a lista de eventos que o usuário está participando
    public ArrayList<Evento> listaEventosParticipante(int idUsuario) throws Exception{
        try {
            String sql = "SELECT evento.nome, evento.descricao, evento.data_inicio, evento.data_fim, evento.id_criador, evento.local_evento FROM evento INNER JOIN participa ON evento.id = participa.id_evento where participa.id_usuario = ?";
            PreparedStatement ps = Conn.conectar().prepareStatement(sql);
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();
            Conn.fecharConexao();
            ArrayList<Evento> eventos = new ArrayList();
            while (rs.next()) {
                Evento e = new Evento(rs.getString("nome"), rs.getString("descricao"), rs.getDate("data_inicio"), rs.getDate("data_fim"), rs.getInt("id_criador") ,rs.getString("local_evento"));
                eventos.add(e);
            }
            return eventos;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }   
    }    
}
