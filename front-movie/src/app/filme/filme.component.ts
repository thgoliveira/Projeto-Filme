import { Component, OnInit } from '@angular/core';
import { FilmeService } from '../filme.service';
import { Filme } from './filme.model';
import { Search } from './filme-search.model';

@Component({
  selector: 'app-filme',
  templateUrl: './filme.component.html',
  styleUrls: ['./filme.component.css']
})
export class FilmeComponent implements OnInit {

  search: Search;
  filme: Filme;
  filmes: Array<any>;
  texto: string;

  constructor(private fs: FilmeService) { }

  ngOnInit() {
    this.search = new Search();
    this.filme = new Filme();
    this.filmes = new Array();
  }

  buscarUmFilme(){
    this.fs.buscarUmFilme(this.texto).subscribe(dados => this.filme = dados);
  }

  buscarVariosFilmes(){
    this.fs.buscarVariosFilmes(this.texto).subscribe(dados => this.filmes = dados)
  }

}
