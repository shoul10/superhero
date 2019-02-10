import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Hero } from 'src/app/hero/hero.interface';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

const secureHttpOptions = {headers: new HttpHeaders({Authorization: 'Basic ' + btoa('admin:admin')})};

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  heroApiUrl = 'http://localhost:8080/api/superheroes';

  constructor(private http: HttpClient) { }

  getSuperHeroes(): Observable<Hero[]> {
    return <Observable<Hero[]>> this.http.get(this.heroApiUrl);
  }

  getSuperHeroeById(heroId): Observable<Hero> {
    return <Observable<Hero>> this.http.get(this.heroApiUrl + '/' + heroId);
  }

  addHero(hero) {
    return this.http.post(this.heroApiUrl, hero, httpOptions);
  }
  
  updateHero(heroId, hero) {
    return this.http.put(this.heroApiUrl + '/' + heroId, hero, httpOptions);
  }

  addMissionToHero(missionHero) {
    return this.http.post(this.heroApiUrl + '/add-superhero-to-mission', missionHero, httpOptions);
  }
  
  deleteHero(heroId) {
    return this.http.delete(this.heroApiUrl+ '/' + heroId, secureHttpOptions);
  }

}
