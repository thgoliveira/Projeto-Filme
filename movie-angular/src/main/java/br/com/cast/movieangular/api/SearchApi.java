package br.com.cast.movieangular.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchApi {
	
	@JsonProperty("Search")
	private List<SearchResultApi> search;

	public List<SearchResultApi> getSearch() {
		return search;
	}

	public void setSearch(List<SearchResultApi> search) {
		this.search = search;
	}
	
	

}
