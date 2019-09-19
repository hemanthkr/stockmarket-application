import { TestBed } from '@angular/core/testing';

import { StockpriceUploadService } from './stockprice-upload.service';

describe('StockpriceUploadService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: StockpriceUploadService = TestBed.get(StockpriceUploadService);
    expect(service).toBeTruthy();
  });
});
