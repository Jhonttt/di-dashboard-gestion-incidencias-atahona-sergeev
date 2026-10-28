### Juan
• Fecha: 07/10/2026

• Problema que queríamos resolver: que ambos no tuvieramos el mismo código (misma identación), siguieramos las mismas prácticas con los commits (conventional commits) y malas prácticas. 

• Herramienta utilizada: Claude Code

• Prompt o consulta realizada: quiero un equivalente de husky, prettier y eslint de vue con hooks en java

• Resumen de la respuesta: la implementación en si

• Qué parte utilizamos: usamos todo el código que nos proporciono

• Qué modificamos: nada

• Cómo validamos la respuesta: probando que no pudieramos hacer commits a no ser que fueran conventional commits, tampoco con malas prácticas como importar cosas que no se usaban y que al final se procesaba con el mismo formato

• Qué hemos aprendido: como trabajar en un proyecto con buenas prácticas

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

• Qué hemos aprendido: alternativa a scene que lleva implícito varías cosas y por defecto no se puede escalar (esto se puede desactivar también en scene)

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
• Fecha: 28/10/26

• Problema que queríamos resolver: añadir estilos como en tailwindcss

• Herramienta utilizada: Claude

• Prompt o consulta realizada: no se puede usar tailwindcss en un proyecto de javafx?

• Resumen de la respuesta: no, la alternativa es una dependencia llamada atlantafx-base que le aplicas unos estilos por defecto a todos los elementos además de poder especificar algunos

• Qué parte utilizamos: importamos la extensión y añadimos el tema claro para toda la aplicación y miramos los diferentes métodos que tenían para otros elementos como sucess en el botón de crear

• Qué modificamos: el App.java y varios elementos a dedo que queríamos cambiar algunos estilos

• Cómo validamos la respuesta: revisando que los atributos puestos funcionaban correctamente y mirándolo en la documentación: [atlantafx]([url](https://docsearch.algolia.com/mcp/docs/repo/mkpaz/atlantafx))

• Qué hemos aprendido: como aplicar estilos a toda la aplicación generales y simples de una forma fácil

---
### Lev
• Fecha: 19/10/2026

• Problema que queríamos resolver: como poder editar columnas de incidencias en la tabla desde la interfaz

• Herramienta utilizada: Google Gemini

• Prompt o consulta realizada: como hacer editables los elementos en un TableColumn en JavaFX

• Resumen de la respuesta: aplicando tabla.setEditable(true)

• Qué parte utilizamos: la parte correspondiente donde crear la tabla

• Qué modificamos: solo añadimos el metodo a la tabla ya inicializada

• Cómo validamos la respuesta: probando la interfaz
• Qué hemos aprendido: a como poder cambiar elementos de la interfaz desde la misma

