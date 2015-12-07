package br.unb.cic.imdb.servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.unb.cic.imdb.negocio.Album;
import br.unb.cic.imdb.negocio.Autor;
import br.unb.cic.imdb.negocio.Avaliacao;
import br.unb.cic.imdb.negocio.Faixa;
import br.unb.cic.imdb.negocio.Filme;
import br.unb.cic.imdb.negocio.Genero;
import br.unb.cic.imdb.negocio.IMDBFacade;
import br.unb.cic.imdb.negocio.Sessao;
import br.unb.cic.imdb.negocio.TrabalhoArtistico;
import br.unb.cic.imdb.util.*;
public class ServiceHandler {
	IMDBFacade facade;
	
	public ServiceHandler(){
		facade = ContextoID.instance().facade();
	}
	
	public void consultaAlbum() {
		Scanner s = new Scanner(System.in);
		int op = 0;
		
		while(op != 6){
		
			System.out.print("Como você gostaria de fazer a consulta?");
			System.out.println("");
			
			System.out.println("1 - Pesquisar por título");
			System.out.println("2 - Pesquisar por autor");
			System.out.println("3 - Pesquisar por gênero");
			System.out.println("4 - Pesquisar por ano");
			System.out.println("5 - Ver todos os Albuns");
			System.out.println("6 - Voltar");
			
			op = s.nextInt();
			s.nextLine();
			
			switch(op){
				case 1:
					System.out.println("Digite o título album");
					String nome = s.nextLine();
					Album res = facade.recuperaAlbumPorNome(nome);
					if(res != null){
						res.imprime();
						
						int escolha = 0;
						
						while(escolha != 4){
							System.out.println("O que você deseja fazer?");
							System.out.println("");
							System.out.println("1 - Avaliar");
							System.out.println("2 - Ver comentarios");
							System.out.println("3 - Adicionar Faixa");
							System.out.println("4 - Voltar");
							
							System.out.println("Digite uma opção");
							escolha = s.nextInt();
							s.nextLine();
						
							switch(escolha){
								case 1: 
									avaliarTrabalho(res);
									escolha = 4;
									break;
								case 2:
									res.mostrarComentarios();
									escolha = 4;
									break;
								case 3:
									System.out.println("Digite o nome da faixa");
									String faixaTitulo = s.nextLine();
									
									System.out.println("Digite a duracao");
									int duracao = s.nextInt();
									s.nextLine();
									
									Faixa novaFaixa = new Faixa(faixaTitulo, duracao, res);
									res.getFaixas().add(novaFaixa);
									facade.salvarFaixa(novaFaixa);
									escolha = 4;
								case 4:
									break;
								default:
									System.out.println("Digite uma opção válida");
									break;
								
							}
						}
					}
					else{
						System.out.println("Album não existente");
					}
					return;
				case 2:
					System.out.println("Digite o nome do artista");
					String nomeAutor = s.nextLine();
					
					List<Album> resListAutor = facade.recuperaAlbumPorAutor(nomeAutor);
					
					for(Album album : resListAutor){
						System.out.println("");
						album.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resListAutor.size() == 0){
						System.out.println("Nenhum resultado encontrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				case 3:
					System.out.println("Digite o gênero do album");
					String nomeGenero = s.nextLine();
					
					List<Album> resListGenero = facade.recuperaAlbumPorGenero(nomeGenero);
					
					for(Album album : resListGenero){
						System.out.println("");
						album.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resListGenero.size() == 0){
						System.out.println("Nenhum resultado encontrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				case 4:
					System.out.println("Digite o ano do album");
					int ano = s.nextInt();
					s.nextLine();
					
					List<Album> resListAno = facade.recuperaAlbumPorAno(ano);
					
					for(Album album : resListAno){
						System.out.println("");
						album.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resListAno.size() == 0){
						System.out.println("Nenhum resultado encontrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				case 5:
					List<Album> resList = facade.recuperaTodosAlbuns();
					
					for(Album album : resList){
						System.out.println("");
						album.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resList.size() == 0){
						System.out.println("Nenhum album registrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				default:
					System.out.println("Digite um valor válido");
					break;
			}
		}
		
		
	}

	private void avaliarTrabalho(TrabalhoArtistico trabArt) {
		Scanner s = new Scanner(System.in);
		int op = 6;
		Avaliacao.Classificacao cl = Avaliacao.Classificacao.ZERO;
		
		while(op < 0 || op > 5){
			System.out.println("Quantas estrelas você avalia " + trabArt.getTitulo() + "?\n");
			System.out.println("0 - ");
			System.out.println("1 - *");
			System.out.println("2 - **");
			System.out.println("3 - ***");
			System.out.println("4 - ****");
			System.out.println("5 - *****");
			
			op = s.nextInt();
			s.nextLine();
			
			switch(op){
				case 0: cl = Avaliacao.Classificacao.ZERO; break;
				case 1: cl = Avaliacao.Classificacao.UM; break;
				case 2: cl = Avaliacao.Classificacao.DOIS; break;
				case 3: cl = Avaliacao.Classificacao.TRES; break;
				case 4: cl = Avaliacao.Classificacao.QUATRO; break;
				case 5: cl = Avaliacao.Classificacao.CINCO; break;
			}
			
		}
		
		System.out.println("Digite seu comentario");
		
		String comentario = s.nextLine();
		facade.salvarAvaliacao(new Avaliacao(comentario, cl, trabArt, Sessao.getInstance().getUsuario()));
		
	}

	public void consultaFilme() {
		Scanner s = new Scanner(System.in);
		int op = 0;
		
		while(op != 6){
		
			System.out.print("Como você gostaria de fazer a consulta?");
			System.out.println("");
			
			System.out.println("1 - Pesquisar por título");
			System.out.println("2 - Pesquisar por diretor");
			System.out.println("3 - Pesquisar por gênero");
			System.out.println("4 - Pesquisar por ano");
			System.out.println("5 - Ver todos os Filmes");
			System.out.println("6 - Voltar");
			
			op = s.nextInt();
			s.nextLine();
			
			switch(op){
				case 1:
					System.out.println("Digite o título filme");
					String nome = s.nextLine();
					Filme res = facade.recuperaFilmePorNome(nome);
					if(res != null){
						System.out.println("");
						res.imprime();
						
						int escolha = 0;
						
						while(escolha != 4){
							System.out.println("O que você deseja fazer?");
							System.out.println("");
							System.out.println("1 - Avaliar");
							System.out.println("2 - Ver comentarios");
							System.out.println("3 - Voltar");
							
							System.out.println("Digite uma opção");
							escolha = s.nextInt();
							s.nextLine();
						
							switch(escolha){
								case 1: 
									avaliarTrabalho(res);
									escolha = 4;
									break;
								case 2:
									res.mostrarComentarios();
									escolha = 4;
									break;
								case 3:
									break;
								default:
									System.out.println("Digite uma opção válida");
									break;
								
							}
						}
					}
					else{
						System.out.println("Filme não existente");
					}
					return;
				case 2:
					System.out.println("Digite o nome do diretor");
					String nomeAutor = s.nextLine();
					
					List<Filme> resListAutor = facade.recuperaFilmePorAutor(nomeAutor);
					
					for(Filme filme : resListAutor){
						System.out.println("");
						filme.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resListAutor.size() == 0){
						System.out.println("Nenhum resultado encontrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				case 3:
					System.out.println("Digite o gênero do filme");
					String nomeGenero = s.nextLine();
					
					List<Filme> resListGenero = facade.recuperaFilmePorGenero(nomeGenero);
					
					for(Filme filme : resListGenero){
						System.out.println("");
						filme.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resListGenero.size() == 0){
						System.out.println("Nenhum resultado encontrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				case 4:
					System.out.println("Digite o ano do filme");
					int ano = s.nextInt();
					s.nextLine();
					
					List<Filme> resListAno = facade.recuperaFilmePorAno(ano);
					
					for(Filme filme : resListAno){
						System.out.println("");
						filme.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resListAno.size() == 0){
						System.out.println("Nenhum resultado encontrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				case 5:
					List<Filme> resList = facade.recuperaTodosFilmes();
					
					for(Filme filme : resList){
						System.out.println("");
						filme.imprime();
						System.out.println("-----------------------------------------");
					}
					
					if(resList.size() == 0){
						System.out.println("Nenhum album registrado");
					}
					
					s.nextLine();
					System.out.println("");
					break;
				default:
					System.out.println("Digite um valor válido");
					break;
			}
		}
		
		

		
	}

	public boolean adicionaGenero() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o nome do Genero");
		String nome = s.nextLine();
		System.out.println("Digite a Descricao desse Genero");
		String descricao = s.nextLine();
		
		try{
			facade.adicionaGenero(new Genero(nome, descricao));
		}
		catch(IllegalArgumentException ex){
			System.out.println("Genero já existente");
			return false;
		}
		System.out.println("Genero criado!\n");
		return true;
		
	}

	public boolean adicionaAutor() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o nome do Autor");
		String nome = s.nextLine();
		System.out.println("Digite a Descricao desse Autor");
		String descricao = s.nextLine();
		
		try{
			facade.salvarAutor(new Autor(nome, descricao));
		}
		catch(IllegalArgumentException ex){
			System.out.println("Autor já existente");
			return false;
		}
		System.out.println("Autor criado!\n");
		return true;
	}

	public void adicionaAlbum() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o nome do Album");
		String titulo = s.nextLine();
		
		System.out.println("Digite o nome do Artista");
		
		String autorName = s.nextLine();
		
		Autor autor = facade.recuperaAutorPorNome(autorName);
		if (autor == null){
			System.out.println("Autor não existente, deseja adiciona-lo? (S/N)");
			String r = s.nextLine();
			if(r.equals("s")){
				if(!adicionaAutor()){
					return;
				}
			}
			else{
				System.out.println("Operação terminada");
				return;
			}
			autor = facade.recuperaAutorPorNome(autorName);
		}
		
		System.out.println("Digite o ano");
		int ano = s.nextInt();
		s.nextLine();
		
		System.out.println("Digite o Gênero");
		String generoName = s.nextLine();
		
		Genero genero = facade.recuperarGeneroPorTitulo(generoName);
		
		if(genero == null){
			System.out.println("Genero não existente, deseja adiciona-lo? (S/N)");
			String r = s.nextLine();
			if(r.equals("s")){
				
				if(!adicionaGenero()){
					return;
				}
			}
			else{
				System.out.println("Operação terminada");
				return;
			}
			genero = facade.recuperarGeneroPorTitulo(generoName);
		}
		
		Album novoAlbum = new Album(titulo, ano, genero, autor);
		
		ArrayList<Faixa> faixas = new ArrayList<Faixa>();
		System.out.println("Adicione faixas");
		String resposta = "s";
		while(resposta.equals("s")){
			System.out.println("Digite o nome da faixa");
			String faixaTitulo = s.nextLine();
			System.out.println("Digite a duracao");
			int duracao = s.nextInt();
			s.nextLine();
			faixas.add(new Faixa(faixaTitulo, duracao, novoAlbum));
			System.out.println("Adicionar outra faixa? s/n");
			resposta = s.nextLine();
		}
		novoAlbum.setFaixas(faixas);
		try{
			facade.adicionaAlbum(novoAlbum);
		}
		catch(IllegalArgumentException ex){
			System.out.println("Album ja existente");
			return;
		}
		for(Faixa faixa : faixas){
			facade.salvarFaixa(faixa);
		}
	}

	public void adicionaFilme() {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Digite o nome do Filme");
		String titulo = s.nextLine();
		
		System.out.println("Digite o nome do Diretor");
		
		String autorName = s.nextLine();
		
		Autor autor = facade.recuperaAutorPorNome(autorName);
		if (autor == null){
			System.out.println("Diretor não existente, deseja adiciona-lo? (S/N)");
			String r = s.nextLine();
			if(r.equals("s")){
				if(!adicionaAutor()){
					return;
				}
				autor = facade.recuperaAutorPorNome(autorName);
			}
			else{
				System.out.println("Operação terminada");
				return;
			}
		}
		
		System.out.println("Digite o ano");
		int ano = s.nextInt();
		s.nextLine();
		
		System.out.println("Digite o Gênero");
		String generoName = s.nextLine();
		
		Genero genero = facade.recuperarGeneroPorTitulo(generoName);
		
		if(genero == null){
			System.out.println("Genero não existente, deseja adiciona-lo? (S/N)");
			String r = s.nextLine();
			if(r.equals("s")){
				
				if(!adicionaGenero()){
					return;
				}
				genero = facade.recuperarGeneroPorTitulo(generoName);
			}
			else{
				System.out.println("Operação terminada");
				return;
			}
		}
		
		System.out.println("Digite a duracao do filme");
		int duracao = s.nextInt();
		s.nextLine();
		
		Filme novoFilme = new Filme(titulo, ano, genero, autor, duracao);
		try{
			facade.adicionaFilme(novoFilme);
		}
		catch(IllegalArgumentException ex){
			System.out.println("Filme ja existente");
			return;
		}
	}
}
