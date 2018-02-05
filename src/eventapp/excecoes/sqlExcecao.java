package eventapp.excecoes;

public class sqlExcecao extends Exception {
    private String msg;
    
    public sqlExcecao() {
        super();
    }
    
    public sqlExcecao(String msg) { 
        this.msg = msg;
    }
    
    @Override
    public String getMessage(){
        return this.msg;
    }
}