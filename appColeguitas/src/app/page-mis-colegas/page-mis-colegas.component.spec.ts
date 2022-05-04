import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageMisColegasComponent } from './page-mis-colegas.component';

describe('PageMisColegasComponent', () => {
  let component: PageMisColegasComponent;
  let fixture: ComponentFixture<PageMisColegasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageMisColegasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageMisColegasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
