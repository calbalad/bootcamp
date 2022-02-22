-- Obtener todos los actores de nombre ‘NICK’.
SELECT * 
FROM actor 
where first_name = 'NICK';

-- Obtener una lista con todos los distritos distintos (district en address).
SELECT DISTINCT district 
FROM address ORDER BY district;

-- Obtener las películas sobre agentes secretos (description contiene ‘Secret Agent’).
SELECT * 
FROM film 
WHERE description like '%Secret Agent%';

-- Mostrar la lista de las películas mas caras (coste por minuto)
SELECT title,rental_rate, LENGTH, (rental_rate / LENGTH) `Coste por minuto` 
FROM film 
ORDER BY `Coste por minuto` DESC;

-- Obtener los códigos y medias de gasto de los clientes que han gastado mas de 100 en menos de 25 operaciones.
SELECT customer_id, AVG(amount), sum(amount) `Suma`
FROM (SELECT customer_id, amount, row_number() over (PARTITION BY customer_id ORDER BY last_update) rn
      FROM payment) t
WHERE rn < 25
GROUP BY customer_id
HAVING SUM(amount) > 100;

-- Obtener los 5 nombres de actor más repetidos (aprox).
SELECT first_name, COUNT(*) `Nº veces` 
FROM actor 
GROUP BY first_name 
ORDER BY `Nº veces` DESC
DESC LIMIT 5;

-- Para felicitar el año nuevo chino se necesita el listado con los datos postales de los clientes residentes en China y Taiwan
SELECT * FROM customer 
INNER JOIN address ON customer.address_id = address.address_id
INNER JOIN city ON city.city_id = address.city_id
INNER JOIN country ON country.country_id = city.country_id
WHERE country = 'China' OR country = 'Taiwan';

-- Mostrar los datos de las tiendas, conocidas por la ciudad y país donde están ubicadas, indicando el nombre del gerente, el numero de películas en inventario, el numero de títulos diferentes y el número de clientes atendidos.
SELECT  manager.first_name,  manager.last_name, city.city, country.country, address.address, `stock de la tienda`, `Nº peliculas`, `clientes en tienda`, `clientes en tienda`
FROM store
INNER JOIN address ON store.address_id = address.address_id
INNER JOIN city ON city.city_id = address.city_id
INNER JOIN country ON country.country_id = city.country_id,
(SELECT staff_id, first_name, last_name FROM staff) AS manager,
(SELECT COUNT(film_id) `stock de la tienda`, COUNT(DISTINCT(film_id)) `Nº peliculas`, store_id FROM inventory GROUP BY  store_id) AS f,
(SELECT COUNT(customer_id) `clientes en tienda`, store_id FROM customer GROUP BY  store_id) AS c
WHERE manager.staff_id = store.manager_staff_id LIMIT 2;

-- Obtener el listado detallado de alquileres indicando el identificador de alquiler, el titulo alquilado, las fechas de alquiler, devolución y tiempo transcurrido, nombres del cliente (nombre con apellidos), empleado (nombre con apellidos) y tienda (ciudad, país).
SELECT rental_id `Id alquiler`, film.title `Película`, rental.rental_date `Fecha de alquilar`, rental.return_date `Fecha de devolución`, DATEDIFF(rental.return_date, rental.rental_date) `Tiempo transcurrido`, customer.first_name `Nombre del cliente`, customer.last_name `Apellido del cliente`, staff.first_name `Nombre del empleado`, staff.last_name `Apellido del empleado`, country.country `País`, city.city `Ciudad`
FROM rental
INNER JOIN inventory ON inventory.inventory_id = rental.rental_id
INNER JOIN film ON film.film_id = inventory.film_id
INNER JOIN staff ON staff.staff_id = rental.staff_id
INNER JOIN store ON store.store_id = staff.staff_id
INNER JOIN address ON store.address_id = address.address_id
INNER JOIN city ON city.city_id = address.city_id
INNER JOIN country ON country.country_id = city.country_id
INNER JOIN customer ON customer.customer_id = rental.rental_id;
 
--  Generar la lista diaria de alquileres vencidos no devueltos para poder llamar a los clientes y pedirles que los devuelvan, para ello debe mostrar las fechas de alquiler y vencimiento, el teléfono y nombre del cliente, así como el titulo de la película, priorizando los que mas tiempo llevan vencidos.
SELECT rental.rental_id, customer.first_name `Nombre`, customer.last_name `Apellidos`, address.phone `Teléfono`, film.title `Película`, rental.rental_date `Fecha de alquiler`, DATE_ADD(rental.rental_date, INTERVAL film.rental_duration DAY) `Fecha de devolución`,  DATEDIFF(NOW(), rental.rental_date) AS `Días pasados`
FROM rental
INNER JOIN customer ON customer.customer_id = rental.customer_id
INNER JOIN address ON address.address_id = customer.customer_id
INNER JOIN inventory ON inventory.inventory_id = rental.inventory_id
INNER JOIN film ON film.film_id = inventory.film_id
WHERE rental.return_date IS NULL AND DATEDIFF(NOW(), rental.rental_date) > film.rental_duration
ORDER BY `Fecha de devolución`;

-- Elaborar el ranking de los países que más alquilan las películas de GINA DEGENERES.
SELECT RANK(), actor.actor_id,actor.first_name,actor.last_name, country.country 'Pais', count(rental.rental_id) AS RANKING 
FROM rental
INNER JOIN inventory ON inventory.inventory_id = rental.inventory_id
INNER JOIN film ON film.film_id = inventory.film_id
INNER JOIN film_actor ON film.film_id = film_actor.film_id
INNER JOIN actor ON actor.actor_id = film_actor.actor_id
INNER JOIN customer ON customer.customer_id = rental.customer_id
INNER JOIN address ON customer.address_id = address.address_id
INNER JOIN city ON city.city_id = address.city_id
INNER JOIN country ON country.country_id = city.country_id
GROUP BY actor.actor_id, country.country
HAVING actor.first_name LIKE "GINA"
ORDER BY RANKING DESC





