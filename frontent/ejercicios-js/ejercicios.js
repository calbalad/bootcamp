function ejercicio1(min, max) {
  return Math.floor(Math.random() * (max - min)) + min;
}

function ejercicio2() {
  const random = ejercicio1(0, 100);
  let cont = 0;

  do {
    number = parseInt(
      prompt(
        "Introduce el numero del 1 al 100: " + random + " Intetos: " + cont
      )
    );
    cont++;
  } while (number !== random && cont != 10) 

  if (number == random) {
    alert("El numero es correcto.");
  } else {
    alert("Perdiste.");
  }
}

function ejercicio3(length, value) {
  if (Number.isInteger(parseInt(length))) {
    return Array(parseInt(length)).fill(value);
  } else {
    return "La longitud no es un int";
  }
}

function ejercicio5(limit) {
  if (Number.isInteger(limit)) {
    let numbersList = [];
    let cont = 1;
    do {
      if (esPrimo(cont)) numbersList.push(cont);
      cont++;
      console.log(cont);
    } while (numbersList.length != limit);
    return numbersList;
  } else {
    return "La longitud no es un int";
  }
}

function esPrimo(numero) {
  for (let i = 2, raiz = Math.sqrt(numero); i <= raiz; i++)
    if (numero % i === 0) return false;
  return numero > 1;
}

function ejercicio6(dni) {
  var numero, let, letra;
  var expresion_regular_dni = /^[XYZ]?\d{5,8}[A-Z]$/;

  dni = dni.toUpperCase();

  if (expresion_regular_dni.test(dni) === true) {
    numero = dni.substr(0, dni.length - 1);
    numero = numero.replace("X", 0);
    numero = numero.replace("Y", 1);
    numero = numero.replace("Z", 2);
    let = dni.substr(dni.length - 1, 1);
    numero = numero % 23;
    letra = "TRWAGMYFPDXBNJZSQVHLCKET";
    letra = letra.substring(numero, numero + 1);
    if (letra != let) {
      alert("Dni erroneo, la letra del NIF no se corresponde");
    } else {
      alert("Dni correcto");
    }
  } else {
    alert("Dni erroneo, formato no válido");
  }
}

function ejercicio7(str) {
  var re = /[\W_]/g;
  var lowStr = str.toLowerCase().replace(re, "");
  var reverseStr = lowStr.split("").reverse().join("");
  return reverseStr === lowStr;
}

function JuegoNumero(adivina, intentos) {
  this.random = adivina;
  let cont = 1;
  do {
    number = parseInt(
      prompt(
        "Introduce el numero del 1 al 100: " + random + " Intetos: " + cont
      )
    );
    cont++;
  } while (number !== random && cont != 10) 

  if (number == random) {
    alert("El numero es correcto.");
  } else {
    alert("Perdiste.");
  }
}


//console.log(ejercicio1(0, 10));

// ejercicio2();

//console.log(ejercicio3("3", 2));

// console.log(ejercicio5(20));

// ejercicio6("98461641K")

console.log(ejercicio7("La ruta nos aporto otro paso natural"));
