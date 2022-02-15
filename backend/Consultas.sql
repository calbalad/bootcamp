-- Obtener todos los actores de nombre ‘NICK’.
SELECT * 
FROM actor 
where first_name = 'NICK';

-- Obtener una lista con todos los distritos distintos (district en address).
SELECT DISTINCT district 
FROM address;

-- Obtener las películas sobre agentes secretos (description contiene ‘Secret Agent’).
SELECT * 
FROM film 
where description like '%Secret Agent%';

-- Mostrar la lista de las películas mas caras (coste por minuto)
SELECT title, (rental_rate / LENGTH) `Coste por minuto` 
FROM film 
ORDER BY `Coste por minuto` DESC;

-- Obtener los códigos y medias de gasto de los clientes que han gastado mas de 100 en menos de 25 operaciones.
select customer_id, sum(amount)
from (select customer_id, amount, row_number() over (partition by customer_id order by last_update) rn
      from payment) t
where rn < 24
group by customer_id
HAVING sum(amount) > 100

-- Obtener los 5 nombres de actor más repetidos (aprox).
SELECT first_name, COUNT(*) `Nº veces` FROM actor GROUP BY first_name ORDER BY `Nº veces` DESC LIMIT 5;

-- Para felicitar el año nuevo chino se necesita el listado con los datos postales de los clientes residentes en China y Taiwan
SELECT * FROM customer 
INNER JOIN address ON customer.address_id = address.address_id
INNER JOIN city ON city.city_id = address.city_id
INNER JOIN country ON country.country_id = city.country_id
WHERE country = 'China' OR country = 'Taiwan'

-- Mostrar los datos de las tiendas, conocidas por la ciudad y país donde están ubicadas, indicando el nombre del gerente, el numero de películas en inventario, el numero de títulos diferentes y el número de clientes atendidos.
SELECT *, manager.first_name,  manager.last_name, city.city, country.country, address.address, COUNT(inventory.film_id)
FROM store
INNER JOIN inventory ON store.store_id = inventory.store_id
INNER JOIN address ON store.address_id = address.address_id
INNER JOIN city ON city.city_id = address.city_id
INNER JOIN country ON country.country_id = city.country_id,
(SELECT staff_id, first_name, last_name
        FROM staff) AS manager
WHERE manager.staff_id = store.manager_staff_id

-- Obtener el listado detallado de alquileres indicando el identificador de alquiler, el titulo alquilado, las fechas de alquiler, devolución y tiempo transcurrido, nombres del cliente (nombre con apellidos), empleado (nombre con apellidos) y tienda (ciudad, país).
--  Generar la lista diaria de alquileres vencidos no devueltos para poder llamar a los clientes y pedirles que los devuelvan, para ello debe mostrar las fechas de alquiler y vencimiento, el teléfono y nombre del cliente, así como el titulo de la película, priorizando los que mas tiempo llevan vencidos.
-- Elaborar el ranking de los países que más alquilan las películas de GINA DEGENERES.

