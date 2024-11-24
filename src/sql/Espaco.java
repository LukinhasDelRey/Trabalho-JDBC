package sql;

public class Espaco {
    private int id;
    private String nome;
    private String descricao;
    private int capacidade;
    private String equipamentosDisponiveis;
    private boolean disponivel;

    // Construtor
    public Espaco(int id, String nome, String descricao, int capacidade, String equipamentosDisponiveis, boolean disponivel) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.capacidade = capacidade;
        this.equipamentosDisponiveis = equipamentosDisponiveis;
        this.disponivel = disponivel;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getEquipamentosDisponiveis() {
        return equipamentosDisponiveis;
    }

    public void setEquipamentosDisponiveis(String equipamentosDisponiveis) {
        this.equipamentosDisponiveis = equipamentosDisponiveis;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
