import { Component, Input, OnChanges, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-show-errors-messages',
  templateUrl: './show-errors-messages.component.html',
  styleUrls: ['./show-errors-messages.component.css'],
})
export class ShowErrorsMessagesComponent implements OnChanges {
  @Input() errors: any;

  message = '';
  flag = false;
  constructor() {}

  ngOnChanges(changes: SimpleChanges): void {
    if (!this.errors) {
      this.flag = true;
      return;
    }
    let msg = '';
    for (let err in this.errors) {
      console.log(err);
      switch (err) {
        case 'required':
          msg += 'Campo obligatorio ';
          break;
        case 'email':
          msg += 'El formato no es correcto. ';
          break;
        case 'minlength':
          msg += `Como mínimo debe tener ${this.errors[err].requiredLength} caracteres. `;
          break;
        case 'maxlength':
          msg += `Como máximo debe tener ${this.errors[err].requiredLength} caracteres. `;
          break;
        case 'min':
          msg += `El valor debe ser mayor que ${this.errors[err].min}. `;
          break;
        case 'max':
          msg += `El valor debe ser inferior que ${this.errors[err].max}. `;
          break;
        default:
          msg += 'Error no controlado ';
          break;
      }
    }
    this.message = msg.trim();
    this.flag = this.message == '';
  }
}
