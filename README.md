# MiniProyecto_3
Manejo de una biblioteca y persistencia de datos.
Realice una aplicación en java que permita manejar con propiedades de persistencia los préstamos
de libros en una biblioteca. Deben cumplirse las siguientes condiciones:
1. Deben existir tres categorías de libros: terror, novelas clásicas, ingeniería.
2. Por cada categoría deben existir al menos 5 libros.
3. Los libros y las categorías pueden ser añadidos o eliminados por los bibliotecarios para
actualizar a la biblioteca.
4. Deben existir cuentas para cada bibliotecario que puedan acceder al manejo de la
plataforma a través de un sistema de login.
5. Cada bibliotecario puede informar que se ha prestado un libro o que se ha retornado. En
el caso de prestarse un libro, debe colocarse en estado de préstamo y no poder prestarse
hasta que sea retornado. El reporte debe incluir el nombre del usuario que tomó prestado
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
Zona de trabajo local (add) → Espacio de confirmación del cambio (Traqueo- commit) →
Head local ( listo para enviar - Push) → GitHub

![Flujo Básico](https://jonmircha.com/img/blog/git-flow.png)

# Ejecutamos el comando merge con la rama secundaria a fusionar
    git merge rama-secundaria
---
## Commit
    # sin editar el mensaje del último commit
    git commit --amend --no-edit

    # editando el mensaje del último commit (sin haber echo el push)
    git commit --amend -m "nuevo mensaje para el último commit"

    # eliminar el último commit
    git reset --hard HEAD~1

    # cambiar a un commit en particular (Viajar en el tiempo)
    git checkout id-commit
---
## Historial
    git log ...
    # muestra en una sola línea por cambio
    git log --oneline
--- 
## Reset Historial
    # nos muestra el listado de archivos nuevos (untracked), borrados o editados
    git status

    # deshace todos los cambios después del commit indicado, 
    preservando los cambios localmente
    git reset id-commit

    # desecha todo el historial y regresa al commit especificado
    git reset --hard id-commit
--- 
## Remotos
    # muestra los orígenes remotos del repositorio
    git remote

    # muestra los orígenes remotos con detalle
    git remote -v

    # descargar una rama remota a local diferente a la principal
    git checkout --track -b rama-remota origin/rama-remota
---
