package br.ufla.dcc.ppoo.modelos;

public class Teste {
    
    public static void main(String[] args) {
        Controle controle = new Controle();
        if (controle.cadastar("João", "jjasidjjdosaij", "1234", "1234")){
            System.out.println("Cadastrado");
        } else {
            System.out.println("Não cadastrado");
        }
        
        if (controle.autenticar("jjasidjjdosaij", "3333" )){
            System.out.println("Autenticado com sucesso!");
        } else {
            System.out.println("Não autenticado");
        }
    }
}
