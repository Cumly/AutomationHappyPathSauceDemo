# Prueba Técnica – Especialista QA 

**Autor**: GhulyIu

Este proyecto contiene pruebas automatizadas de un flujo de compra en la página. Utilizando Serenity BDD + Cucumber + Selenium para la ejecución.

**Link Página:** https://www.saucedemo.com

**Flujo completo:**

- Ingreso al sistema con credenciales
- Agregar dos productos al carrito
- Visualizar el carrito
- Completar el formulario de compra
- Finalizar la compra


## Requisitos

Antes de ejecutar las pruebas deben de tener los siguiente programas instalados:

- **Java 11 o superior**: [Descargar aquí](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- **Maven**: [Descargar aquí](https://maven.apache.org/download.cgi)
- **IntelliJ IDEA o Eclipse** (recomendado con plugins de Cucumber y Gherkin).

## Pasos para ejecutar

1. **Instalar dependencias**:

   Ejecuta el siguiente comando para instalar las dependencias necesarias:

   `mvn clean install`



2. **Ejecutar las pruebas y generar el reporte**:

   Una vez instaladas las dependencias, ejecutar el siguiente comando:

   `mvn clean verify`


      Este comando realizará las siguientes acciones:
   
       - Ejecutará las pruebas automatizadas
       - Generará un reporte visual en formato **HTML** que podrás abrir en tu navegador.


3. **Accede al archivo resultante**:

   Una vez que las pruebas hayan finalizado, el archivo HTML del reporte generado se encontrará en la siguiente ruta:

   `target\site\serenity\index.html`

   o puedes abrirlo directamente desde la terminal con el siguiente comando:

   `start target/site/serenity/index.html`

   Finalmente, se abrira el reporte en el navegador preterminado.


## Clonar repositorio

Para clonar el repositorio, utiliza el siguiente comando:

`git clone https://github.com/Cumly/Automation-Happy-Path-Sauce-Demo-.git`
`cd Automation-Happy-Path-Sauce-Demo`

Después de clonar el repositorio, debes instalar las dependencias y ejecutar las pruebas siguiendo los pasos detallados anteriormente.

