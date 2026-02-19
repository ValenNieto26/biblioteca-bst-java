#  Sistema de Gestión de Biblioteca con Árbol Binario de Búsqueda (BST)

**Estudiante:** Valentina Nieto 
**Asignatura:** Estructuras de Datos  
**Lenguaje:** Java  
**Paradigma:** Programación Orientada a Objetos (POO)

---

##  Descripción del Proyecto

Este proyecto implementa un **Sistema de Gestión de Biblioteca** utilizando un  
**Árbol Binario de Búsqueda (BST)** como estructura principal para almacenar y organizar libros.

El criterio de ordenamiento es **el apellido del autor**, lo que permite realizar búsquedas, inserciones y eliminaciones de forma eficiente.

El sistema incluye:

- Registro de libros  
- Búsqueda por autor e ISBN  
- Eliminación de libros  
- Recorridos del árbol (InOrden, PreOrden, PostOrden)  
- Registro de préstamos y devoluciones  
- Listado de libros disponibles y prestados  
- Búsqueda por categoría  
- Estadísticas del catálogo  
- Menú interactivo por consola  

---

##  Estructura del Proyecto
biblioteca-bst/
├── src/
│   ├── modelo/
│   │   ├── Libro.java
│   │   └── NodoBST.java
│   ├── estructura/
│   │   └── ArbolBST.java
│   ├── servicio/
│   │   └── BibliotecaService.java
│   └── vista/
│       └── MenuPrincipal.java
├── README.md

---
Captura de Pantalla Sistema 

<img width="1920" height="1020" alt="Captura de pantalla 2026-02-19 090619" src="https://github.com/user-attachments/assets/fb27008c-4522-4cde-942c-dc06b6e18d44" />
Notas Finales
Este proyecto fue desarrollado con fines académicos para comprender el funcionamiento de los Árboles Binarios de Búsqueda y su aplicación en sistemas reales.

👩‍💻 Autora
Valentina Nieto
Universidad Remington
2026

---

## ⚙️ Requerimientos Técnicos

- Java 8 o superior  
- Consola o terminal para ejecutar el programa  
- Git (opcional, para control de versiones)

---

## Instrucciones de Compilación y Ejecución

### **1. Compilar el proyecto**

Ubícate en la carpeta raíz del proyecto (donde está `src/`) y ejecuta:

```bash
javac -d bin src/modelo/*.java src/estructura/*.java src/servicio/*.java src/vista/MenuPrincipal.java
java -cp bin vista.MenuPrincipal

Funcionalidades Implementadas
Árbol BST completo:

Insertar

Buscar por autor

Eliminar

Recorridos (InOrden, PreOrden, PostOrden)

Encontrar mínimo y máximo

Contar nodos

Altura del árbol

Gestión de biblioteca:

Registrar préstamo

Registrar devolución

Listar disponibles

Listar prestados

Buscar por ISBN

Buscar por categoría

Estadísticas del catálogo




