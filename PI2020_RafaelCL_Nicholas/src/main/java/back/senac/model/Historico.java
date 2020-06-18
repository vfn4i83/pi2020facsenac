package back.senac.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "historico")
public class Historico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "his_id")
	private Long id;

	@Column(name = "his_data")
	private Date data;
	
	@Column(name = "his_status")
	private String status;
	
	@OneToOne
	@JoinColumn(name = "ose_id")
	private OrdemServico ose;
	
	@OneToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;

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

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public OrdemServico getOse() {
		return ose;
	}

	public void setOse(OrdemServico ose) {
		this.ose = ose;
	}

	
	
}
