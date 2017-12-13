package eventapp.models;
import eventapp.excecoes.EventoExcecao;

import java.sql.Date;

public class Evento {

    
    private int id;
    private String nome;
    private String descricao;
    private Date dataInicio; 
    private Date dataFim;
    private int idUsuario;
    private String local; 


    public Evento(int id, String nome, String descricao, Date dataInicio, Date dataFim, int idUsuario, String local) throws Exception{
         if (id < 0){
            throw new EventoExcecao("id");
        }
        if (nome.isEmpty()){
            throw new EventoExcecao("nome");
        }
        
        if (descricao.isEmpty()){
            throw new EventoExcecao("descrição");
        }
        
        if (dataInicio == null){
            throw new EventoExcecao("data de início");
        }
        
        if (dataFim == null){
            throw new EventoExcecao("data de término");
        }
        
        if (local.isEmpty()){
            throw new EventoExcecao("local");
        }
        
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idUsuario = idUsuario;
        this.local = local;
    }
    
    public Evento(String nome, String descricao, Date dataInicio, Date dataFim, int idUsuario, String local) throws Exception{
        if (nome.isEmpty()){
            throw new EventoExcecao("nome");
        }
        
        if (descricao.isEmpty()){
            throw new EventoExcecao("descrição");
        }
        
        if (dataInicio == null){
            throw new EventoExcecao("data de início");
        }
        
        if (dataFim == null){
            throw new EventoExcecao("data de término");
        }
        
        if (local.isEmpty()){
            throw new EventoExcecao("local");
        }
        
        this.nome = nome;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.idUsuario = idUsuario;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getId() throws EventoExcecao {
        if(this.id < 1){
            throw new EventoExcecao("Id não valido");
        }
        return id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    
    
    /* Método de teste. Não recomendável na versão final do programa */
    public void setId(int id) {
        this.id = id;
    }
    
    /* Método de teste */
    public void imprimeEvento(){
        System.out.println("Id: "+this.id);
        System.out.println("Nome: "+this.nome);
        System.out.println("Inicio: "+this.dataInicio);
        System.out.println("Termino: "+this.dataFim);
        System.out.println("Usuario: "+this.idUsuario);
        System.out.println("local "+this.local);
        System.out.println("Descricao: "+this.descricao);
    }

    
}