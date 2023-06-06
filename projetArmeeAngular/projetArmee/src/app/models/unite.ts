import { Arme } from './arme';
import { Armee } from './armee';
import { Composition } from './composition';

export class Unite {
  constructor(
    public armes?: Array<Arme>,
    public prix?: number,
    public armee?: Armee,
    public composition?: Composition,
    public id?: number
  ) {}
}
