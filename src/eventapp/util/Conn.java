package eventapp.util;

import eventapp.excecoes.sqlExcecao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    
    private static String status = "Desconectado";
    private String nome;
    
    public Conn() {

    }
    
    //Método de Conexão//
    public static java.sql.Connection conectar() throws SQLException, ClassNotFoundException, sqlExcecao {
        Connection connection = null;          //atributo do tipo Connection
        // Carregando o JDBC Driver padrão
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);

        //Parametros de configuralão da conexão
        String serverName = "";
        String mydatabase = "eventapp";
        String url = "jdbc:mysql://localhost/"+mydatabase+"?autoReconnect=true&useSSL=true";
        String username = "root";
        String password = "admin";
        connection = DriverManager.getConnection(url, username, password);

        //Testa sua conexão// 
        if (connection != null) {
            status = ("Conectado");
        } else {
            throw new sqlExcecao("Não foi possível conectar com o banco de dados");
        }
        return connection;
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

    //Método que fecha conexão//
    public static boolean fecharConexao() throws ClassNotFoundException, sqlExcecao {
        try {
            Conn.conectar().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia conexão
    public static java.sql.Connection reiniciarConexao() throws SQLException, ClassNotFoundException, sqlExcecao {
        fecharConexao();
        return Conn.conectar();
    }    
}
