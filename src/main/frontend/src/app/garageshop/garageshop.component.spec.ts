import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GarageshopComponent } from './garageshop.component';

describe('GarageshopComponent', () => {
  let component: GarageshopComponent;
  let fixture: ComponentFixture<GarageshopComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GarageshopComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GarageshopComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
