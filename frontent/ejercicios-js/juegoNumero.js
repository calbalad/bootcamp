class JuegoNumero {
  constructor() {
    this.random = Math.floor(Math.random() * 10) + 1;
    this.cont = 0;
    this.find = false;
    this.result = "Pendiente de empezar";
  }

  jugada(number) {
    if (this.getFinalizado()) {
      return "El juego a finalizado";
    }
    this.cont++;
    if (this.random == number) {
     this.find = true;
      return (this.result = "Bieeen!!! Acertaste.");
    } else if (this.cont >= 10) {
      return (this.result = "Upsss! Se acabaron los intentos, el número era el " + this.random);
    } else if (this.random > number) {
      return (this.result = "Mi número es mayor.");
    } else {
      return (this.result = "Mi número es menor.");
    }
  }

  getResultado() {
    return this.result;
  }

  getFinalizado() {
    return this.find;
  }

  getJugada() {
    return this.cont;
  }
}

let jue = new JuegoNumero();
console.log(jue.random)
jue.jugada(10);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(9);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(8);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(7);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(6);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(5);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(4);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(3);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(2);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
jue.jugada(1);
console.log(jue.getResultado(), jue.getJugada(), jue.getFinalizado());
