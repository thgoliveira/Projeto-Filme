package br.com.cast.movieangular.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.movieangular.dto.MovieDataDto;
import br.com.cast.movieangular.service.MovieService;

@RestController
@RequestMapping(path = "/filme")
public class MovieApi {
	
	@Autowired
	private MovieService mService;
	
	@GetMapping(path = "/single")
	public MovieDataDto getUmFilme(@RequestParam("t") String titulo) {
		return mService.getUmFilme(titulo);
	}
	
	@GetMapping(path = "/mult")
	public List<MovieDataDto> getVariosFilmes(@RequestParam("s") String titulo){
		return mService.getFilmes(titulo);
	}
	
	
	
}
