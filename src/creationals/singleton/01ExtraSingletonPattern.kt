package creationals.singleton
/**
 * 🔄 **Patrón Singleton**
 *
 * El **Singleton** es un patrón de diseño creacional que garantiza que
 * una clase tenga **una única instancia** en toda la aplicación y
 * proporciona un **punto de acceso global** a ella.
 *
 * ✅ **¿Cuándo es útil?**
 *   - Cuando necesitas **una única instancia** compartida en toda la aplicación.
 *   - Para gestionar **conexiones a bases de datos** de forma centralizada.
 *   - En **configuraciones globales**, donde múltiples partes del código
 *     requieren acceso a los mismos datos.
 *   - En **gestión de logs**, cachés y controladores de eventos.
 *
 * 🚀 **Ventajas:**
 *   - 🌍 **Acceso global** a la única instancia.
 *   - ⚡ **Evita la creación innecesaria de múltiples objetos**, ahorrando memoria.
 *   - 🛡 **Previene inconsistencias** al compartir estados entre diferentes partes del sistema.
 *   - 🔒 Puede controlar el acceso concurrente en aplicaciones multihilo.
 *
 * ⚠️ **Posibles desventajas:**
 *   - ❌ Puede romper el **Principio de Responsabilidad Única (SRP)** si gestiona más
 *     de una responsabilidad.
 *   - ❌ Puede hacer que el código sea **difícil de testear**, ya que introduce
 *     dependencias globales.
 *   - ❌ En algunas aplicaciones, puede causar **alto acoplamiento** si no se maneja bien.
 *
 * 📌 **Ejemplo de uso:**
 * En una aplicación, un Singleton puede ser usado para manejar **una única conexión
 * a la base de datos**, evitando múltiples instancias innecesarias.
 *
 * 🔗 Más información: [Refactoring Guru - Singleton](https://refactoring.guru/es/design-patterns/singleton)
 */

fun main() {
    val config = ConfigManager()
    config.setConfig("apiURL","http://localhost:3000/api")
    config.setConfig("timeout","5000")
    config.setConfig("apikey","ABC123")

    println(config.getConfig("apikey"))
    println(config.getConfig("timeout"))
    println(config.getConfig("apiURL"))
}