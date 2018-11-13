import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HerosDetailComponent } from './heros-detail.component';

describe('HerosDetailComponent', () => {
  let component: HerosDetailComponent;
  let fixture: ComponentFixture<HerosDetailComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HerosDetailComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HerosDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
