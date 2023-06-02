import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { AccueilComponent } from './components/accueil/accueil.component';
import { InscriptionComponent } from './components/inscription/inscription.component';
import { JoueurListePartiesComponent } from './components/partie/joueur-liste-parties/joueur-liste-parties.component';
import { PartieEditComponent } from './components/partie/partie-edit/partie-edit.component';
import { NouvellePartieComponent } from './components/partie/nouvelle-partie/nouvelle-partie.component';
import { CompositionListeComponent } from './components/composition/composition-liste/composition-liste.component';
import { CompositionEditComponent } from './components/composition/composition-edit/composition-edit.component';
import { UnitesListeComponent } from './components/unites/unites-liste/unites-liste.component';
import { UnitesEditComponent } from './components/unites/unites-edit/unites-edit.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'accueil', component: AccueilComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'listeparties', component: JoueurListePartiesComponent },
  { path: 'partie-edit', component: PartieEditComponent },
  { path: 'nouvelle-partie', component: NouvellePartieComponent },
  { path: 'composition-liste', component: CompositionListeComponent },
  { path: 'composition-edit', component: CompositionEditComponent },
  { path: 'unites-liste', component: UnitesListeComponent },
  { path: 'unites-edit', component: UnitesEditComponent },
  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
