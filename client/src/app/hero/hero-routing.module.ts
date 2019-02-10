import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HerosComponent } from './heros/heros.component';
import { HerosDetailComponent } from './heros-detail/heros-detail.component';
import { AddHeroComponent } from './add-hero/add-hero.component';
import { EditHeroComponent } from './edit-hero/edit-hero.component';

const heroRoutes: Routes = [
  {
    path: 'add',
    component: AddHeroComponent
  },
  {
    path: 'edit/:heroId',
    component: EditHeroComponent
  },
  {
    path: '',
    component: HerosComponent
  },
  {
    path: ':heroId',
    component: HerosDetailComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(heroRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class HeroRoutingModule {
}
