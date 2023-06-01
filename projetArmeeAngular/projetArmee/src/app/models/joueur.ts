import { Compte } from './compte';
import { Partie } from './partie';

export class Joueur extends Compte {
  constructor(login?: string, password?: string, listeParties?: Set<Partie>) {
    super(login, password);
  }
}
