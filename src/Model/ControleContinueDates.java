package Model;

public class ControleContinueDates {
	  private int idCc;
      private String nomModule;
      private String dateCc;
      
      
	public ControleContinueDates(int idCc, String nomModule, String dateCc) {
		super();
		this.idCc = idCc;
		this.nomModule = nomModule;
		this.dateCc = dateCc;
	}

	public ControleContinueDates(String nomModule, String dateCc) {
		super();
		this.nomModule = nomModule;
		this.dateCc = dateCc;
	}

	public int getIdCc() {
		return idCc;
	}

	public void setIdCc(int idCc) {
		this.idCc = idCc;
	}

	public String getNomModule() {
		return nomModule;
	}

	public void setNomModule(String nomModule) {
		this.nomModule = nomModule;
	}

	public String getDateCc() {
		return dateCc;
	}

	public void setDateCc(String dateCc) {
		this.dateCc = dateCc;
	}
      
      
}
