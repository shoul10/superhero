import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MissionRoutingModule } from './mission-routing.module';

import { MissionsComponent } from './missions/missions.component';
import { MissionsDetailComponent } from './missions-detail/missions-detail.component';
import { AddMissionComponent } from './add-mission/add-mission.component';
import { EditMissionComponent } from './edit-mission/edit-mission.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MissionRoutingModule
  ],
  declarations: [MissionsComponent, MissionsDetailComponent, AddMissionComponent, EditMissionComponent]
})
export class MissionModule { }
