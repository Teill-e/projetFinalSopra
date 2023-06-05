import { Pays } from './pays';
import { Unite } from './unite';
export class Armee {
  constructor(
    public type?: string,
    public pv?: number,
    public moral?: number,
    public pays?: Pays,
    public listeUnites?: Set<Unite>,
    public id?: number
  ) {}
}
