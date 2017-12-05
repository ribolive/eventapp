package eventapp.models;

public class Evento {
    
    private int id;
    private String nome;
    private String descricao;
    private String dataInicio; 
    private String dataFim;
    private int idUsuario;
    private String local; 

 
    public Evento(String nome, String descricao, String dataInicio, String dataFim, int idUsuario, String local) {
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
    
    /* Método de teste */
    public void imprimeEvento(){
        System.out.println("Nome: "+this.nome);
        System.out.println("Descricao: "+this.descricao);
    }
    
    
  
    
    
    
    
    
    
}