describe("test calculadora", () => {
  describe("calculadora", () => {
    beforeEach(() => {
      this.calc = new Calculator();
    });
    describe("OK", () => {
      it("operaciones", () => {
          expect(this.calc.calculate("10+5")).toEqual(15);
          expect(this.calc.calculate("10-5*4/5")).toEqual(6);
      });
    });

    describe("KO", () => {
      it("operaciones", () => {
          expect(this.calc.calculate("10+5")).not.toEqual(14);
          expect(this.calc.calculate("10/0")).not.toEqual(0);
      });
    });
  });
});
