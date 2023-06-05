import { Partie } from './partie';
import { Unite } from './unite';

export class Composition {
  constructor(
    public unites?: Set<Unite>,
    public parties?: Set<Partie>,
    public budget?: number,
    public id?: number
  ) {}
}
