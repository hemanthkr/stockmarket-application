import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HandleIpoComponent } from './handle-ipo.component';

describe('HandleIpoComponent', () => {
  let component: HandleIpoComponent;
  let fixture: ComponentFixture<HandleIpoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HandleIpoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HandleIpoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
