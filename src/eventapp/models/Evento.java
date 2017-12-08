package eventapp.models;
import eventapp.excecoes.EventoExcecao;

public class Evento {

    
    private int id;
    private String nome;
    private String descricao;
    private String dataInicio; 
    private String dataFim;
    private int idUsuario;
    private String local; 

 
    public Evento(String nome, String descricao, String dataInicio, String dataFim, int idUsuario, String local) throws Exception{
         if (nome.isEmpty()){
            throw new EventoExcecao("nome");
        }
        
        if (descricao.isEmpty()){
            throw new EventoExcecao("descrição");
        }
        
        if (dataInicio.isEmpty()){
            throw new EventoExcecao("data de início");
        }
        
        if (dataFim.isEmpty()){
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

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getId() {
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
        System.out.println("Nome: "+this.nome);
        System.out.println("Descricao: "+this.descricao);
    }

    
}