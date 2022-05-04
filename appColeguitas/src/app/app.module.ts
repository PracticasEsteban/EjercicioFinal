import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { PageMisHistorietasComponent } from './page-mis-historietas/page-mis-historietas.component';
import { PageMisCosasComponent } from './page-mis-cosas/page-mis-cosas.component';
import { PageMisColegasComponent } from './page-mis-colegas/page-mis-colegas.component';
import { PageEventosComponent } from './page-eventos/page-eventos.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    FooterComponent,
    PageMisHistorietasComponent,
    PageMisCosasComponent,
    PageMisColegasComponent,
    PageEventosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
