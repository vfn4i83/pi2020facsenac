import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PessoaComponent } from './componentes/pessoa/pessoa.component';
import { LaboratorioComponent } from './componentes/laboratorio/laboratorio.component';
import { HistoricoComponent } from './componentes/historico/historico.component';
import { OrdemservicoComponent } from './componentes/ordemservico/ordemservico.component';
import { TipoServicoComponent } from './componentes/tiposervico/tiposervico.component';

const routes: Routes = [
  { path: '', component: Component },
  { path: 'home', component: Component },
  { path: 'pessoa', component: PessoaComponent},
  { path: 'laboratorio', component: LaboratorioComponent},
  { path: 'tiposervico', component: TipoServicoComponent},
  { path: 'ordemservico', component: OrdemservicoComponent},
  { path: 'historico', component: HistoricoComponent}
]

export const RoutingModule = RouterModule.forRoot(routes);

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
