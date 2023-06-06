import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AuthenticationInterceptor } from './interceptors/authentication.interceptor';
import { MenuComponent } from './components/menu/menu.component';
import { HomeComponent } from './components/home/home.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { LoginComponent } from './components/login/login.component';
import { PartieEditComponent } from './components/partie/partie-edit/partie-edit.component';
import { JoueurListePartiesComponent } from './components/partie/joueur-liste-parties/joueur-liste-parties.component';
import { NouvellePartieComponent } from './components/partie/nouvelle-partie/nouvelle-partie.component';
import { CompositionListeComponent } from './components/composition/composition-liste/composition-liste.component';
import { CompositionEditComponent } from './components/composition/composition-edit/composition-edit.component';
import { NvpartiComponent } from './components/nvparti/nvparti.component';
import { NouvelleCompositionComponent } from './components/composition/nouvelle-composition/nouvelle-composition.component';
import { UnitelisteComponent } from './components/unites/uniteliste/uniteliste.component';
import { UniteEditComponent } from './components/unites/unite-edit/unite-edit.component';
import { MenuAdminComponent } from './components/menu-admin/menu-admin.component';
import { CreationArmeesComponent } from './components/creation/creation-armees/creation-armees.component';
import { CreationArmesComponent } from './components/creation/creation-armes/creation-armes.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    HomeComponent,
    AccueilComponent,
    InscriptionComponent,
    LoginComponent,
    PartieEditComponent,
    JoueurListePartiesComponent,
    NouvellePartieComponent,
    CompositionListeComponent,
    CompositionEditComponent,
    NvpartiComponent,
    NouvelleCompositionComponent,
    UnitelisteComponent,
    UniteEditComponent,
    MenuAdminComponent,
    CreationArmeesComponent,
    CreationArmesComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthenticationInterceptor,
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
