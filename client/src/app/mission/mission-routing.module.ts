import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MissionsComponent } from './missions/missions.component';
import { MissionsDetailComponent } from './missions-detail/missions-detail.component';
import { AddMissionComponent } from './add-mission/add-mission.component';

const missionRoutes: Routes = [
  {
    path: 'add/mission',
    component: AddMissionComponent
  },
  {
    path: '',
    component: MissionsComponent
  },
  {
    path: ':missionId',
    component: MissionsDetailComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(missionRoutes)
  ],
  exports: [
    RouterModule
  ]
})

export class MissionRoutingModule {
}
