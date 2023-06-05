import { Compte } from './compte';

export class Admin extends Compte {
  constructor(login?: string, password?: string) {
    super(login, password);
  }
}
