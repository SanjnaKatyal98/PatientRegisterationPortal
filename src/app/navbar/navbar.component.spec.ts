import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';
import { NavbarComponent } from './navbar.component';

describe('NavbarComponent', () => {
  let component: NavbarComponent;
  let fixture: ComponentFixture<NavbarComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [NavbarComponent],
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    });
    fixture = TestBed.createComponent(NavbarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //test cases
  it('testing aboutus navbar',()=>{
    const el = fixture.debugElement.query(By.css('.nav-link'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('#aboutus')).toBeTrue;
  });
  it('testing home navbar',()=>{
    const el = fixture.debugElement.query(By.css('.nav-link'));
    expect(el).toBeTruthy();
    expect(el.nativeElement.getAttribute('#home')).toBeTrue;
  });
});
