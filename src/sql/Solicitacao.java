package sql;

public class Solicitacao {

	 private int id;
	    private int idUsuario; // FK para Usuario
	    private int idEspaco;  // FK para Espaco
	    private String dataSolicitacao;
	    private String dataReserva;
	    private String status; // "Pendente", "Aprovado", "Rejeitado"
	    private String justificativa; // Opcional

	    // Construtor
	    public Solicitacao(int id, int idUsuario, int idEspaco, String dataSolicitacao, String dataReserva, String status, String justificativa) {
	        this.id = id;
	        this.idUsuario = idUsuario;
	        this.idEspaco = idEspaco;
	        this.dataSolicitacao = dataSolicitacao;
	        this.dataReserva = dataReserva;
	        this.status = status;
	        this.justificativa = justificativa;
	    }

	    // Getters e Setters
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public int getIdUsuario() {
	        return idUsuario;
	    }

	    public void setIdUsuario(int idUsuario) {
	        this.idUsuario = idUsuario;
	    }

	    public int getIdEspaco() {
	        return idEspaco;
	    }

	    public void setIdEspaco(int idEspaco) {
	        this.idEspaco = idEspaco;
	    }

	    public String getDataSolicitacao() {
	        return dataSolicitacao;
	    }

	    public void setDataSolicitacao(String dataSolicitacao) {
	        this.dataSolicitacao = dataSolicitacao;
	    }

	    public String getDataReserva() {
	        return dataReserva;
	    }

	    public void setDataReserva(String dataReserva) {
	        this.dataReserva = dataReserva;
	    }

	    public String getStatus() {
	        return status;
	    }

	    public void setStatus(String status) {
	        this.status = status;
	    }

	    public String getJustificativa() {
	        return justificativa;
	    }

	    public void setJustificativa(String justificativa) {
	        this.justificativa = justificativa;
	    }
	}
