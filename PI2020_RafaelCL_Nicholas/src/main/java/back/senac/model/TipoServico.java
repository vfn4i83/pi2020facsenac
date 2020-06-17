package back.senac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_servico")
public class TipoServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tps_id")
	private Long id;
	
	@Column(name = "tps_descricao")
	private String descricao;

//	*********************
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	/*
	 * TESTES
	 */
//	@ManyToOne
//	private OrdemServico os;
//
//	public OrdemServico getOs() {
//		return os;
//	}
//
//	public void setOs(OrdemServico os) {
//		this.os = os;
//	}
	
	
	

}
