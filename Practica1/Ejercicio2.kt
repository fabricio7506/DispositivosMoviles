/*
Descripción: Programa que simula el juego de Piedra, Papel o Tijera contra la computadora.
Autor: Fabricio Gabriel Carrazco Arana
Fecha de creación: 25/08/2024
Fecha última modificación: 25/08/2024
*/

import kotlin.random.Random

fun main() {
    // Lista de opciones posibles
    val opciones = listOf("Piedra", "Papel", "Tijera")
    // La computadora elige una opción aleatoria
    val eleccionComputadora = opciones[Random.nextInt(3)]

    // El usuario elige su opción
    println("Elige una opción: Piedra, Papel o Tijera")
    val eleccionUsuario = readLine()?.capitalize()

    // Verificación de la validez de la opción del usuario
    if (eleccionUsuario in opciones) {
        println("Computadora eligió: $eleccionComputadora")
        println("Tú elegiste: $eleccionUsuario")

        // Comparación para determinar el resultado del juego
        when {
            eleccionUsuario == eleccionComputadora -> println("Empate")
            eleccionUsuario == "Piedra" && eleccionComputadora == "Tijera" -> println("Ganaste")
            eleccionUsuario == "Papel" && eleccionComputadora == "Piedra" -> println("Ganaste")
            eleccionUsuario == "Tijera" && eleccionComputadora == "Papel" -> println("Ganaste")
            else -> println("Perdiste")
        }
    } else {
        println("Opción no válida")
    }
}
