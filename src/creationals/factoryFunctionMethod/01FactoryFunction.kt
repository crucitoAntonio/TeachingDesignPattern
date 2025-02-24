package creationals.factoryFunctionMethod
typealias Language = String
/**
 * 🚀 **Factory Function**
 *
 * Una **Factory Function** es un **patrón de diseño creacional** que nos permite **crear objetos o funciones de manera dinámica**,
 * devolviendo una instancia configurada según ciertos parámetros de entrada.
 *
 * ✅ **¿Cuándo es útil?**
 *   - Cuando necesitamos **crear instancias de una clase** sin usar `new` explícitamente.
 *   - Para **devolver funciones personalizadas** basadas en valores de entrada.
 *   - Para mejorar la **legibilidad** y **mantenimiento** del código.
 *   - Cuando queremos **ocultar la lógica de creación** dentro de una función.
 *
 * 🛠 **Ventajas:**
 *   - 📌 Permite **crear objetos o funciones en tiempo de ejecución**.
 *   - 🌱 Evita la necesidad de usar **constructores complicados** o **subclases innecesarias**.
 *   - 🚀 Facilita la implementación de **polimorfismo y configuración flexible**.
 *
 * 📌 **Ejemplo de uso en Kotlin:**
 * - `createGreeter(lang: String)`: Devuelve una función que genera saludos en diferentes idiomas.
 * - `createLogger(level: LogLevel)`: Devuelve un objeto de logging con diferentes niveles de severidad.
 *
 * 🔗 Más información: [Factory Function - Refactoring Guru](https://refactoring.guru/design-patterns/factory-method)
 */

class FactoryFunction {
    fun createGreeter(lang: String): (String) -> Unit {
        val messages = mapOf(
            "es" to { name: String -> "Hola, $name!" },
            "en" to { name: String -> "Hello, $name!" },
            "fr" to { name: String -> "Bonjour, $name!" }
        )

        return { name: String ->
            val message = messages[lang]?.invoke(name) ?: "Hello, $name!" // 🔥 Usa inglés si el idioma no existe
            println("\u001B[31m$message\u001B[0m") // 🔥 Formato en rojo ANSI (equivalente a `COLORS.red` en TypeScript)
        }
    }
}
fun main(){
    var spanishPerson = FactoryFunction().createGreeter("es")
    println(spanishPerson("Antonio"))
    spanishPerson = FactoryFunction().createGreeter("en")
    println(spanishPerson("Tony"))
     spanishPerson = FactoryFunction().createGreeter("fr")
    println(spanishPerson("Antua"))
}