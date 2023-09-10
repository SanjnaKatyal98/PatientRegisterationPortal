import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';
import { RenewalPageComponent } from './renewal-page.component';

describe('RenewalPageComponent', () => {
  let component: RenewalPageComponent;
  let fixture: ComponentFixture<RenewalPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RenewalPageComponent],
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    });
    fixture = TestBed.createComponent(RenewalPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
