package back.senac.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historico")
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "his_id")
	private Long id;

//	Aqui vai me foder. tipo DATE -> isto zinga a coisa
	@Column(name = "his_data")
	private Date data;
	
	@Column(name = "his_status")
	private String status;
	
//	@ManyToOne
	@Column(name = "ose_id")
	private String telelone;
	
//	@ManyToOne
	@Column(name = "pes_id")
	private String email;

//	***********************
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTelelone() {
		return telelone;
	}

	public void setTelelone(String telelone) {
		this.telelone = telelone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
