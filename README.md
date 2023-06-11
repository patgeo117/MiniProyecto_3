# MiniProyecto_3
Manejo de una biblioteca y persistencia de datos.
Realice una aplicación en java que permita manejar con propiedades de persistencia los préstamos
de libros en una biblioteca. Deben cumplirse las siguientes condiciones:
1. Deben existir tres categorías de libros: terror, novelas clásicas, ingeniería.
4. Por cada categoría deben existir al menos 5 libros.
3. Los libros y las categorías pueden ser añadidos o eliminados por los bibliotecarios para
actualizar a la biblioteca.
4. Deben existir cuentas para cada bibliotecario que puedan acceder al manejo de la
plataforma través de un sistema de login.
5. Cada bibliotecario puede informar que se ha prestado un libro o que se ha retornado. En
el caso de prestarse un libro, debe colocarse en estado de préstamo y no poder prestarse
hasta quesea retornado. El reporte debe incluir el nombre del usuario que tomó prestado
el libro.
6. Los informes de préstamo deben incluir la cantidad de días que se prestó el libro al
reportarse el retorno.
7. Si la cantidad de días de préstamo es mayor a 7 días, debe cobrarse una multa de 1000 pesos
por cada día de atraso, e implementar la mecánica para el cobro de la multa
8. Debe existir al menos un bibliotecario maestro el cual será el único tipo de bibliotecario con
la capacidad de crear/eliminar cuentas de usuario bibliotecario. Estos bibliotecarios pueden
ser creados como bibliotecarios sencillos o bibliotecarios maestros.
9. Debe existir la opción en un menú que permita mostrar el estado de los libros según la
categoría.
10. Debe existir la opción en un menú que permita mostrar quienes son los usuarios en mora
con la biblioteca.
11. Los datos de los libros, usuarios y bibliotecarios deben almacenarse de forma persistente
utilizando los conceptos vistos en clase de serialización de objetos utilizando archivos
binarios (*.bin, *.ser). 

## Conceptos

- Git and GitHub 
- Peristencia en Archivos .bin

## Flujo de datos
Zona de trabajo local (add) → Espacio de confirmación de los cambio (Traqueo- commit) →
Head local ( listo para enviar -  Push) → GitHub

![Flujo Básico](https://jonmircha.com/img/blog/git-flow.png)
 
## Ramas Git

---
    # crear rama
    git branch nombre-rama

    # cambiar de rama
    git checkout nombre-rama

    # crear una rama y cambiarte a ella
    git checkout -b rama

    # eliminar rama
    git branch -d nombre-rama

    # eliminar ramas remotas
    git push origin --delete nombre-rama

    #eliminar rama (forzado)
    git branch -D nombre-rama

    # listar todas las ramas del repositorio
    git branch

    # lista ramas no fusionadas a la rama actual
    git branch --no-merged

    # lista ramas fusionadas a la rama actual
    git branch --merged

    # añadir la rama al remote
    git push -u origin  nombre de la rama

