/**
 * Clase CuentaBancaria que contiene un saldo y un límite de retiro.
 * Autor: Fabricio Gabriel Carrazco Arana
 * Fecha de creación: 01/09/2024
 * Última modificación: 02/09/2024
 */

class CuentaBancaria(var saldo: Double, var limiteRetiro: Double) {

    // Método para realizar un retiro desde la cuenta bancaria.
    fun retirar(monto: Double) {

        // Validar si el monto supera el límite de retiro.
        if (monto > limiteRetiro) {
            println("El monto excede el límite de retiro.")

            // Validar si hay suficiente saldo en la cuenta.
        } else if (monto > saldo) {
            println("Su Saldo es insuficiente.")
        } else {
            // Si todo es correcto, se realiza el retiro.
            saldo -= monto
            println("Retiro exitoso. Saldo restante: $$saldo")
        }
    }

    // Método para mostrar el saldo actual de la cuenta.
    fun mostrarSaldo(): Double {
        return saldo
    }
}

fun main() {
    // Crea una instancia de CuentaBancaria con un saldo inicial de 1000.0 y un límite de retiro de 500.0
    val cuenta = CuentaBancaria(1000.0, 500.0)

    // Intentar retirar 200.0 de la cuenta
    cuenta.retirar(200.0)

    // Mostrar el saldo final después del retiro
    println("Saldo final: ${cuenta.mostrarSaldo()}")
}
