/**
 * Sistema de Gestión de Biblioteca con diversas clases y interfaces.
 * Autor: Fabricio Gabriel Carrazco Arana
 * Fecha de creación: 01/09/2024
 * Última modificación: 02/09/2024
 */

// Clase abstracta Material que representa un material genérico en la biblioteca.
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    // Método abstracto que deberá implementarse en las subclases para mostrar los detalles del material.
    abstract fun mostrarDetalles()
}

// Clase Libro que hereda de Material y añade propiedades específicas para un libro.
class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int)
    : Material(titulo, autor, anioPublicacion) {

    // Implementación del método mostrarDetalles para libros.
    override fun mostrarDetalles() {
        println("Libro: $titulo, Autor: $autor, Año: $anioPublicacion, Género: $genero, Páginas: $numeroPaginas")
    }
}

// Clase Revista que hereda de Material y añade propiedades específicas para una revista.
class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int)
    : Material(titulo, autor, anioPublicacion) {

    // Implementación del método mostrarDetalles para revistas.
    override fun mostrarDetalles() {
        println("Revista: $titulo, Autor: $autor, Año: $anioPublicacion, ISSN: $issn, Volumen: $volumen, Número: $numero")
    }
}

// Clase Usuario que representa a un usuario de la biblioteca.
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// Interfaz que define las operaciones de la biblioteca, como registrar material, prestar y devolver.
interface IBiblioteca {
    fun registrarMaterial(material: Material)
    fun registrarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun devolverMaterial(material: Material)
    fun mostrarMaterialesDisponibles()
}

// Clase Biblioteca que implementa la interfaz IBiblioteca y gestiona los materiales y usuarios.
class Biblioteca : IBiblioteca {
    // Lista que almacena los materiales disponibles en la biblioteca.
    private val materiales = mutableListOf<Material>()
    // Mapa que relaciona a los usuarios con los materiales que tienen prestados.
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    // Método para registrar un nuevo material en la biblioteca.
    override fun registrarMaterial(material: Material) {
        materiales.add(material)
    }

    // Método para registrar un nuevo usuario en la biblioteca.
    override fun registrarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
    }

    // Método para prestar un material a un usuario.
    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materiales.contains(material)) {
            // Si el material está disponible, se asigna al usuario y se retira de la lista de materiales disponibles.
            usuarios[usuario]?.add(material)
            materiales.remove(material)
            println("Material prestado: ${material.titulo}")
        } else {
            println("Material no disponible")
        }
    }

    // Método para devolver un material a la biblioteca.
    override fun devolverMaterial(material: Material) {
        materiales.add(material)
        println("Material devuelto: ${material.titulo}")
    }

    // Método para mostrar todos los materiales disponibles en la biblioteca.
    override fun mostrarMaterialesDisponibles() {
        println("Materiales disponibles:")
        materiales.forEach { it.mostrarDetalles() }
    }
}

// Ejemplo de uso
fun main() {
    // Crear una instancia de Biblioteca
    val biblioteca = Biblioteca()

    // Crear instancias de Libro y Revista
    val libro = Libro("Cien Años de Soledad", "Gabriel García Márquez", 1967, "Realismo Mágico", 417)
    val revista = Revista("National Geographic", "Varios", 2023, "1234-5678", 150, 5)
    val usuario = Usuario("Juan", "Pérez", 30)

    // Registrar el libro y la revista en la biblioteca
    biblioteca.registrarMaterial(libro)
    biblioteca.registrarMaterial(revista)

    // Registrar el usuario en la biblioteca
    biblioteca.registrarUsuario(usuario)

    // Mostrar los materiales disponibles antes de prestar
    biblioteca.mostrarMaterialesDisponibles()

    // Prestar el libro al usuario
    biblioteca.prestarMaterial(usuario, libro)

    // Mostrar los materiales disponibles después de prestar
    biblioteca.mostrarMaterialesDisponibles()

    // Devolver el libro a la biblioteca
    biblioteca.devolverMaterial(libro)

    // Mostrar los materiales disponibles después de devolver
    biblioteca.mostrarMaterialesDisponibles()
}
