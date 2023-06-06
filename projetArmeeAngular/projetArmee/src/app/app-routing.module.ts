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
import { NvpartiComponent } from './components/nvparti/nvparti.component';
import { NouvelleCompositionComponent } from './components/composition/nouvelle-composition/nouvelle-composition.component';
import { UniteEditComponent } from './components/unites/unite-edit/unite-edit.component';
import { UnitelisteComponent } from './components/unites/uniteliste/uniteliste.component';
import { MenuAdminComponent } from './components/menu-admin/menu-admin.component';
import { CreationArmeesComponent } from './components/creation/creation-armees/creation-armees.component';
import { CreationArmesComponent } from './components/creation/creation-armes/creation-armes.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent },
  { path: 'accueil', component: AccueilComponent },
  { path: 'inscription', component: InscriptionComponent },
  { path: 'listeparties', component: JoueurListePartiesComponent },
  { path: 'partie-edit', component: PartieEditComponent },
  { path: 'nouvelle-partie', component: NouvellePartieComponent },
  { path: 'composition-liste/:id', component: CompositionListeComponent },
  { path: 'composition-liste', component: CompositionListeComponent },
  { path: 'composition-edit', component: CompositionEditComponent },
  { path: 'nouvelle-composition', component: NouvelleCompositionComponent },
  { path: 'nouvelle-composition/:id', component: NouvelleCompositionComponent },
  { path: 'unites-edite/:id', component: UniteEditComponent },
  { path: 'menu-admin', component: MenuAdminComponent },
  { path: 'unites-edite', component: UniteEditComponent },
  { path: 'uniteliste', component: UnitelisteComponent },
  { path: 'creation-armes', component: CreationArmesComponent },
  { path: 'creation-armees', component: CreationArmeesComponent },
  { path: 'nvparti-list', component: NvpartiComponent },

  { path: '', redirectTo: 'accueil', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
