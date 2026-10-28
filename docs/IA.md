### Juan
• Fecha: 07/10/2026
• Problema que queríamos resolver: que ambos no tuvieramos el mismo código (misma identación), siguieramos las mismas prácticas con los commits (conventional commits) y malas prácticas. 
• Herramienta utilizada: Claude Code
• Prompt o consulta realizada: Quiero un equivalente de husky, prettier y eslint de vue con hooks en java
• Resumen de la respuesta: La implementación en si
• Qué parte utilizamos: Usamos todo el código que nos proporciono
• Qué modificamos: Nada
• Cómo validamos la respuesta: Probando que no pudieramos hacer commits a no ser que fueran conventional commits, tampoco con malas prácticas como importar cosas que no se usaban y que al final se procesaba con el mismo formato
• Qué hemos aprendido: Como trabajar en un proyecto con buenas prácticas
---
• Fecha: 27/10/2026
• Problema que queríamos resolver: usar un debounce en el filtrado de incidencias
• Herramienta utilizada: Claude
• Prompt o consulta realizada: quiero replicar esto: (Imagén de un código en js sobre le debounce), en javafx
• Resumen de la respuesta: que javafx lo facilita con varios metodos
• Qué parte utilizamos: la parte que nos sirvio para aplicarlo a nuestro proyecto
• Qué modificamos: adaptarlo a nuestros datos
• Cómo validamos la respuesta: probando que efectivamente se aplicaba el debounce
• Qué hemos aprendido: como usar debounce en javafx para evitar que se envie el filtro constante (con pocos datos no se aprecia el cambio)
---
• Fecha: 27/10/2026
• Problema que queríamos resolver: añadir iconos para los botones de quitar los filtros
• Herramienta utilizada: Claude
• Prompt o consulta realizada: me gustaría añadir este icono: (svg del icono) en mi proyecto de javafx, como se hace?
• Resumen de la respuesta: como aplicar un icono mediante region e icon
• Qué parte utilizamos: la parte correspondiente para crear el icono 
• Qué modificamos: creamos una función de ello para reutilizarlo en el otro icono
• Cómo validamos la respuesta: revisando que se mostraba el icono
• Qué hemos aprendido: como usar iconos svg en javafx
---
• Fecha: 25/10/2026
• Problema que queríamos resolver: estructura para modularizar el proyecto pues lo teníamos todo en main
• Herramienta utilizada: Claude
• Prompt o consulta realizada: me gustaría poder modularizar esto: (código de ese entonces)
• Resumen de la respuesta: en que carpetas añadir cada cosa
• Qué parte utilizamos: creamos las capretas que nos dijo y migramos ahí los datos
• Qué modificamos: creamos la estructura nueva
• Cómo validamos la respuesta: viendo que tras la migración seguía funcionando todo correctamente
• Qué hemos aprendido: como trabajar con muchos arhivos en javafx y como tener la estructura de las carpetas
---
• Fecha: 26/10/2026
• Problema que queríamos resolver: alternativa a stage para crear un nuevo modal/ventana
• Herramienta utilizada: Claude
• Prompt o consulta realizada: me gustaría saber si hay alguna alternativa para crear una ventana a scene para crear una incidencia
• Resumen de la respuesta: existe el dialog que te permite crear una ventana y no hay necesidad de crear la lógica de los botones de crear y cerrar pues la lógica ya esta implicita solo tienes que llamar a unas "políticas"
• Qué parte utilizamos: el ejemplo para crearlo y todo lo que se podía hacer con ello
• Qué modificamos: nada pues todavía no esta hecho con scene así que se creo directamente como dialog
• Cómo validamos la respuesta: probamos que efectivamente no hacía falta hacer toda la lógica y funcionaba todo correctamente 
• Qué hemos aprendido: alternativa a scene que lleva implicito varías cosas y por defecto no se puede escalar (esto se puede desactivar también en scene)