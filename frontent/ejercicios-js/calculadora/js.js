class Calculator {
  constructor() {
    this.result = 0;
  }

  calculate(input) {
    var f = {
      add: "+",
      sub: "-",
      div: "/",
      mlt: "*",
    };

    f.ooo = [
      [[f.mlt], [f.div]],
      [[f.add], [f.sub]],
    ];

    input = input.replace(/[^0-9%^*\/()\-+.]/g, "");

    var output;
    for (var i = 0, n = f.ooo.length; i < n; i++) {
      var re = new RegExp(
        "(\\d+\\.?\\d*)([\\" + f.ooo[i].join("\\") + "])(\\d+\\.?\\d*)"
      );
      re.lastIndex = 0;

      while (re.test(input)) {
        output = _calculate(RegExp.$1, RegExp.$2, RegExp.$3);
        if (isNaN(output) || !isFinite(output)) return output;
        input = input.replace(re, output);
      }
    }

    return output;

    function _calculate(a, op, b) {
      a = a * 1;
      b = b * 1;
      switch (op) {
        case f.add:
          return a + b;
        case f.sub:
          return a - b;
        case f.div:
          return a / b;
        case f.mlt:
          return a * b;
        default:
          null;
      }
    }
  }
}

let display = document.getElementById("display");
let buttons = Array.from(document.getElementsByTagName("button"));
let calc = new Calculator();
buttons.map((button) => {
  button.addEventListener("click", (e) => {
    switch (e.target.innerText) {
      case "C":
        display.innerText = "";
        break;
      case "=":
        try {
          display.innerText =
            /* typeof evil(display.innerText) == "undefined"
              ? "Seleccione un numero"
              : eval(display.innerText); */
            calc.calculate(display.innerText);
        } catch {
          display.innerText = "Error";
        }
        break;
      case "←":
        if (display.innerText) {
          display.innerText = display.innerText.slice(0, -1);
        }
        break;
      default:
        display.innerText += e.target.innerText;
    }
  });
});
