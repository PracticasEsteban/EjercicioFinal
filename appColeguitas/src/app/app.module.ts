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
import { UserInfoComponent } from './componentes/user-info/user-info.component';

import { PostHistorietaComponent } from './componentes/post-historieta/post-historieta.component';
import { ListHistorietasComponent } from './componentes/list-historietas/list-historietas.component';
import { BrowserAnimationsModule, NoopAnimationsModule } from '@angular/platform-browser/animations';

import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { UserDescriptionComponent } from './componentes/user-description/user-description.component';
import { ListFriendsComponent } from './componentes/list-friends/list-friends.component';
import { SearchFriendComponent } from './componentes/search-friend/search-friend.component';
import { ListPersonsComponent } from './componentes/list-persons/list-persons.component';
import { FriendInfoComponent } from './componentes/friend-info/friend-info.component';



@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    FooterComponent,
    PageMisHistorietasComponent,
    PageMisCosasComponent,
    PageMisColegasComponent,
    PageEventosComponent,
    UserInfoComponent,
    PostHistorietaComponent,
      ListHistorietasComponent,
      UserDescriptionComponent,
      ListFriendsComponent,
      SearchFriendComponent,
      ListPersonsComponent,
      FriendInfoComponent,
     
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    SweetAlert2Module
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
