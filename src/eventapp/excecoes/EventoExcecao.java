
package eventapp.excecoes;

public class EventoExcecao extends Exception {
    
    public EventoExcecao() {
        super();
    }
    
    public EventoExcecao(String campo) { 
        super ("O campo " + campo + " não pode estar vazio!");
    }
}