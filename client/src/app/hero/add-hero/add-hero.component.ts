import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, } from '@angular/forms';
import { Router } from '@angular/router';
import { HeroService } from 'src/app/shared/services/hero.service';

@Component({
  selector: 'app-add-hero',
  templateUrl: './add-hero.component.html',
  styleUrls: ['./add-hero.component.css']
})
export class AddHeroComponent implements OnInit {

  heroForm: FormGroup;

  constructor(
    private router: Router,
    private heroService: HeroService
  ) { }

  ngOnInit() {
    this.createForm();
  }

  private createForm() {
    this.heroForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),
      superheroName: new FormControl('', Validators.required)
    });
  }

  addHero() {
    const newHero = {
      firstName: this.heroForm.value.firstName,
      lastName: this.heroForm.value.lastName,
      superheroName: this.heroForm.value.superheroName
    };

    this.heroService.addHero(newHero).subscribe(() => {
      this.router.navigateByUrl('/heros');
    });
  }

}
