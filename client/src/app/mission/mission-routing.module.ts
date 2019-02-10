import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MissionsComponent } from './missions/missions.component';
import { MissionsDetailComponent } from './missions-detail/missions-detail.component';
import { AddMissionComponent } from './add-mission/add-mission.component';
import { EditMissionComponent } from './edit-mission/edit-mission.component';

const missionRoutes: Routes = [
  {
    path: 'add',
    component: AddMissionComponent
  },
  {
    path: 'edit/:missionId',
    component: EditMissionComponent
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
