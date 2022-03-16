document.addEventListener("DOMContentLoaded", function () {
     const pantalla = document.getElementById('pantalla');
     const botones = document.querySelectorAll('.botones button');
     const botonesArray = Array.from(botones);

     botonesArray.map(boton => boton.addEventListener('click', function () {
          if (boton.innerText !== "="){
               pantalla.innerText += boton.innerText;
          }     
          if (boton.innerText === "x") {
               pantalla.innerText = eval(pantalla.innerHTML);
          }     
          if (boton.innerText === "C"){
               pantalla.innerText = "";
          }
     }))
})