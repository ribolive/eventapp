package eventapp.excecoes;

public class ErroLoginException extends Exception{
    private String mensagem;
    public ErroLoginException(String msg) {
        this.mensagem = msg;
    }

    public ErroLoginException() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getMessage() {
        return mensagem;
    }
}
