import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FormularioVMService {
  private elemento: any = {}
  private modo: 'add' | 'edit' = 'add'

  constructor(private http: HttpClient) { }

  get Elemento(): any { return this.elemento; }

  add() {
    this.elemento = {}
    this.modo = 'add'
  }

  edit(id: any) {
    /* this.elemento = { id: id, nombre: 'Pepito', apellidos: 'Grillo', email: 'pepito@grillo', nif: '12345678z', edad: 99 }
    this.modo = 'edit' */
    this.http.get<Array<any>>(`http://localhost:4321/api/personas/${id}`).subscribe({
      next: data => {
        this.elemento = data
        this.modo  = 'edit'
      },
      error: err => console.log(err)
    })
  }

  cancel() {

  }

  send() {
    if(this.modo=== 'add'){
      this.http.post(`http://localhost:4321/api/personas`, this.elemento).subscribe({
        next: data => {
          alert('OK')
        },
        error: err => console.log(err)
      })
    }else{
      this.http.put(`http://localhost:4321/api/personas/${this.elemento.id}`, this.elemento).subscribe({
        next: data => {
          alert('OK')
        },
        error: err => console.log(err)
      })
    }
    alert( (this.modo === 'add' ? 'POST ' : 'PUT ') + JSON.stringify(this.elemento))
  }
}
