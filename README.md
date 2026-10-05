# TallerRPG2

# Taller RPG 2

## Descripción

En este taller se modificó el simulador RPG anterior para trabajar con diferentes tipos de personajes.

Se utilizaron clases abstractas, herencia, interfaces, polimorfismo y sobrescritura de métodos.

## Estructura del proyecto

### Curable.java
Tipo: Interfaz

Se creó esta interfaz para representar la capacidad de curarse.

No todos los personajes la implementan. En este caso Guerrero y Mago pueden curarse, pero Arquero no.

### Mejorable.java
Tipo: Interfaz

Se creó para definir la capacidad de subir de nivel.

Tiene el método `subirNivel()` y también un método `default` para mostrar el mensaje cuando el personaje sube de nivel.

### Personaje.java
Tipo: Clase abstracta

Es la clase principal de los personajes.

Aquí se colocaron los atributos y comportamientos que tienen en común todos los personajes, como nombre, vida, ataque, defensa y nivel.

También tiene métodos abstractos como `atacar()`, `habilidadEspecial()` y `getTipo()`, que después cada personaje debe implementar de acuerdo a su propio comportamiento.

### Guerrero.java
Tipo: Clase normal

Hereda de `Personaje` e implementa `Curable`.

Tiene su propio atributo de escudo y sus propios ataques.

También sobrescribe algunos métodos de `Personaje` para agregar el comportamiento específico del Guerrero.

### Mago.java
Tipo: Clase normal

Hereda de `Personaje` e implementa `Curable`.

Tiene como característica propia el mana, que utiliza para atacar y curarse.

También sobrescribe los métodos necesarios para que sus ataques funcionen de diferente manera.

### Arquero.java
Tipo: Clase normal

Hereda de `Personaje`, pero no implementa `Curable`.

Tiene como atributo propio la precisión y puede realizar ataques críticos.

También tiene su propia habilidad especial y sobrescribe métodos de la clase `Personaje`.

### Batalla.java
Tipo: Clase normal

Es una clase de apoyo para controlar algunas acciones del combate.

Tiene métodos `static` para realizar ataques críticos, comprobar si un personaje puede curarse y ejecutar la batalla automática.

Se trabaja con referencias de tipo `Personaje`, utilizando polimorfismo.

### Main.java
Tipo: Clase normal

Es la clase principal del programa.

Contiene el método `main` y el menú desde donde se crean los personajes y se pueden realizar las diferentes acciones del programa.

## Conceptos utilizados

### Herencia

Se utilizó `extends` para que Guerrero, Mago y Arquero hereden de `Personaje`.

Esto permite reutilizar los atributos y métodos que tienen en común.

### Clase abstracta

`Personaje` se creó como clase abstracta porque sirve como base para los demás personajes.

### Interfaces

Se utilizaron las interfaces `Curable` y `Mejorable` para representar capacidades.

`Curable` representa la capacidad de curarse y `Mejorable` la capacidad de subir de nivel.

### Polimorfismo

Se utilizaron referencias de tipo `Personaje` para trabajar con diferentes tipos de personajes.

Por ejemplo:

Personaje p1 = new Guerrero();
Personaje p2 = new Mago();

###Override
Se utilizó @Override en los métodos que las clases hijas sobrescriben de Personaje.
Esto permite que Guerrero, Mago y Arquero tengan diferentes formas de atacar, usar habilidades y mostrar su información.

##Conclusión

Considero que la forma en que se aplicaron los pilares de la programación orientada a objetos nos ayuda a trabajar un proyecto en capas, de manera ordenada, con una lógica pura porque, como dijo el ingeniero, es como se manejarían los objetos en la vida real.
