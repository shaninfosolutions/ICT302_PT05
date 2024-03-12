import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NotisettingComponent } from './notisetting.component';

describe('NotisettingComponent', () => {
  let component: NotisettingComponent;
  let fixture: ComponentFixture<NotisettingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NotisettingComponent]
    });
    fixture = TestBed.createComponent(NotisettingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
