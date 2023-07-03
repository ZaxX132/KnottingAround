# KnottingAround
El API de knottingAround fue creado con el proposito de practicar los conceptos de Spring data JPA, Spring security y Spring Cloud.
<br>
* Se implementó Spring security con JWT, el usuario podrá registrarse e iniciar sesión teniendo además los perfiles de ADMIN y CUSTOMER. Estos dos perfiles tendrán diferentes permisos dentro de la aplicación.
* Se implementó Spring Data JPA para el manejo de los datos de la aplicación usando los repositorios, querys entre otros para poder darle todas las funcionalidades a la aplicación
* Se realizó un manejo de errores para que el usuario tenga retroalimentación de como ingresar los datos
* El objetivo de la API es simular todo lo que tendría una tienda de amigurumis desde poder ver los amigurumis existentes hasta poder hacer que un customer pueda realizar una compra de estos.
* Se tiene una configuracion con Spring Cloud server en el application properties, por lo que listaré las propiedades que se utilizaron
<br>

## Propiedades utilizadas

* security.jwt.secret="Ingrese el secreto de JWT"
* security.jwt.ttldays="Ingrese la cantidad en dias de la duracion de los JWT"
* spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
* spring.datasource.url="Ingrese la url de la base de datos"
* spring.datasource.username="Ingrese el username"
* spring.datasource.password="Ingrese el password"
