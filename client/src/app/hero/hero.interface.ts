import { Mission } from "../mission/mission.interface";

export interface Hero {
  id: number;
  firstName: string;
  lastName: string;
  superheroName: string;
  missions: Mission[];
}
