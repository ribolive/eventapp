package eventapp.DAO;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import eventapp.models.Evento;
import eventapp.util.Conn;



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
    
}
