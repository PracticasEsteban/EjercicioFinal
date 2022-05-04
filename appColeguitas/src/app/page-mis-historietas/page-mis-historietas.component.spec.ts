import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PageMisHistorietasComponent } from './page-mis-historietas.component';

describe('PageMisHistorietasComponent', () => {
  let component: PageMisHistorietasComponent;
  let fixture: ComponentFixture<PageMisHistorietasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PageMisHistorietasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PageMisHistorietasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
