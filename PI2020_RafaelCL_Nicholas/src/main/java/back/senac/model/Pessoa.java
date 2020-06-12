package back.senac.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pes_id")
	private Long id;

	@Column(name = "pes_nome")
	private String nome;
	
	@Column(name = "pes_cpf_cnpj")
	private String cpf_cnpj;
	
	@Column(name = "pes_telefone")
	private String telelone;
	
	@Column(name = "pes_email")
	private String email;
	
	@Column(name = "pes_funcao")
	private String funcao;
	
	@Column(name = "pes_login")
	private String login;
	
	@Column(name = "pes_senha")
	private String senha;
	
	@Column(name = "pes_perfil")
	private String perfil;

//	*********************
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

}
