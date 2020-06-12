package back.senac.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ose_id")
	private Long id;

	@Column(name = "ose_data_emissao")
	private Date dataEmisao;

	@Column(name = "ose_data_fechamento")
	private Date dataFechamento;

	@Column(name = "ose_status")
	private String status;

	@Column(name = "ose_descricao")
	private String descricao;

	@Column(name = "ose_local")
	@Size(min = 0, max = 40)
	private String Local;

//	@ManyToOne
//	@validarAlgo 
// 	@JoinColumn(name = "pes_id")
//	@Column(name = "pes_id_cli")
//	private Long pes_id_cli_fun; // XXX conversar com prof. ? ? ? ?
	
	/*Ainda nao tenho uso p isto
	 * tps_id 
	 * lab_id 
	 * pes_id_func
	 */

//	***********************
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmisao() {
		return dataEmisao;
	}

	public void setDataEmisao(Date dataEmisao) {
		this.dataEmisao = dataEmisao;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	
	
	
	
}
