import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { CaregiverService } from './caregiver.service';

describe('CaregiverService', () => {
  let service: CaregiverService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    });
    service = TestBed.inject(CaregiverService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
