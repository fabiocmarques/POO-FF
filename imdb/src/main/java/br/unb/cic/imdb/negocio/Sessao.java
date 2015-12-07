package br.unb.cic.imdb.negocio;

import java.util.Scanner;
import br.unb.cic.imdb.util.*;

public class Sessao {
	private Usuario usuario;
	private static Sessao sessao;
	
	private Sessao(){
		
	}
	
	public static Sessao getInstance(){
		if(sessao == null){
			sessao = new Sessao();
		}
		return sessao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void login() {
		int op = 0;
		
		while(op < 1 || op > 3){
		
			System.out.println("1 - Criar conta");
			System.out.println("2 - Fazer Login");
			System.out.println("3 - Sair");
			
			System.out.println("Digite uma opção:");
			Scanner s = new Scanner(System.in);
			op = s.nextInt();
			s.nextLine();
			
			switch(op){
				case 1: 
					criarConta();
					break;
				case 2:
					logar();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.out.println("Digite uma opção válida");
					
			}
			
		}
	}

	private void logar() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o usuario");
		String login = s.nextLine();
		System.out.println("Digite a senha");
		String senha = s.nextLine();
		
		IMDBFacade facade = ContextoID.instance().facade();
		Usuario usuario = facade.recuperaUsuario(login);
		if(usuario != null && senha.equals(usuario.getSenha())){
			this.usuario = usuario;
		}
		else{
			System.out.println("Login inválido");
			System.out.println("Deseja tentar novamente?s/n");
			
			String r = s.nextLine();
			
			if(r.equals("s")){
				logar();
			}
			else{
				System.exit(0);
			}
		}
		
	}

	private void criarConta() {
		Scanner s = new Scanner(System.in);
		System.out.println("Digite seu usuario");
		String login = s.nextLine();
		System.out.println("Digite sua senha");
		String senha = s.nextLine();
		
		usuario = new Usuario(login, senha);
		
		IMDBFacade facade = ContextoID.instance().facade();
		try{
			facade.salvaUsuario(usuario);
		}
		catch(IllegalArgumentException ex){
			System.out.println("Usuario ja existe. tente novamente");
			criarConta();
		}
	}
}
