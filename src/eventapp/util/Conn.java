package eventapp.util;

import eventapp.excecoes.sqlExcecao;
import eventapp.org.json.JSONObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.commons.io.IOUtils;




public class Conn {
    
    private static String status = "Desconectado";
    private static String nome;
    private static String serverName;
    private static String myDataBase;
    private static String url;
    private static String username;
    private static String password;
    
    public Conn() {
        
    }
    
    //Método de Conexão//
    public static java.sql.Connection conectar() throws SQLException, ClassNotFoundException, sqlExcecao, FileNotFoundException, IOException {
        
        File f = new File("./dist/config_db.json");
        if (f.exists()){
            InputStream is = new FileInputStream("./dist/config_db.json");
            String jsonTxt = IOUtils.toString(is, "UTF-8");
            JSONObject json = new JSONObject(jsonTxt);       
            Conn.url = json.getString("url");
            Conn.username = json.getString("username");
            Conn.password = json.getString("password");
        }
        
        
        
        Connection connection = null;          //atributo do tipo Connection
        // Carregando o JDBC Driver padrão
        String driverName = "com.mysql.jdbc.Driver";
        Class.forName(driverName);

        //Parametros de configuralão da conexão
        connection = DriverManager.getConnection(Conn.url, Conn.username, Conn.password);

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
    public static boolean fecharConexao() throws ClassNotFoundException, sqlExcecao, IOException {
        try {
            Conn.conectar().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    //Método que reinicia conexão
    public static java.sql.Connection reiniciarConexao() throws SQLException, ClassNotFoundException, sqlExcecao, IOException {
        fecharConexao();
        return Conn.conectar();
    }    
}
