import { Component } from '@angular/core';
import { EventEmitterService } from './emitter.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  texto: string;
  
  constructor(private emitter: EventEmitterService){}

  pesquisar(): void{
    this.emitter.get('evento.buscaFilmes').emit(this.texto);
  }

  selecionaFilme() {
    this.emitter.get('selecionaFilme').emit(this.texto);
  }
}


