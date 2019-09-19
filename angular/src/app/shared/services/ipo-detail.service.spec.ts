import { TestBed } from '@angular/core/testing';

import { IpoDetailService } from './ipo-detail.service';

describe('IpoDetailService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: IpoDetailService = TestBed.get(IpoDetailService);
    expect(service).toBeTruthy();
  });
});
