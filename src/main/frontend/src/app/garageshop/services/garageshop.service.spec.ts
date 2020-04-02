import { TestBed } from '@angular/core/testing';

import { GarageshopService } from './garageshop.service';

describe('GarageshopService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GarageshopService = TestBed.get(GarageshopService);
    expect(service).toBeTruthy();
  });
});
