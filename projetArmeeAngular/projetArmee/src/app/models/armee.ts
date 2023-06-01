import { Pays } from './pays';
import { Unite } from './unite';
export class Armee {
  constructor(
    pv?: number,
    moral?: number,
    pays?: Pays,
    listeUnites?: Set<Unite>,
    id?: number
  ) {}
}
