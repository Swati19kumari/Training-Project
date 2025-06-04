package com.java.jsf;


public class LoginController {
	
	private Logindao logindao;
	
	private Login login;
	
	
	private String message;
	
	
	
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Logindao getLogindao() {
		return logindao;
	}

	public void setLogindao(Logindao logindao) {
		this.logindao = logindao;
	}
	
	
	public String signUp() {
		
		return logindao.SignUp(login);
	}
	
	public String signIn() {
		
		System.out.println("this is signInMethod call");
		return logindao.SignIn(login);
	}
	

}
