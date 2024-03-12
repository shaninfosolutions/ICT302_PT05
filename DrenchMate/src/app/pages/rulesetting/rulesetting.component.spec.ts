import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RulesettingComponent } from './rulesetting.component';

describe('RulesettingComponent', () => {
  let component: RulesettingComponent;
  let fixture: ComponentFixture<RulesettingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RulesettingComponent]
    });
    fixture = TestBed.createComponent(RulesettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
