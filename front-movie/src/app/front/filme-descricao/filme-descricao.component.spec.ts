import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FilmeDescricaoComponent } from './filme-descricao.component';

describe('FilmeDescricaoComponent', () => {
  let component: FilmeDescricaoComponent;
  let fixture: ComponentFixture<FilmeDescricaoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FilmeDescricaoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FilmeDescricaoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
