import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageMisCosasComponent } from './page-mis-cosas.component';

describe('PageMisCosasComponent', () => {
  let component: PageMisCosasComponent;
  let fixture: ComponentFixture<PageMisCosasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageMisCosasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageMisCosasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
