import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmeService } from '../../filme.service';
import { Filme } from '../filme/filme.model';
import { Location } from '@angular/common';

@Component({
  selector: 'app-filme-descricao',
  templateUrl: './filme-descricao.component.html',
  styleUrls: ['./filme-descricao.component.css']
})
export class FilmeDescricaoComponent implements OnInit {

  filme: Filme;

  constructor(
    private route: ActivatedRoute,
    private fs: FilmeService,
    private location: Location
  ) { }

  ngOnInit(): void{
    this.getFilme();
  }

  getFilme(): void{
    const imdbid = this.route.snapshot.paramMap.get('imdbid');
    this.fs.buscarUmFilme(imdbid).subscribe(filme => this.filme = filme);
  }

  voltar(): void{
    this.location.back();
  }

}
