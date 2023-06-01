import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  AsyncValidatorFn,
  FormControl,
  FormGroup,
  ValidationErrors,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { Observable, map } from 'rxjs';
import { JoueurService } from 'src/app/services/joueur.service';
import { CustomValidator } from 'src/app/validators/custom-validator';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css'],
})
export class InscriptionComponent implements OnInit {
  form!: FormGroup;

  constructor(private joueurSrv: JoueurService, private router: Router) {}

  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(
        '',
        [
          Validators.required,
          CustomValidator.pasChaineDefinieParLUtilisateur('tutu'),
        ],
        this.loginLibre()
      ),
      passwordGrp: new FormGroup(
        {
          password: new FormControl('', [
            Validators.required,
            Validators.pattern(
              /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%?&])[A-Za-z\d@$!%?&]{4,}$/
            ),
          ]),
          confirmPassword: new FormControl(),
        },
        this.controlsEgaux
      ),
    });
  }

  loginLibre(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.joueurSrv.loginExist(control.value).pipe(
        map((resultat: boolean) => {
          return resultat ? { loginExist: true } : null;
        })
      );
    };
  }

  controlsEgaux(control: AbstractControl): ValidationErrors | null {
    return control.get('password')?.value ==
      control.get('confirmPassword')?.value
      ? null
      : { pasEgaux: true };
  }

  submit() {
    let joueur = {
      login: this.form.get('login')?.value,
      password: this.form.get('passwordGrp.password')?.value,
    };
    this.joueurSrv.inscription(joueur).subscribe((joueur) => {
      console.debug(joueur);
      this.router.navigateByUrl('/login');
    });
  }
}
