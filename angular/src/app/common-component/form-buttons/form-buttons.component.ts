import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-form-buttons',
  templateUrl: './form-buttons.component.html',
  styleUrls: ['./form-buttons.component.css'],
})
export class FormButtonsComponent implements OnInit {
  @Input('send-disabled') sendDisabled: boolean | null = false;
  @Input('send-text') sendText: string = 'Enviar';
  @Input('cancel-text') cancelText: string = 'Volver';
  @Input('delete-text') deleteText: string = 'Borrar';
  @Output() send: EventEmitter<any> = new EventEmitter<any>();
  @Output() cancel: EventEmitter<any> = new EventEmitter<any>();
  @Output() delete: EventEmitter<any> = new EventEmitter<any>();
  constructor() {}

  ngOnInit(): void {}

  get hasSend(): boolean {
    return this.send.observed;
  }
  get hasCancel(): boolean {
    return this.cancel.observed;
  }
  get hasDelete(): boolean {
    return this.delete.observed;
  }
}
