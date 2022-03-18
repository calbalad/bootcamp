describe("Pruebas juego adivina numero", () => {
  describe("JuegoNumero", () => {
    beforeEach(() => {
      this.juego = new JuegoNumero();
    });

    describe("init", () => {
      it("numero", () => {
        for (let i = 1; i < 15; i++) {
          console.error(i, this.juego.random);
          if (this.juego.getFinalizado()) {
            expect(this.juego.jugada(i)).toEqual("El juego a finalizado");
          } else if (i == this.juego.random) {
            expect(this.juego.jugada(i)).toEqual("Bieeen!!! Acertaste.");
          } else if (i > 10) {
            expect(this.juego.jugada(i)).toEqual(
              "Upsss! Se acabaron los intentos, el número era el " +
                this.juego.random
            );
          } else if (i > this.juego.random) {
            expect(this.juego.jugada(i)).toEqual("Mi número es menor.");
          } else if (i < this.juego.random) {
            expect(this.juego.jugada(i)).toEqual("Mi número es mayor.");
          }
        }
      });
    });
  });
});
