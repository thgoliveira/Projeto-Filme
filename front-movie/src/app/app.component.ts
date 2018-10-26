import { Component, Input } from '@angular/core';
import { EventEmitterService } from './emitter.service';

import { User } from '../app/sec/_models';
import { UserService } from '../app/sec/_services';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html', 
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  texto: string;
  currentUser: User;
  users: User[] = [];  
  
  constructor(private emitter: EventEmitterService, private userService: UserService){
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  pesquisar(): void{
    this.emitter.get('evento.buscaFilmes').emit(this.texto);
  }

  selecionaFilme(texto: string) {
    this.emitter.get('evento.selecionaFilme').emit(this.texto);
  }
}


