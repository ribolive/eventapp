package eventapp.util;

import java.math.BigInteger;
import java.security.*;
import eventapp.DAO.UsuarioDAO;
import eventapp.models.Usuario;


public class Seguranca {

    private static Seguranca instance = null;

    private Usuario usuario;

    public Seguranca() {
        if (instance == null) {
            this.usuario = null;
        }
    }

    public static Seguranca getInstance() {
        if (instance == null) {
            instance = new Seguranca();
        }
        return instance;
    }

    public String hash(String tipo, String texto) {
        try {
            MessageDigest senhaCodificada = MessageDigest.getInstance(tipo);
            senhaCodificada.update(texto.getBytes(), 0, texto.length());
            BigInteger i = new BigInteger(1, senhaCodificada.digest());
            texto = String.format("%1$032X", i);
            return texto;
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    public boolean logar(String login, String senha) {
        UsuarioDAO dao = new UsuarioDAO();
        this.usuario = dao.select(login, senha);
        return usuario != null;
    }

    public Usuario getUsuarioLogado() {
        return this.usuario;
    }

}
