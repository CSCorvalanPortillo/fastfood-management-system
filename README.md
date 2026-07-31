# 🍔 FastFood Management System

> Sistema de gestión para un restaurante de comida rápida desarrollado en **Java**, aplicando **Programación Orientada a Objetos (POO)**, **arquitectura por capas**, **principios SOLID** y persistencia de datos mediante archivos de texto.

> 🚧 **Estado del proyecto:** En desarrollo. Este proyecto forma parte del trabajo integrador de la carrera de Informática Aplicada y continuará evolucionando con la incorporación de base de datos relacional e interfaz gráfica.

---

## Vista previa

![Menú principal](menuprincipal.png)

---

# Descripción

FastFood Management System es una aplicación de consola desarrollada para administrar las operaciones básicas de un restaurante de comida rápida.

El sistema fue diseñado siguiendo una arquitectura modular que separa las responsabilidades de cada componente, permitiendo un código más organizado, mantenible y preparado para futuras ampliaciones.

Actualmente implementa persistencia mediante archivos de texto, permitiendo almacenar la información sin depender de un motor de base de datos externo.

---

# Funcionalidades

* Gestión de productos
* Gestión de ingredientes
* Asociación Producto - Ingrediente
* Gestión de empleados
* Gestión de gerentes
* Administración de pedidos
* Inicio de sesión por usuario
* Persistencia de datos mediante archivos `.txt`
* Validaciones de negocio mediante excepciones personalizadas

---

# Arquitectura

El proyecto implementa una arquitectura por capas con separación de responsabilidades.

```
View
    │
Controller
    │
Service
    │
DAO
    │
Persistencia (.txt)
```

### Model

Representa las entidades principales del dominio del sistema.

### View

Gestiona la interacción con el usuario mediante menús desarrollados en consola.

### Controller

Coordina las solicitudes del usuario y comunica la vista con la lógica de negocio.

### Service

Implementa las reglas de negocio y validaciones del sistema.

### DAO

Encapsula las operaciones CRUD sobre la capa de persistencia.

### DTO

Permite transportar información entre capas evitando un acoplamiento innecesario.

### Persistencia

Implementada mediante archivos de texto, abstraída completamente por la capa DAO.

### Excepciones

El sistema utiliza excepciones personalizadas para controlar errores específicos del negocio y mejorar la robustez de la aplicación.

---

# Tecnologías utilizadas

* Java
* Programación Orientada a Objetos (POO)
* Principios SOLID
* Arquitectura por capas
* Patrón DAO
* DTO (Data Transfer Object)
* Persistencia mediante archivos de texto
* UML
* Git
* GitHub

---

# Conceptos aplicados

## Programación Orientada a Objetos

* Encapsulamiento
* Abstracción
* Herencia
* Polimorfismo

## Principios SOLID

* Single Responsibility Principle (SRP)
* Open/Closed Principle (OCP)
* Liskov Substitution Principle (LSP)
* Interface Segregation Principle (ISP)
* Dependency Inversion Principle (DIP)

---

# Decisiones de diseño

Durante el desarrollo se tomaron las siguientes decisiones técnicas:

* Separación estricta entre presentación, lógica de negocio y persistencia.
* Uso de interfaces para desacoplar implementaciones.
* Persistencia mediante archivos de texto para evitar dependencias externas durante esta etapa del proyecto.
* Utilización de DTO para transportar información entre capas.
* Implementación de excepciones personalizadas para centralizar el manejo de errores.
* Diseño preparado para migrar la persistencia hacia una base de datos relacional sin modificar la lógica de negocio.

---

# Próximas mejoras

* Integración con base de datos relacional (MySQL).
* Desarrollo de interfaz gráfica.
* Optimización del modelo UML.
* Incorporación de nuevas funcionalidades administrativas.
* Mejora de la experiencia de usuario.

---

# Objetivos del proyecto

* Aplicar Programación Orientada a Objetos en un caso de negocio real.
* Implementar una arquitectura modular y escalable.
* Aplicar principios SOLID y buenas prácticas de desarrollo.
* Construir una base sólida para futuras integraciones con bases de datos e interfaces gráficas.

---

# Autores

* Carla Corvalán Portillo
* Pablo Gustavo García
* Vicente Reynaldo Ciancio

---

# Licencia

Proyecto desarrollado con fines académicos y de aprendizaje.
