import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {ListPersonComponent} from './components/list-person/list-person.component';
import {AddPersonComponent } from './components/add-person/add-person.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { LeftmenuComponent } from './components/leftmenu/leftmenu.component';
import { PageSearchComponent } from './components/page-search/page-search.component';
import { EditPersonComponent } from './components/edit-person/edit-person.component';



@NgModule({
  declarations: [
    AppComponent,
    ListPersonComponent,
    AddPersonComponent,
    HeaderComponent,
    FooterComponent,
    LeftmenuComponent,
    PageSearchComponent,
    EditPersonComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
