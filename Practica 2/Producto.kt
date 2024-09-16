/**
 * Clase Producto que contiene un precio y un descuento aplicable.
 * Autor: Fabricio Gabriel Carrazco Arana
 * Fecha de creación: 01/09/2024
 * Última modificación: 02/09/2024
 */

class Producto(var precio: Double, var descuento: Double) {

    // Método para calcular el precio final después de aplicar el descuento.
    fun calcularPrecioFinal(): Double {

        // Aplicar el descuento al precio y devolver el precio final.
        return precio - (precio * descuento / 100)
    }
}

fun main() {
    // Crear una instancia de Producto con un precio de 100.0 y un descuento del 10%
    val producto = Producto(100.0, 10.0)

    // Calcular y mostrar el precio final después del descuento
    println("Precio final: ${producto.calcularPrecioFinal()}")
}
