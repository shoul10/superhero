import { MissionModule } from './mission.module';

describe('MissionModule', () => {
  let missionModule: MissionModule;

  beforeEach(() => {
    missionModule = new MissionModule();
  });

  it('should create an instance', () => {
    expect(missionModule).toBeTruthy();
  });
});
