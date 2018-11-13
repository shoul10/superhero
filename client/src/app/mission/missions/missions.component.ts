import { Component, OnInit } from '@angular/core';
import { MissionService } from 'src/app/shared/services/mission.service';
import { Mission } from '../mission.interface';
import { Router } from '@angular/router';

@Component({
  selector: 'app-missions',
  templateUrl: './missions.component.html',
  styleUrls: ['./missions.component.css']
})
export class MissionsComponent implements OnInit {

  missions: Mission[];

  constructor(
    private missionService: MissionService,
    private router: Router
  ) { }

  ngOnInit() {
    this.missionService.getMissions().subscribe(missions => {
      this.missions = missions;
    });
  }

  addMission() {
    this.router.navigateByUrl('/missions/add/mission');
  }

}
