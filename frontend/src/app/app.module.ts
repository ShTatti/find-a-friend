import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {RegistrationComponent} from './registration/registration.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { LoginComponent } from './login/login.component';
import { AccountComponent } from './account/account.component';
import { CreateAnimalAdvertComponent } from './create-animal-advert/create-animal-advert.component';
import { PlacePickerComponent } from './placepicker/place-picker.component';
import { AnimalAdvertsComponent } from './animaladverts/animal-adverts.component';
import { ViewAnimalAdvertComponent } from './animal-advert/view-animal-advert.component';
import { AnimalAdvertComponent } from './animaladvert/animal-advert.component';
import { HeaderComponent } from './header/header.component';

@NgModule({
  declarations: [
    AppComponent,
    RegistrationComponent,
    LoginComponent,
    AccountComponent,
    CreateAnimalAdvertComponent,
    PlacePickerComponent,
    AnimalAdvertsComponent,
    ViewAnimalAdvertComponent,
    AnimalAdvertComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}