import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


const routes: Routes = [
  {
    path: 'missions',
    loadChildren: './mission/mission.module#MissionModule'
  },
  {
    path: 'heros',
    loadChildren: './hero/hero.module#HeroModule'
  },
  {
    path: '',
    redirectTo: 'heros',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})

export class AppRoutingModule {
}
