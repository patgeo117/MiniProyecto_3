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
    
    # eliminar rama del remote
    git push origin --delete master

> El salto entre ramas afecta que archivos se subiran en el push.

> Cada rama que se crea nueva toma como referencia la rama
> en donde te encuentras
--- 
## Fusion
- Fast-Forward: La fusión se hace automática, no hay conflictos por resolver.
- Manual Merge: La fusión hay que hacerla manual, para resolver conflictos de duplicación de contenido.
---
    # nos cambiamos a la rama principal que quedará de la fusión
    git checkout rama-principal

    # ejecutamos el comando merge con la rama secundaria a 
    fusionar
    git merge rama-secundaria
---