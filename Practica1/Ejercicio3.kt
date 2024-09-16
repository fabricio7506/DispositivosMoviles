/*
Descripción: Programa que realiza una calculadora básica con suma, resta, multiplicación y división.
Autor: Fabricio Gabriel Carrazco Arana
Fecha de creación: 25/08/2024
Fecha última modificación: 25/08/2024
*/

fun main() {
    while (true) {
        // Menú de opciones
        println("==== Menú ====")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Elige una opción: ")

        // Lectura y validación de la opción
        val opcion = readLine()?.toIntOrNull()

        // Opción de salida
        if (opcion == 5) {
            println("Saliendo del programa...")
            break
        }

        // Validación de opción correcta
        if (opcion !in 1..4) {
            println("Opción no válida. Por favor, elige una opción válida.")
            continue
        }

        // Solicitud de los números
        print("Ingresa el primer número: ")
        val num1 = readLine()?.toDoubleOrNull() ?: continue

        print("Ingresa el segundo número: ")
        val num2 = readLine()?.toDoubleOrNull() ?: continue

        // Ejecución de la operación seleccionada
        when (opcion) {
            1 -> println("Resultado de la suma: ${num1 + num2}")
            2 -> println("Resultado de la resta: ${num1 - num2}")
            3 -> println("Resultado de la multiplicación: ${num1 * num2}")
            4 -> {
                if (num2 != 0.0) {
                    println("Resultado de la división: ${num1 / num2}")
                } else {
                    println("Error: No se puede dividir por cero.")
                }
            }
        }
        println()  // Salto de línea para claridad
    }
}
