import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroRoutingModule } from './hero-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { TypeaheadModule } from 'ngx-bootstrap/typeahead';

import { HerosComponent } from './heros/heros.component';
import { HerosDetailComponent } from './heros-detail/heros-detail.component';
import { AddHeroComponent } from './add-hero/add-hero.component';
import { EditHeroComponent } from './edit-hero/edit-hero.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    TypeaheadModule,
    HeroRoutingModule
  ],
  declarations: [HerosComponent, HerosDetailComponent, AddHeroComponent, EditHeroComponent]
})
export class HeroModule { }
