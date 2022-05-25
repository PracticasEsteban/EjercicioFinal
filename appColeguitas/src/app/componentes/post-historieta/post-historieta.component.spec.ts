import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PostHistorietaComponent } from './post-historieta.component';

describe('PostHistorietaComponent', () => {
  let component: PostHistorietaComponent;
  let fixture: ComponentFixture<PostHistorietaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PostHistorietaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PostHistorietaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
