# Cafetería automática del instituto: Programación Multihilo

**Autor:** Susana Roldán Parra  
**Fecha máxima de entrega:** 10 de Mayo del 2026 a las 23:59

## Contexto del problema
En un instituto se ha instalado una cafetería automática inteligente en la sala de profesores. La máquina prepara cafés bajo demanda, pero funciona de una forma particular:
* Hay un depósito limitado donde se van colocando los cafés ya preparados.
* La máquina prepara cafés y los deja en el depósito.
* Cada profesor va a la máquina de vez en cuando y recoge un café si hay alguno disponible.
* El depósito tiene una capacidad máxima, por lo que la máquina no puede seguir preparando si está lleno.
* Los profesores no pueden coger café si el depósito está vacío.

> **Nota:** Este comportamiento debe resolverse usando un **monitor**, de forma que la coordinación entre hilos sea segura y no haya errores de concurrencia.

## Objetivo didáctico
El objetivo del ejercicio es practicar:
* Creación de varios hilos en Java.
* Acceso concurrente a un recurso compartido.
* Uso de monitores con `synchronized`.
* Uso de `wait()` y `notifyAll()`.
* Control de condiciones de espera.

## Enunciado
Debes desarrollar un programa en Java que simule el funcionamiento de esta cafetería automática.

### 1. Elemento compartido: El depósito de cafés
Existirá una clase que represente el depósito compartido donde se almacenan los cafés preparados.
**Características del depósito:**
* Tendrá una capacidad máxima fijada al crear el objeto (Ejemplo: 5 cafés).
* Permitirá depositar un café preparado.
* Permitirá retirar un café para consumirlo.
* Si el depósito está lleno, la máquina deberá esperar.
* Si el depósito está vacío, el profesor deberá esperar.

### 2. Productor: La máquina de café
* Antes de dejar cada café en el depósito, tardará un tiempo aleatorio o fijo simulando la preparación.
* Cuando consiga dejar un café, debe mostrarse un mensaje:  
  `Cafetera prepara y deposita Cafe-7. En depósito: 3`
* La máquina producirá un número limitado de cafés (Ejemplo: 20 cafés en total).

### 3. Consumidores: Los profesores
Su comportamiento será:
* Cada profesor irá a la máquina varias veces.
* Cuando quiera tomar un café, intentará retirarlo del depósito.
* Si hay café disponible, lo recoge y se mostrará un mensaje:  
  `Profesor Ana retira Cafe-7. En depósito: 2`
* Después “tardará un tiempo” en beberlo antes de volver a pedir otro.
* Habrá varios profesores (Ejemplo: Ana, Luis, Marta).
* Cada profesor puede consumir una cantidad variable de cafés, por ejemplo 6 o 7 cada uno, de forma que entre todos consuman exactamente los que el barista produce.

## Requisitos funcionales
Tu programa debe cumplir lo siguiente:
1. Debe existir un monitor que controle el acceso al depósito de cafés.
2. El depósito debe tener una capacidad máxima limitada.
3. La máquina no puede depositar cafés cuando el depósito esté lleno.
4. Los profesores no pueden retirar cafés cuando el depósito esté vacío.
5. La sincronización debe resolverse usando mecanismos clásicos de monitores en Java: `synchronized`, `wait()` y `notifyAll()`.
6. Debe mostrarse por pantalla la actividad: Cuándo se prepara un café, Cuándo se deposita, Cuándo un profesor lo retira, Cuándo un hilo queda esperando.
7. La ejecución debe terminar correctamente cuando la máquina haya producido todos los cafés y los profesores los hayan consumido.

## Entregas
* El diseño de las clases necesarias.
* La implementación completa en Java.
* La ejecución del programa mostrando por consola la interacción entre los hilos.
* Una breve explicación de:
    * Cuál es el recurso compartido.
    * Qué clase actúa como monitor.
    * Dónde se usan `wait()` y `notifyAll()` y por qué son necesarios.