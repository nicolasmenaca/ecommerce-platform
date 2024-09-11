# ecommerce-platform
Este repositorio contiene un servicio específico de una aplicación web de e-commerce desarrollada en Java. El propósito de este servicio es integrarlo en un flujo CI/CD utilizando GitHub Actions.

Durante la configuración del pipeline, surgió un problema con la conexión a la base de datos. Por eso, he incluido una explicación detallada sobre el archivo .yml utilizado para gestionar el flujo CI/CD en GitHub Actions. Esta guía tiene como objetivo facilitar la comprensión del proceso y destacar mi experiencia en la implementación de pipelines.

############################################################

**Descripción del Archivo .yml**


A continuación se detalla la configuración del flujo de trabajo definido en el archivo .yml ubicado en la carpeta .github, siguiendo las recomendaciones de la documentación:

**name**: Define el nombre del flujo de trabajo. En este caso, se denomina "Java CI".

**on**: Establece los eventos que activarán el flujo de trabajo. En esta configuración, el pipeline se ejecutará automáticamente cada vez que se realice un push a la rama main.

**jobs**: Especifica los trabajos que se ejecutarán como parte del flujo de trabajo. En esta configuración, hay un único trabajo llamado build.

**build**: Este trabajo se ejecuta en una máquina virtual con Ubuntu y se compone de varios pasos:

**services**: Define los servicios necesarios para ejecutar los pasos del trabajo. En este caso, estamos utilizando MySQL con la imagen de la versión 8.0. Se configuran las credenciales de acceso y se expone el puerto 3606.

**steps**: Detalla los pasos individuales dentro del trabajo. Estos pasos incluyen:

- Instalación de Docker
- Configuración inicial del repositorio
- Configuración de Java 17
- Compilación de la aplicación con Maven
- Ejecución de pruebas unitarias
- Ejecución de la aplicación Spring Boot
- Puedes encontrar el archivo .yml en la carpeta .github, siguiendo las mejores prácticas recomendadas.

Conclusión
Este README proporciona una visión general del flujo CI/CD para la aplicación E-commerce y explica los detalles del archivo .yml utilizado para configurar GitHub Actions. Espero que esta documentación te sea útil para comprender el proceso y la integración de CI/CD en este proyecto.