import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IpoReviseComponent } from './ipo-revise.component';

describe('IpoReviseComponent', () => {
  let component: IpoReviseComponent;
  let fixture: ComponentFixture<IpoReviseComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IpoReviseComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IpoReviseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
