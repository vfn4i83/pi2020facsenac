import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { PessoaComponent } from './componentes/pessoa/pessoa.component';
import { LaboratorioComponent } from './componentes/laboratorio/laboratorio.component';
import { HistoricoComponent } from './componentes/historico/historico.component';
import { OrdemservicoComponent } from './componentes/ordemservico/ordemservico.component';
import { TipoServicoComponent } from './componentes/tiposervico/tiposervico.component';
import { HistoricoService } from './services/historico.service';
import { OrdemServicoService } from './services/ordemservico.service';
import { PessoaService } from './services/pessoa.service';
import { LaboratorioService } from './services/laboratorio.service';
import { TipoServicoService } from './services/tiposervico.service';

@NgModule({
  declarations: [
    AppComponent,
    PessoaComponent,
    LaboratorioComponent,
    HistoricoComponent,
    OrdemservicoComponent,
    TipoServicoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule
  ],
  providers: [TipoServicoService, 
    LaboratorioService, 
    PessoaService, 
    OrdemServicoService, 
    HistoricoService],
  bootstrap: [AppComponent]
})

export class AppModule { }
