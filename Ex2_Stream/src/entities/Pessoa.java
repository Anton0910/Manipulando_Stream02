package entities;

public class Pessoa {
	String email;
	String nome;
	Double salario;
	public Pessoa(String email, String nome, Double salario) {
		
		this.email = email;
		this.nome = nome;
		this.salario = salario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
}
