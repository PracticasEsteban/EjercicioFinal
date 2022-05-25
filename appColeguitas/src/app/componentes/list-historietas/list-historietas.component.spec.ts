import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListHistorietasComponent } from './list-historietas.component';

describe('ListHistorietasComponent', () => {
  let component: ListHistorietasComponent;
  let fixture: ComponentFixture<ListHistorietasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListHistorietasComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListHistorietasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
