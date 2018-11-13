import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Mission } from 'src/app/mission/mission.interface';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class MissionService {

  missionApiUrl = 'http://localhost:8080/api/missions';

  constructor(private http: HttpClient) { }

  getMissions(): Observable<Mission[]> {
    return <Observable<Mission[]>> this.http.get(this.missionApiUrl);
  }

  getMissionById(missionId): Observable<Mission> {
    return <Observable<Mission>> this.http.get(this.missionApiUrl + '/' + missionId);
  }

  addMission(mission) {
    return this.http.post(this.missionApiUrl, mission, httpOptions);
  }
}
