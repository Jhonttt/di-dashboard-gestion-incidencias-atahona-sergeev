## Decisiones de diseño:

#### 1. Meter opciones de Apertura y Eliminación en un elemento desplegable al final de la fila de cada incidencia (en la columna “Opciones”)

```
Justificación:

1. Ahorra mucho espacio de forma predeterminada 
2. Se evita que las tres opciones ocupen espacio visual y atencional cuando no necesiten ser usadas (solo cuando se despliega el elemento). Por ejemplo: cuando solo se necesite usar la interfaz a modo de recurrencia referencial global (sin la necesidad de editar, abrir o eliminar ninguna incidencia), se evita que estas opciones invadan el espacio visual y atencional sin necesidad
```

#### 2. Mostrar una ventana emergente con las opciones “Confirmar” y “Cancelar” (y un mensaje textual) desde la opción “Eliminar”

```
Justificación:

Así se evita borrar accidentalmente una incidencia a la hora de desplegar un elemento de la columna “Opciones”. Porque, por ejemplo, al desplegar la celda de “Opciones”, estando posicionada la opción “Eliminar” muy cerca de la opción “Abrir”, por lo que existe la posibilidad de pulsar accidentalmente en “Eliminar” mientras se intenta pulsar en “Abrir”.
```

#### 3. Introducir los datos de la incidencia a crear en una ventana emergente tras pulsar el botón “Crear incidencia”

```
Justificación:

Al igual que con las opciones de Apertura y Eliminación, se ahorra espacio y se evita mostrar datos innecesarios antes hacer cierta interacción para una acción especifica. Esto además promueve el feedback en la interfaz cuando el usuario realiza acciones relevantes.
```

#### 4. Cambiar automáticamente el color de fondo de las filas de la tabla de incidencias según su valor en la columna Estado

```
Justificación:

Da buen contraste para distinguir a simple vista el estado de cada elemento. Esto permite encontrar fácilmente los elementos de cada estado incluso sin aplicar filtros.
```

#### 5. Adaptar automaticamente el ancho de columnas en la tabla al tamaño de la ventana de la aplicacion

```
Justificación:

Da mayor comodidad visual e impide que aparezca una nueva columna vacia al agrandar mucho la ventana de la aplicacion
```