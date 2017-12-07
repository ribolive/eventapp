package eventapp.excecoes;

public class ConfirmaSenhaExcecao extends Exception {
      
    public ConfirmaSenhaExcecao() { 
        super ("A senha e a confirmação de senha devem ser iguais!");
    }
}
