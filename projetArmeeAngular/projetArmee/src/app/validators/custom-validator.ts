import { AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';

export class CustomValidator {
  public static pasChaineDefinieParLUtilisateur(chaine: string): ValidatorFn {
    return (control: AbstractControl) => {
      return control.value == chaine ? { chaineInterdite: true } : null;
    };
  }
}
