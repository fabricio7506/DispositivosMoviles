// Descripción: Programa para evaluar empleados basado en su puntuación y salario mensual.
// Autor: Fabricio Gabriel Carrazco Arana
// Fecha de creación: 25/08/2024
// Última modificación: 25/08/2024
fun main() {
    // Lee la puntuación y el salario mensual del usuario
    print("Ingrese la puntuación del empleado (0-10): ")
    val puntuacion = readLine()?.toIntOrNull() ?: 0
    print("Ingrese el salario mensual del empleado: ")
    val salarioMensual = readLine()?.toDoubleOrNull() ?: 0.0

    // Se Calcula el nivel de rendimiento
    val nivelRendimiento = determinarNivelRendimiento(puntuacion)

    // Se Calcula la cantidad de dinero recibida
    val dineroRecibido = calcularDineroRecibido(salarioMensual, puntuacion)

    // Mostramos los resultados
    println("Resultado: Nivel de Rendimiento $nivelRendimiento. Cantidad de Dinero Recibido $$dineroRecibido.")
}

fun determinarNivelRendimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularDineroRecibido(salario: Double, puntuacion: Int): Double {
    return salario * puntuacion / 10
}