package back.senac.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
//	@JoinColumn(name = "ose_id")
	@Column(name = "ose_id")
	private Long ose_id;
	
//	@OneToMany
	@JoinColumn(name = "pes_id")
	@Column(name = "pes_id")
	private Long pes_id;

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

	public Long getOse_id() {
		return ose_id;
	}

	public void setOse_id(Long ose_id) {
		this.ose_id = ose_id;
	}

	public Long getPes_id() {
		return pes_id;
	}

	public void setPes_id(Long pes_id) {
		this.pes_id = pes_id;
	}

	
	
	
	
}
