import { TypeA } from './type-a';
import { Unite } from './unite';

export class Arme {
  constructor(
    public typeA?: TypeA,
    public uniteArmes?: Set<Unite>,
    public id?: number
  ) {}
}
