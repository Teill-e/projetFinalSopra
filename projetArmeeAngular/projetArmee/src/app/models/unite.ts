import { Arme } from './arme';
import { Armee } from './armee';
import { Composition } from './composition';

export class Unite {
  constructor(
    armes?: Set<Arme>,
    prix?: number,
    armee?: Armee,
    composition?: Composition,
    id?: number
  ) {}
}
