
package eventapp.controllers;

import eventapp.models.Evento;


public class Controller_EdicaoEvento {
    private static Controller_EdicaoEvento instance = null;
    private Evento objEvento;

    public Controller_EdicaoEvento() {
        if (instance == null) {
            this.objEvento = null;
        }
    }
    
    public static Controller_EdicaoEvento getInstance() {
        if (instance == null) {
            instance = new Controller_EdicaoEvento();
        }
        return instance;
    }
    
    public Evento getObjEvento(){
        return this.objEvento;
    }
    
    public void setObjEvento(Evento objEvento) throws Exception {
        this.objEvento = objEvento;
    }
    
    
}
