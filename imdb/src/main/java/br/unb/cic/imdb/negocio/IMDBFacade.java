package br.unb.cic.imdb.negocio;

import java.util.List;

import br.unb.cic.imdb.integracao.*;
import br.unb.cic.imdb.integracao.jpa.DAOTrabArtJPA;

/**
 * Classe de fachada (Facade class) que vai servir de comunicacao 
 * entre a camada de apresentacao (ui) e a camada de negocio. Caso 
 * se torne excessivamente complexa, essa classe deve ser sub-dividida.
 *  
 * @author rbonifacio
 */
public class IMDBFacade {
	
	private DAOGenero daoGenero;
	private DAOFilme daoFilme;
	private DAOAlbum daoAlbum;
	private DAOAutor daoAutor;
	private DAOTrabArt daoTrabArt;
	private DAOAvaliacao daoAvaliacao;
	private DAOFaixa daoFaixa;
	private DAOUsuario daoUsuario;

	public IMDBFacade() {}
	
	//Usando o Spring Framework, o construtor declarado 
	//nas proximas linhas se torna desnecessario, uma vez 
	//que o proprio Spring injeta as implementacoes corretas das classes DAOs. 
	
//	public IMDBFacade() {
//			daoGenero = DAOFactory.instance(DataBase.SQLDB).createDAOGenero();
//	}
	
	public void adicionaGenero(Genero genero) {
		if(recuperarGeneroPorTitulo(genero.getTitulo()) == null) {
			daoGenero.salvar(genero);
		}
		else { 
			throw new IllegalArgumentException();
		}
	}

	//Generos
	
	public List<Genero> recuperarGeneros() {
		return daoGenero.recuperaTodos();
	}

	public Genero recuperarGeneroPorTitulo(String titulo) {
		return daoGenero.recuperaPorTitulo(titulo);
	}
	
	//Filmes
	
	public void adicionaFilme(Filme filme){
		if(daoFilme.recuperaPorNome(filme.getTitulo()) == null){
			daoFilme.salvar(filme);
		}
		else
			throw new IllegalArgumentException();
		
	}
	
	public List<Filme> recuperaTodosFilmes(){
		return daoFilme.recuperaTodos();
	}
	
	public Filme recuperaFilmePorNome(String titulo){
		return daoFilme.recuperaPorNome(titulo);
	}
	
	public List<Filme> recuperaFilmePorAutor(String autor){
		return daoFilme.recuperaPorAutor(autor);
	}
	
	public List<Filme> recuperaFilmePorGenero(String genero){
		return daoFilme.recuperaPorGenero(genero);
	}
	
	public List<Filme> recuperaFilmePorAno(int ano){
		return daoFilme.recuperaPorAno(ano);
	}
	
	//Album
	
	public void adicionaAlbum(Album album){
		if(daoAlbum.recuperaPorNome(album.getTitulo()) == null){
			daoAlbum.salvar(album);
		}
		else
			throw new IllegalArgumentException();
		
	}
	
	public List<Album> recuperaTodosAlbuns(){
		return daoAlbum.recuperaTodos();
	}
	
	public Album recuperaAlbumPorNome(String titulo){
		return daoAlbum.recuperaPorNome(titulo);
	}
	
	public List<Album> recuperaAlbumPorAutor(String autor){
		return daoAlbum.recuperaPorAutor(autor);
	}
	
	public List<Album> recuperaAlbumPorGenero(String genero){
		return daoAlbum.recuperaPorGenero(genero);
	}
	
	public List<Album> recuperaAlbumPorAno(int ano){
		return daoAlbum.recuperaPorAno(ano);
	}
	
	//Autor
	
	public void salvarAutor(Autor autor){
		if(daoAutor.recuperaPorNome(autor.getNome()) == null)
			daoAutor.salvar(autor);
		else
			throw new IllegalArgumentException();
	}
	
	public Autor recuperaAutorPorNome(String autor){
		return daoAutor.recuperaPorNome(autor);
	}
	
	public List<Autor> recuperaTodosOsAutores(){
		return daoAutor.recuperaTodos();
	}
	
	//Avaliacao
	
	public void salvarAvaliacao(Avaliacao avaliacao){
		daoAvaliacao.salvarAvaliacao(avaliacao);	
	}
	
	//Faixa
	
	public void salvarFaixa(Faixa faixa){
		daoFaixa.salvaFaixa(faixa);
	}
	
	//Usuario
	
	public Usuario recuperaUsuario(String usuario){
		return daoUsuario.recuperaUsuario(usuario);
	}
	
	public void salvaUsuario(Usuario usuario){
		if(daoUsuario.recuperaUsuario(usuario.getLogin()) == null){
			daoUsuario.salvaUsuario(usuario);
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	//Getters e Setters
	
	public void setDaoGenero(DAOGenero daoGenero) {
		this.daoGenero = daoGenero;
	}

	public DAOFilme getDaoFilme() {
		return daoFilme;
	}

	public void setDaoFilme(DAOFilme daoFilme) {
		this.daoFilme = daoFilme;
	}

	public DAOAlbum getDaoAlbum() {
		return daoAlbum;
	}

	public void setDaoAlbum(DAOAlbum daoAlbum) {
		this.daoAlbum = daoAlbum;
	}

	public DAOAutor getDaoAutor() {
		return daoAutor;
	}

	public void setDaoAutor(DAOAutor daoAutor) {
		this.daoAutor = daoAutor;
	}

	public DAOTrabArt getDaoTrabArt() {
		return daoTrabArt;
	}

	public void setDaoTrabArt(DAOTrabArt daoTrabArt) {
		this.daoTrabArt = daoTrabArt;
	}

	public DAOGenero getDaoGenero() {
		return daoGenero;
	}

	public DAOAvaliacao getDaoAvaliacao() {
		return daoAvaliacao;
	}

	public void setDaoAvaliacao(DAOAvaliacao daoAvaliacao) {
		this.daoAvaliacao = daoAvaliacao;
	}

	public DAOFaixa getDaoFaixa() {
		return daoFaixa;
	}

	public void setDaoFaixa(DAOFaixa daoFaixa) {
		this.daoFaixa = daoFaixa;
	}

	public DAOUsuario getDaoUsuario() {
		return daoUsuario;
	}

	public void setDaoUsuario(DAOUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
}
