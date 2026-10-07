# Dashboard de gestión de incidencias

![Java](https://img.shields.io/badge/Java-25-orange) ![JavaFX](https://img.shields.io/badge/JavaFX-25-blue) ![Maven](https://img.shields.io/badge/Maven-3.9%2B-red)

Aplicación de escritorio en JavaFX para consultar y gestionar las incidencias internas de una pequeña empresa: indicadores de estado, listado con búsqueda y filtros, alta de incidencias y cambio de estado.

Proyecto ABP de la UD1 · Desarrollo de Interfaces · 2º DAM.

## Requisitos

- JDK 25
- Maven 3.9 o superior
- Git (en Windows, Git for Windows, que incluye Git Bash para los hooks)

## Ejecutar la aplicación

```bash
git clone https://github.com/Jhonttt/di-dashboard-gestion-incidencias-atahona.git
cd di-dashboard-gestion-incidencias-atahona
mvn javafx:run
```

La primera ejecución descarga las dependencias y configura automáticamente los hooks de Git.

## Estructura del proyecto

```
├── .githooks/              Hooks de Git (pre-commit, commit-msg, post-commit)
│   └── lib/ui.sh           Utilidades de presentación compartidas
├── config/checkstyle/      Reglas de análisis estático
├── src/main/java/          Código fuente
├── src/main/resources/     Recursos (CSS, FXML)
└── pom.xml                 Configuración de Maven
```

## Calidad de código

| Herramienta  | Para qué sirve                                      | Comando                                |
| ------------ | --------------------------------------------------- | -------------------------------------- |
| Spotless     | Formatea el código automáticamente                  | `mvn spotless:apply`                   |
| Checkstyle   | Detecta errores y código fuera de convención        | `mvn checkstyle:check`                 |
| Hooks de Git | Formatean el código y comprueban estilo y mensaje   | Se activan con cualquier comando Maven |

## Commits

Los mensajes siguen [Conventional Commits](https://www.conventionalcommits.org/es/):

```
tipo(scope opcional): descripción
```

| Tipo       | Uso                                          |
| ---------- | -------------------------------------------- |
| `feat`     | Nueva funcionalidad                          |
| `fix`      | Corrección de errores                        |
| `refactor` | Cambio interno sin alterar el comportamiento |
| `style`    | Formato y aspecto visual                     |
| `docs`     | Documentación                                |
| `chore`    | Configuración y mantenimiento                |

Para hacer commits usa `git c` (equivale a `git commit -q`): oculta el resumen de Git y muestra uno personalizado con los archivos y líneas cambiadas.

```bash
git c -m "feat: añadir filtro por estado"
```

## Equipo

- Juan Atahona Mojonero
- Nombre Apellido
