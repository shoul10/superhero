import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, } from '@angular/forms';
import { MissionService } from 'src/app/shared/services/mission.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-mission',
  templateUrl: './add-mission.component.html',
  styleUrls: ['./add-mission.component.css']
})
export class AddMissionComponent implements OnInit {

  missionForm: FormGroup;

  constructor(
    private missionService: MissionService,
    private router: Router
  ) { }

  ngOnInit() {
    this.createForm();
  }

  private createForm() {
    this.missionForm = new FormGroup({
      missionName: new FormControl('', Validators.required)
    });
  }

  addMission() {
    this.missionService.addMission(this.missionForm.value).subscribe(() => {
      this.router.navigateByUrl('/missions');
    });
  }

}
