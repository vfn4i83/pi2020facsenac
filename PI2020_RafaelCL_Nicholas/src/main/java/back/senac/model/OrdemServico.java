package back.senac.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ordem_servico")
public class OrdemServico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ose_id")
	private Long id;

//	@Temporal(TemporalType.DATE)
	@Column(name = "ose_data_emissao")
	private Date data_emisao;

//	@Temporal(TemporalType.DATE)
	@Column(name = "ose_data_fechamento")
	private Date data_fechamento;

	@Column(name = "ose_status")
	private String status;

	@Column(name = "ose_descricao")
	private String descricao;

	@Column(name = "ose_local")
	@Size(min = 0, max = 40)
	private String Local;

//	** TESTE ****************
//	** TESTE **************** 
	
//	@ManyToOne
//	@JoinColumn(name = "pes_id_cli")
//	private Pessoa os_pes_id_cli;
//	
//	public Pessoa getOs_pes_id_cli() {
//		return os_pes_id_cli;
//	}
//
//	public void setOs_pes_id_cli(Pessoa os_pes_id_cli) {
//		this.os_pes_id_cli = os_pes_id_cli;
//	}
//
//	@ManyToOne
//	@JoinColumn(name = "pes_id_cli")
//	private Pessoa os_pes_id_fun;
//		
//	public Pessoa getOs_pes_id_fun() {
//		return os_pes_id_fun;
//	}
//
//	public void setOs_pes_id_fun(Pessoa os_pes_id_fun) {
//		this.os_pes_id_fun = os_pes_id_fun;
//	}
//	
//	@OneToMany
//	@JoinColumn(name = "tps_id")
//	private List<TipoServico> tps = new ArrayList<>();
//	
//	public List<TipoServico> getTps() {
//		return tps;
//	}
//	
//	public void setTps(List<TipoServico> tps) {
//		this.tps.addAll(tps);
//	}
//	
//	
//	@OneToMany
//	@JoinColumn(name = "lab_id")
//	private List<Laboratorio> lab = new ArrayList<>();
//	
//	public List<Laboratorio> getLab() {
//		return lab;
//	}
//	
//	public void setLab(List<Laboratorio> lab) {
//		this.lab.addAll(lab);
//	}

//	** TESTE ****************
//	** TESTE ****************
		
//	@Column(name = "pes_id_cli")
	@JoinColumn(name = "pes_id_cli")
	private Long pes_id_cli;
	
//	@Column(name = "pes_id_func")
	@JoinColumn(name = "pes_id_func")
	private Long pes_id_func;

//	@OneToMany
//	@JoinColumn(name = "lab_id")
	@Column(name = "lab_id")
	private Long os_lab_id;

//	@OneToMany
//	@JoinColumn(name = "tps_id")
	@Column(name = "tps_id")
	private Long os_tps_id;

//	***********************

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getData_emisao() {
		return data_emisao;
	}

	public void setData_emisao(Date data_emisao) {
		this.data_emisao = data_emisao;
	}

	public Date getData_fechamento() {
		return data_fechamento;
	}

	public void setData_fechamento(Date data_fechamento) {
		this.data_fechamento = data_fechamento;
	}

	public Long getPes_id_cli() {
		return pes_id_cli;
	}

	public void setPes_id_cli(Long pes_id_cli) {
		this.pes_id_cli = pes_id_cli;
	}

	public Long getPes_id_func() {
		return pes_id_func;
	}

	public void setPes_id_func(Long pes_id_func) {
		this.pes_id_func = pes_id_func;
	}

	public Long getOs_lab_id() {
		return os_lab_id;
	}

	public void setOs_lab_id(Long os_lab_id) {
		this.os_lab_id = os_lab_id;
	}

	public Long getOs_tps_id() {
		return os_tps_id;
	}

	public void setOs_tps_id(Long os_tps_id) {
		this.os_tps_id = os_tps_id;
	}

	public OrdemServico() {
	}

}
