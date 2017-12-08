
package eventapp.excecoes;

public class UsuarioExcecao extends Exception {
    public UsuarioExcecao() {
        super();
    }
    public UsuarioExcecao(String campo) { 
        super ("O campo " + campo + " não pode estar vazio!");
    }
}
