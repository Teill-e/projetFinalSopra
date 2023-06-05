import { Composition } from './composition';
import { Joueur } from './joueur';

export class Partie {
  constructor(
    public date?: Date,
    public fin?: boolean,
    public joueur?: Joueur,
    public compoJoueur?: Composition,
    public compoIA?: Composition,
    public id?: number
  ) {}
}
