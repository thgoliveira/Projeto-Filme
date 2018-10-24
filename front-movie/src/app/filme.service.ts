import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Filme } from './filme/filme.model';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {
  
  APPID = "&apikey=3ae1cd3a"
  apiUrl = "http://localhost:8080/filme/?t="
  apiUrlAll = "http://localhost:8080/filme/mult?s="
  apiUrlBancoAll = "http://localhost:8080/filme/listar"

  constructor(private http: HttpClient) { }

  buscarUmFilme(titulo: string){
    return this.http.get<Filme>(`${this.apiUrl}${titulo}`);
  }

  buscarVariosFilmes(titulo: string){
    return this.http.get<Filme[]>(`${this.apiUrlAll}${titulo}`);
  }

  buscarTodosDoBanco(){
    return this.http.get<Filme[]>(`${this.apiUrlBancoAll}`);
  }
}
