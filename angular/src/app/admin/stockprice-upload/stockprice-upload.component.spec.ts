import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { StockpriceUploadComponent } from './stockprice-upload.component';

describe('StockpriceUploadComponent', () => {
  let component: StockpriceUploadComponent;
  let fixture: ComponentFixture<StockpriceUploadComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ StockpriceUploadComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StockpriceUploadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
