describe("Pruebas de los ejercicios", () => {
  describe("Ejercicio 1", () => {
    describe("OK", () => {
      it("Genera aleatorio", () => {
        let spy = spyOn(Math, "random").and.returnValue(0.496003);
        let num = ejercicio1(1, 100);
        expect(spy).toHaveBeenCalled();
        expect(num).toBeGreaterThanOrEqual(1);
        expect(num).toBeLessThanOrEqual(100);
        expect(num).toBe(50);
      });
    });

    describe("KO", () => {
      it("Falta parámetro", () => {
        expect(() => ejercicio1(1)).toThrow();
        pending("esto es por lo que está pendiente");
      });
    });
  });

  describe("jasmine.arrayContaining", function () {
    let foo;

    beforeEach(function () {
      foo = ejercicio3(3, 1);
    });

    it("matches arrays", function () {
      expect(foo).toEqual(jasmine.arrayContaining([1, 1]));
      expect(foo).not.toEqual(jasmine.arrayContaining([6]));
    });

    describe("spy", function () {
      it("comparing arguments", function () {
        const callback = jasmine.createSpy("callback");
        callback(ejercicio3(4, "6"));
        expect(callback).toHaveBeenCalledWith(
          jasmine.arrayContaining(["6", "6", "6"])
        );
        expect(callback).not.toHaveBeenCalledWith(
          jasmine.arrayContaining([5, 2])
        );
      });
    });
  });

  describe("jasmine.arrayContaining", function () {
     let foo;
 
     beforeEach(function () {
       foo = ejercicio5(6);
     });
 
     it("matches arrays", function () {
       expect(foo).toEqual(jasmine.arrayContaining([2, 3, 5, 7, 11, 13]));
       expect(foo).not.toEqual(jasmine.arrayContaining([6]));
     });
   });



  describe("Ejercicio 6", () => {
    describe("NIF OK", () => {
      ["12345678z", "12345678Z", "23388765L", " 81578601q "].forEach((caso) => {
        it(`NIF: ${caso}`, () => expect(ejercicio6(caso)).toBeTrue());
      });
    });

    describe("NIF KO", () => {
      ["1234J", "12345678", "Z", "Z12345678"].forEach((caso) => {
        it(`NIF: ${caso}`, () => expect(ejercicio6(caso)).toBeFalse());
      });
    });
  });

  describe("Ejercicio 7", () => {
       describe("OK", () => {
          ["A ti no, bonita", "Anita lava la tina", "Luz azul", "reconocer", " Aman a Panamá "].forEach((caso) => {
               it(`Frase: ${caso}`, () => expect(ejercicio7(caso)).toBeTrue());
             });
       })
       describe("KO", () => {
          ["test prueba", "A", " `Z? ", "123461"].forEach((caso) => {
            it(`Frase: ${caso}`, () => expect(ejercicio6(caso)).toBeFalse());
          });
        });
  })
});
