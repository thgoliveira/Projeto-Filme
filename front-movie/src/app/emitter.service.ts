import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class EventEmitterService {

  private emitters: {
    [nomeEvento: string]: EventEmitter<any>
  } = {}

  get (nomeEvento:string): EventEmitter<any> {

      //verifica se ja existe um evento registrado com esse nome
      if (!this.emitters[nomeEvento]) {
          console.log('registrando evento ' + nomeEvento);
          //se não existir, um evento é criado 
          this.emitters[nomeEvento] = new EventEmitter<any>();
      }
      //retornamos o evento
      return this.emitters[nomeEvento];
  }


}
