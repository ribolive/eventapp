/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventapp.controllers;

import eventapp.models.Evento;

/**
 *
 * @author Gabriel_Note
 */
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
    
    public void setObjEvento(Evento objEvento) {
        this.objEvento = objEvento;
    }
    
    
}
