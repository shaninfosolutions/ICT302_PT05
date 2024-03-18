import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RulecodeComponent } from './rulecode.component';

describe('RulecodeComponent', () => {
  let component: RulecodeComponent;
  let fixture: ComponentFixture<RulecodeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RulecodeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RulecodeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
