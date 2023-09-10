import { ComponentFixture, TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';
import { RegisterComponent } from './register.component';

describe('RegisterComponent', () => {
  let component: RegisterComponent;
  let fixture: ComponentFixture<RegisterComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterComponent],
      imports: [
        RouterTestingModule,HttpClientTestingModule,FormsModule,ReactiveFormsModule
      ]
    });
    fixture = TestBed.createComponent(RegisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  //test cases
  it('should have password type of password', () => {
    const element=fixture.debugElement.query(By.css('#pass'));
    expect(element.nativeElement.getAttribute('type')).toEqual('password');
  });
  it('should have username type of email ', () => {
    const element=fixture.debugElement.query(By.css('#id'));
    expect(element.nativeElement.getAttribute('type')).toEqual('email');
  });
  it('should have fullname type of text', () => {
    const element=fixture.debugElement.query(By.css('#fullname'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
  it('should have age type of number', () => {
    const element=fixture.debugElement.query(By.css('#age'));
    expect(element.nativeElement.getAttribute('type')).toEqual('text');
  });
});
