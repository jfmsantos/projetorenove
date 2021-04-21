package br.com.renowe.objetos;

public class Configuracao {

	private String email;
	private String RedirectURL;
	private String token;
	private String sistema;
	private String complementoCaminho;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRedirectURL() {
		return RedirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		RedirectURL = redirectURL;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getSistema() {
		return sistema;
	}

	public void setSistema(String sistema) {
		this.sistema = sistema;
	}

	public String getComplementoCaminho() {
		return complementoCaminho;
	}

	public void setComplementoCaminho(String complementoCaminho) {
		this.complementoCaminho = complementoCaminho;
	}

}
