## Flujo de datos
Zona de trabajo local (add) → Espacio de confirmación de los cambio (Traqueo- commit) →
Head local ( listo para enviar -  Push) → GitHub

![Flujo Básico](https://jonmircha.com/img/blog/git-flow.png)

## Ramas Git

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
> El salto entre ramas afecta que archivos se subiran en el push.

> Cada rama que se crea nueva toma como referencia la rama
> en donde te encuentras
--- 
