import { Composition } from './composition';
import { Joueur } from './joueur';

export class Partie {
  constructor(
    date?: Date,
    fin?: boolean,
    joueur?: Joueur,
    compoJoueur?: Composition,
    compoIA?: Composition,
    id?: number
  ) {}
}
