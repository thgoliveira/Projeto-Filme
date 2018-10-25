import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { FilmeComponent } from './filme/filme.component';
import { FilmeDescricaoComponent } from './filme-descricao/filme-descricao.component';

const routes: Routes = [
  {path: '', component: FilmeComponent},
  {path: '', component: FilmeDescricaoComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
