import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FilmeComponent } from './front/filme/filme.component';
import { FilmeDescricaoComponent } from './front/filme-descricao/filme-descricao.component';
import { HomeComponent } from './sec/home';
import { AuthGuard } from './sec/_guards';
import { LoginComponent } from './sec/login';
import { RegisterComponent } from './sec/register';

const routes: Routes = [
  {path: 'filmes', component: FilmeComponent},
  {path: 'detalhes/:imdbid', component: FilmeDescricaoComponent},
  {path: '', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},

  {path: '**', redirectTo: ''}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
