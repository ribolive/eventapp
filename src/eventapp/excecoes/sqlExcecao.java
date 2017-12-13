package eventapp.excecoes;

public class sqlExcecao extends Exception {
    private String msg;
    
    public sqlExcecao() {
        super();
    }
    
    public sqlExcecao(String msg) { 
        this.msg = msg;
    }
    
    public String getMsg(){
        return this.msg;
    }
}