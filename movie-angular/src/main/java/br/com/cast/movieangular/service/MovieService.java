package br.com.cast.movieangular.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cast.movieangular.api.MovieClient;
import br.com.cast.movieangular.api.MovieData;
import br.com.cast.movieangular.api.SearchApi;
import br.com.cast.movieangular.api.SearchResultApi;
import br.com.cast.movieangular.dto.MovieDataDto;
import br.com.cast.movieangular.modelo.Movie;
import br.com.cast.movieangular.modelo.Search;
import br.com.cast.movieangular.repositorio.MovieRepository;

@Service
public class MovieService {

	@Autowired
	private MovieClient mClient;

	@Autowired
	private MovieRepository mRepository;
	
	
	public MovieDataDto getUmFilme(String imdbid) {
		Search movie = mRepository.buscarFilme(imdbid);
		MovieDataDto mdDto = entityToDto(imdbid, movie);
		return mdDto;
	}
	

	/**
	 * Metodo para inserir um filme detalhado no banco
	 * 
	 * @param imdbid
	 * @return
	 */
	public MovieDataDto getUmFilmeDetalhado(String imdbid) {

		Search mBusca = mRepository.buscarFilme(imdbid);
		MovieDataDto resposta = new MovieDataDto();

		if (mBusca.getIdfilme() == null) {
			MovieData mDataOmdb = mClient.getUmFilme(imdbid);
			resposta = apiToDto(imdbid, mDataOmdb);
			 Movie teste = dtoToEntity(resposta);
			 mBusca.setIdfilme(teste);
			mRepository.alterar(mBusca);
		} else {
			resposta = entityToDto(imdbid, mBusca);
		}

		return resposta;
	}

	/**
	 * Metodo para inserir no banco todos os filmes consultados na Api
	 * 
	 * @param titulo
	 * @return
	 */
	public List<MovieDataDto> getFilmesApi(String titulo) {

		List<MovieDataDto> data = new ArrayList<>();
		List<Search> entidade = mRepository.buscarTudoPorTitulo(titulo);

		Map<String, MovieDataDto> map = new HashMap<>();
		SearchApi buscar = mClient.getVariosFilmes(titulo);
		
		for (SearchResultApi srApi : buscar.getSearch()) {
			MovieDataDto mdDto = new MovieDataDto();

			mdDto.setTitulo(srApi.getTitulo());
			mdDto.setAno(srApi.getAno());
			mdDto.setImdbid(srApi.getImdbid());
			mdDto.setType(srApi.getType());

			if (srApi.getPoster().equals("N/A")) {
				mdDto.setPoster("../../assets/img/image-not-found.jpg");
			} else {
				mdDto.setPoster(srApi.getPoster());
			}
			
				map.put(titulo, mdDto);
				data.add(mdDto);

				Search search = new Search();
				
				if (!jaExisteNoMeuBanco(entidade, mdDto.getImdbid())) {
					search.setTitulo(mdDto.getTitulo());
					search.setAno(mdDto.getAno());
					search.setImdbid(mdDto.getImdbid());
					search.setType(mdDto.getType());
					search.setPoster(mdDto.getPoster());
					mRepository.inserir(search);
			}
		}
		return data;
	}
	
	private boolean jaExisteNoMeuBanco(List<Search> entidades, String imdbid) {
		for (Search search : entidades) {
			if (search.getImdbid().equals(imdbid)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Metodo para coletar todos os filmes do banco sem detalhes
	 * 
	 * @return
	 */
	public List<MovieDataDto> getTodosBanco() {

		List<MovieDataDto> mdDtos = new ArrayList<>();
		List<Search> movies = mRepository.buscarTudo();

		for (Search movie : movies) {
			MovieDataDto mdDto = new MovieDataDto();
			mdDto.setTitulo(movie.getTitulo());
			mdDto.setAno(movie.getAno());
			mdDto.setImdbid(movie.getImdbid());
			mdDto.setType(movie.getType());
			if (movie.getPoster().equals("N/A")) {
				mdDto.setPoster("../../assets/img/image-not-found.jpg");
			} else {
				mdDto.setPoster(movie.getPoster());
			}
			mdDtos.add(mdDto);
		}
		return mdDtos;
	}

	// --> Conversores

	private MovieDataDto entityToDto(String imdbid, Search search) {
		MovieDataDto mdDto = new MovieDataDto();
		mdDto.setTitulo(search.getTitulo());
		mdDto.setAno(search.getAno());
		mdDto.setImdbid(search.getImdbid());
		mdDto.setPoster(search.getPoster());
		mdDto.setType(search.getType());
		mdDto.setIdfilme(search.getIdfilme().getImdbid());
		mdDto.setAtores(search.getIdfilme().getAtores());
		mdDto.setDiretor(search.getIdfilme().getDiretor());
		mdDto.setDuracao(search.getIdfilme().getDuracao());
		mdDto.setEscritor(search.getIdfilme().getEscritor());
		mdDto.setEstreia(search.getIdfilme().getEstreia());
		mdDto.setGenero(search.getIdfilme().getGenero());
		mdDto.setImdbrating(search.getIdfilme().getImdbrating());
		mdDto.setPremiacoes(search.getIdfilme().getPremiacoes());
		mdDto.setProduction(search.getIdfilme().getProduction());
		mdDto.setRoteiro(search.getIdfilme().getRoteiro());

		return mdDto;
	}

	private MovieDataDto apiToDto(String imdbid, MovieData mData) {
		MovieDataDto mdDto = new MovieDataDto();
		mdDto.setTitulo(mData.getTitulo());
		mdDto.setAno(mData.getAno());
		mdDto.setIdfilme(mData.getImdbid());
		mdDto.setEstreia(mData.getEstreia());
		mdDto.setDuracao(mData.getDuracao());
		mdDto.setGenero(mData.getGenero());
		mdDto.setDiretor(mData.getDiretor());
		mdDto.setEscritor(mData.getEscritor());
		mdDto.setAtores(mData.getAtores());
		mdDto.setRoteiro(mData.getRoteiro());
		mdDto.setPremiacoes(mData.getPremiacoes());
		mdDto.setPoster(mData.getPoster());
		mdDto.setImdbrating(mData.getImdbrating());
		mdDto.setImdbid(imdbid);
		mdDto.setType(mData.getType());
		mdDto.setProduction(mData.getProduction());
		return mdDto;
	}

	private Movie dtoToEntity(MovieDataDto mdDto) {
		/*Search search = new Search();
		search.setTitulo(mdDto.getTitulo());
		search.setAno(mdDto.getAno());
		search.setImdbid(mdDto.getImdbid());
		search.setPoster(mdDto.getPoster());
		search.setType(mdDto.getType());*/

		Movie movie = new Movie();
		movie.setImdbid(mdDto.getImdbid());
		movie.setAtores(mdDto.getAtores());
		movie.setDiretor(mdDto.getDiretor());
		movie.setDuracao(mdDto.getDuracao());
		movie.setEscritor(mdDto.getEscritor());
		movie.setEstreia(mdDto.getEstreia());
		movie.setGenero(mdDto.getGenero());
		movie.setImdbrating(mdDto.getImdbrating());
		movie.setPremiacoes(mdDto.getPremiacoes());
		movie.setProduction(mdDto.getProduction());
		movie.setRoteiro(mdDto.getRoteiro());

		//search.setIdfilme(movie);
		return movie;
	}

}
