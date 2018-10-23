import { Component, OnInit } from '@angular/core';
import { FilmeService } from '../filme.service';
import { Filme } from './filme.model';

@Component({
  selector: 'app-filme',
  templateUrl: './filme.component.html',
  styleUrls: ['./filme.component.css']
})
export class FilmeComponent implements OnInit {

  filme: Filme;
  filmes: Array<Filme>;
  titulo: string;

  constructor(private fs: FilmeService) { }

  ngOnInit() {
    this.filme = new Filme();
    this.filmes = new Array();
  }

  buscarUmFilme(){
    this.fs.buscarUmFilme(this.titulo).subscribe(dados => this.filme = dados);
  }

  buscarVariosFilmes(){
    this.fs.buscarVariosFilmes(this.titulo).subscribe(dados => this.filmes = dados)
  }

}
