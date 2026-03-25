# Prueba de Cálculos Matemáticos - Android

Este proyecto es una aplicación de Android desarrollada en Java que demuestra el manejo de múltiples actividades (`Activities`), transferencia de datos entre pantallas y lógica matemática algorítmica.

## Funcionalidades

La aplicación consta de un flujo de 3 pantallas con las siguientes características:

1.  **Pantalla Principal (Main):** Muestra el resumen de datos. Los campos de resultados solo se activan al completar el flujo.
2.  **Segunda Pantalla:** Registro de datos personales (Nombres y Apellidos).
3.  **Tercera Pantalla:** Ingreso de valores numéricos y ejecución de lógica interna.

## Lógica Matemática Aplicada

Para cumplir con requerimientos específicos de optimización y algoritmos básicos, se implementó:

* **División Entera:** Calculada mediante el método de **restas sucesivas** (sin usar los operadores `/` o `%`).
* **Inversión de Números:** Realizada de forma **estrictamente matemática** mediante descomposición de unidades, decenas y centenas (sin usar cadenas de texto o vectores).

## Tecnologías Usadas

* **Lenguaje:** Java
* **IDE:** Android Studio
* **Diseño UI:** XML con estructuras de `LinearLayout` pesado para alineación proporcional de etiquetas.
* **Comunicación:** `ActivityResultLauncher` para el retorno jerárquico de datos entre actividades.

