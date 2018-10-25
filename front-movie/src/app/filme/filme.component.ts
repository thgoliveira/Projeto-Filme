import { Component, OnInit } from '@angular/core';
import { FilmeService } from '../filme.service';
import { Filme } from './filme.model';
import { Search } from './filme-search.model';
import { EventEmitterService } from '../emitter.service';

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

  constructor(private fs: FilmeService, private emitter: EventEmitterService) { }

  ngOnInit() {
    this.search = new Search();
    this.filme = new Filme();
    this.filmes = new Array();
    this.buscarTodosDoBanco();

    this.emitter.get('evento.buscaFilmes').subscribe(texto => {this.texto = texto
      this.buscarVariosFilmes(this.texto);    
    });
    
    this.emitter.get('evento.selecionaFilme').subscribe(texto => {this.texto = texto
      this.buscarUmFilme(this.texto);
    });
  }

  buscarUmFilme(imdbid: string){
    this.fs.buscarUmFilme(imdbid).subscribe(dados => this.filme = dados);
  }

  buscarVariosFilmes(texto: string){
    this.fs.buscarVariosFilmes(texto).subscribe(dados => this.filmes = dados)
  }

  buscarTodosDoBanco(): void{
    this.fs.buscarTodosDoBanco().subscribe(dados => this.filmes = dados)
  }

}
