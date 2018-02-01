
package eventapp.controllers;

import eventapp.models.Evento;


public class Controle_singletonEdicaoEvento {
    private static Controle_singletonEdicaoEvento instance = null;
    private Evento objEvento;

    public Controle_singletonEdicaoEvento() {
        if (instance == null) {
            this.objEvento = null;
        }
    }
    
    public static Controle_singletonEdicaoEvento getInstance() {
        if (instance == null) {
            instance = new Controle_singletonEdicaoEvento();
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
