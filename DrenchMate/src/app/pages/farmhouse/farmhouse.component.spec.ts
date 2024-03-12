import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FarmhouseComponent } from './farmhouse.component';

describe('FarmhouseComponent', () => {
  let component: FarmhouseComponent;
  let fixture: ComponentFixture<FarmhouseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FarmhouseComponent]
    });
    fixture = TestBed.createComponent(FarmhouseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
