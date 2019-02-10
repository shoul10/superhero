import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { HeroService } from './services/hero.service';
import { MissionService } from './services/mission.service';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  declarations: [],
  providers: [
    HeroService,
    MissionService
  ]
})
export class SharedModule { }
