package br.unb.cic.imdb.servico;

import java.util.Scanner;

import br.unb.cic.imdb.negocio.Sessao;

public class Main {
	public static void main(String args[]){
		Sessao.getInstance().login();
		
		ServiceHandler services = new ServiceHandler();
		Scanner s = new Scanner(System.in);
		int op = 0;
		
		while(op != 7){
			
			System.out.println(Sessao.getInstance().getUsuario().getLogin() + ", seja bem vindo ao IMDB!");
			System.out.println("O que você deseja fazer?");
			System.out.println("");
			System.out.println("1 - Consultar Filme");
			System.out.println("2 - Adicionar Filme");
			System.out.println("3 - Consultar Album");
			System.out.println("4 - Adicionar Album");
			System.out.println("5 - Adicionar um Autor");
			System.out.println("6 - Adicionar um Gênero");
			System.out.println("7 - Sair");
			
			op = s.nextInt();
			s.nextLine();
			
			switch(op){
				case 1:
					services.consultaFilme();
					break;
				case 2:
					services.adicionaFilme();
					break;
				case 3:
					services.consultaAlbum();
					break;
				case 4:
					services.adicionaAlbum();
					break;
				case 5:
					services.adicionaAutor();
					break;
				case 6:
					services.adicionaGenero();
					break;
				case 7:
					break;
				default:
					System.out.println("Digite uma opção válida");
					break;
			}
		}
		
	}
}
