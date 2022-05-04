import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageEventosComponent } from './page-eventos.component';

describe('PageEventosComponent', () => {
  let component: PageEventosComponent;
  let fixture: ComponentFixture<PageEventosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageEventosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageEventosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
