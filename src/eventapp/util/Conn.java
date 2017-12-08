package eventapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
    
    private static String status = "Desconectado";
    private String nome;
    
    public Conn() {

    }
    
    //Método de Conexão//
    public static java.sql.Connection conectar() {
        Connection connection = null;          //atributo do tipo Connection

        try {
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
            if (connection != null)
                status = ("Conectado");

            return connection;

        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado." + e);
            return null;
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("\nNao foi possivel conectar ao Banco de Dados." + e);
            return null;
        }
    }

    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }

    //Método que fecha conexão//
    public static boolean fecharConexao() {
        try {
            Conn.conectar().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia conexão
    public static java.sql.Connection reiniciarConexao() {
        fecharConexao();
        return Conn.conectar();
    }    
}
