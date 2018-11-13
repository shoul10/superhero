import { HeroModule } from './hero.module';

describe('HeroModule', () => {
  let heroModule: HeroModule;

  beforeEach(() => {
    heroModule = new HeroModule();
  });

  it('should create an instance', () => {
    expect(heroModule).toBeTruthy();
  });
});
