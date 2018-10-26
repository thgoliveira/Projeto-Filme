import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from  '@angular/common/http';

import { AppComponent } from './app.component';
import { FilmeComponent } from './front/filme/filme.component';
import { AppRoutingModule } from './app-routing.module';
import { FilmeDescricaoComponent } from './front/filme-descricao/filme-descricao.component';
import { AlertComponent } from './sec/_directives';
import { HomeComponent } from './sec/home';
import { LoginComponent } from './sec/login';
import { RegisterComponent } from './sec/register';
import { AuthGuard } from './sec/_guards';
import { AlertService, AuthenticationService, UserService } from './sec/_services';
import { JwtInterceptor, ErrorInterceptor, fakeBackendProvider } from './sec/_helpers';


@NgModule({
  declarations: [
    AppComponent,
    FilmeComponent,
    FilmeDescricaoComponent,
    AlertComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [
    AuthGuard,
    AlertService,
    AuthenticationService,
    UserService,
    {provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true},
    fakeBackendProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
