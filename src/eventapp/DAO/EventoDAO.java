package eventapp.DAO;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import eventapp.models.Evento;
import eventapp.util.Conn;
import java.util.ArrayList;



public class EventoDAO {
    
    public Evento insere(Evento evento){
        //String nome, String descricao, String dataInicio, String dataFim, int idUsuario, String local
        String sql = "INSERT into evento (nome,descricao,data_inicio,data_fim,id_criador,local_evento) VALUES(?,?,?,?,?,?)";
        PreparedStatement ps;
        try{
            ps = Conn.conectar().prepareStatement(sql);
            ps.setString(1,evento.getNome());
            ps.setString(2,evento.getDescricao());
            ps.setString(3,evento.getDataInicio());
            ps.setString(4,evento.getDataFim());
            ps.setInt(5,evento.getIdUsuario());
            ps.setString(6,evento.getLocal());
            ps.executeUpdate();
            Conn.fecharConexao();
            System.out.println("Cadastrado com sucesso!");
            return null;
        } catch (Exception ex) {
            System.err.println(ex);
            return null;
        }
    }
    
    public ArrayList<Evento> listar() {
        try {
            String sql = "SELECT nome,descricao,data_inicio,data_fim,id_criador,local_evento FROM evento order by nome desc";
            PreparedStatement ps = Conn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Conn.fecharConexao();
            ArrayList<Evento> eventos = new ArrayList();
            while (rs.next()) {
                Evento e = new Evento(rs.getString("nome"), rs.getString("descricao"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getInt("id_criador") ,rs.getString("local_evento"));
                eventos.add(e);
            }
            return eventos;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
    public boolean deletar(int id) {
        try {
            String sql = "DELETE FROM evento WHERE id = " + id;
            PreparedStatement stmt = Conn.conectar().prepareStatement(sql);
            if (stmt.executeUpdate() != 0) {
                Conn.fecharConexao();
                System.out.println("Evento excluído com sucesso");
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    public boolean atualizar(Evento evento) {
        try {
            String sql = "UPDATE evento SET nome = ?, descricao = ?, data_inicio = ?, data_fim = ?,id_criador = ?, local_evento = ? WHERE id = ?";

            PreparedStatement ps = Conn.conectar().prepareStatement(sql);
            ps.setString(1, evento.getNome());
            ps.setString(2, evento.getDescricao());
            ps.setString(3, evento.getDataInicio());
            ps.setString(4, evento.getDataFim());
            ps.setInt(5, evento.getIdUsuario());
            ps.setString(6, evento.getLocal());
            ps.setInt(7, evento.getId());

            ps.executeUpdate();
            Conn.fecharConexao();
            System.out.println("Atualização ocorrida com sucesso");
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
    
    public Evento procurarPorId(int id) {
        try {
            String sql = "SELECT nome,descricao,data_inicio,data_fim,id_criador,local_evento FROM evento where id = ? order by nome desc";
            PreparedStatement ps = Conn.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Conn.fecharConexao();
            rs.next();
            Evento e = new Evento(rs.getString("nome"), rs.getString("descricao"), rs.getString("data_inicio"), rs.getString("data_fim"), rs.getInt("id_criador") ,rs.getString("local_evento"));
            return e;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
    
}
