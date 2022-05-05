import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageMisHistorietasComponent } from './page-mis-historietas/page-mis-historietas.component';
import { PageMisCosasComponent } from './page-mis-cosas/page-mis-cosas.component';
import { PageMisColegasComponent } from './page-mis-colegas/page-mis-colegas.component';
import { PageEventosComponent } from './page-eventos/page-eventos.component';

const routes: Routes = [
{ path: '', redirectTo: 'mishistorietas', pathMatch: 'full'},
{ path: 'mishistorietas', component: PageMisHistorietasComponent},
{ path: 'miscosas', component: PageMisCosasComponent},
{ path: 'miscolegas', component: PageMisColegasComponent},
{ path: 'eventos', component: PageEventosComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
