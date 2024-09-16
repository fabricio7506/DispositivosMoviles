/**
 * Clase abstracta Shape y subclases para representar diferentes figuras geométricas.
 * Autor: Fabricio Gabriel Carrazco Arana
 * Fecha de creación: 01/09/2024
 * Última modificación: 02/09/2024
 */

// Definición de la clase abstracta Shape que contiene métodos abstractos para calcular área y perímetro.
abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double
}

// Clase Cuadrado que hereda de Shape y define métodos para calcular área y perímetro.
class Cuadrado(val lado: Double) : Shape() {
    override fun calcularArea(): Double {
        return lado * lado
    }

    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

// Clase Circulo que hereda de Shape y define métodos para calcular área y perímetro.
class Circulo(val radio: Double) : Shape() {
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

// Clase Rectangulo que hereda de Shape y define métodos para calcular área y perímetro.
class Rectangulo(val largo: Double, val ancho: Double) : Shape() {
    override fun calcularArea(): Double {
        return largo * ancho
    }

    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

fun main() {
    // Crear instancias de Cuadrado, Circulo y Rectangulo con valores específicos
    val cuadrado = Cuadrado(4.0)
    val circulo = Circulo(3.0)
    val rectangulo = Rectangulo(5.0, 3.0)

    // Calcular y mostrar área y perímetro de cada figura
    println("Área del cuadrado: ${cuadrado.calcularArea()}, Perímetro: ${cuadrado.calcularPerimetro()}")
    println("Área del círculo: ${circulo.calcularArea()}, Perímetro: ${circulo.calcularPerimetro()}")
    println("Área del rectángulo: ${rectangulo.calcularArea()}, Perímetro: ${rectangulo.calcularPerimetro()}")
}
