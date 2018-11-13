import { AppBootstrapModule } from './app-bootstrap.module';

describe('AppBootstrapModule', () => {
  let appBootstrapModule: AppBootstrapModule;

  beforeEach(() => {
    appBootstrapModule = new AppBootstrapModule();
  });

  it('should create an instance', () => {
    expect(appBootstrapModule).toBeTruthy();
  });
});
