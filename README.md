# Oleo Root - Quarkus API

API backend construida sobre **Quarkus 3.15** utilizando los principios de la **Arquitectura Hexagonal** (Puertos y Adaptadores). 

El proyecto está diseñado para garantizar la máxima calidad del código desde el primer commit, integrando validaciones estrictas de estilo, detección de bugs y cobertura de pruebas.

## 🏗️ Arquitectura Multi-Módulo

El proyecto está dividido en los siguientes módulos para garantizar un bajo acoplamiento:
* **`oleo-root-quarkus-domain`**: Contiene la lógica de negocio pura y los puertos (interfaces). No tiene dependencias de frameworks externos.
* **`oleo-root-quarkus-infrastructure`**: Contiene los adaptadores REST (JAX-RS Reactivo), conexiones a bases de datos y la integración directa con Quarkus.
* **`oleo-root-quarkus-boot`**: Módulo empaquetador encargado de levantar la aplicación.

## 🛠️ Stack Tecnológico
* **Java**: 21 LTS
* **Framework**: Quarkus 3.15.1
* **Construcción**: Apache Maven 3.9+

## 🛡️ Herramientas de Calidad (Quality Gates)
El ciclo de construcción (`build`) fallará automáticamente si no se cumplen los siguientes estándares:
1. **Checkstyle**: Asegura convenciones de formato e indentación.
2. **SpotBugs (4.8+)**: Análisis estático profundo para prevenir vulnerabilidades y `NullPointerExceptions`.
3. **JaCoCo**: Exige un mínimo del **80% de cobertura** de código en pruebas unitarias/integración.

## 🚀 Cómo empezar

### Compilar y Validar
Para ejecutar la compilación, ejecutar las pruebas y pasar por las pasarelas de calidad:
```bash
mvn clean install