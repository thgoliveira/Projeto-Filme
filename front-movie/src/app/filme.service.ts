import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Filme } from './filme/filme.model';

@Injectable({
  providedIn: 'root'
})
export class FilmeService {

  apiUrl = "http://localhost:8080/filme/?t="

  constructor(private http: HttpClient) { }

  buscar(titulo: string){
    return this.http.get<Filme>(`${this.apiUrl}${titulo}`);
  }
}
