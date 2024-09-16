/*
Descripción: Programa en el que el usuario debe adivinar un número generado aleatoriamente entre 1 y 30.
Autor: Fabricio Gabriel Carrazco Arana
Fecha de creación: 25/08/2024
Fecha última modificación: 25/08/2024
*/

import kotlin.random.Random

fun main() {
    // Genera Numero Aleatorio entre 1 y 30
    val numeroAleatorio = Random.nextInt(1, 31)
    var intentosRestantes = 9

    // Damos Inicio al juego
    println("Adivina el número (entre 1 y 30). Tienes $intentosRestantes intentos.")

    while (intentosRestantes > 0) {
        // Solicitar número al usuario
        print("Ingresa tu número: ")
        val numeroUsuario = readLine()?.toIntOrNull()

        // Validación del número ingresado
        if (numeroUsuario == null || numeroUsuario !in 1..30) {
            println("Por favor, ingresa un número válido entre 1 y 30.")
            continue
        }

        // Verificación del número y pistas
        when {
            numeroUsuario < numeroAleatorio -> println("El número es mayor.")
            numeroUsuario > numeroAleatorio -> println("El número es menor.")
            else -> {
                println("¡De Maravilla! Adivinaste el número.")
                return  // Termina el juego
            }
        }

        // Disminuir intentos restantes
        intentosRestantes--
        println("Te quedan $intentosRestantes intentos.\n")
    }

    // Fin del juego
    println("Your Lose. El número era $numeroAleatorio.")
}
