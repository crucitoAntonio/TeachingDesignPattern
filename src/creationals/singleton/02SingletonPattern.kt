package creationals.singleton

import java.util.Stack

/**
 * 🔄 **Patrón Singleton**
 *
 * El **Singleton** es un patrón de diseño creacional que **garantiza que una clase
 * tenga una única instancia** y proporciona un **punto de acceso global** a ella.
 *
 * ✅ **¿Cuándo es útil?**
 *   - Cuando necesitas **una única instancia** en toda la aplicación.
 *   - Para manejar **conexiones a bases de datos**, **configuraciones globales**,
 *     **gestión de logs** o **controladores de eventos**.
 *
 * 🏗 **Principales ventajas:**
 *   - 🌍 Proporciona un **punto de acceso global** a la instancia.
 *   - 🚀 Evita la creación innecesaria de múltiples objetos.
 *   - 🛡 Previene inconsistencias al compartir datos en la aplicación.
 *
 * 📌 **Ejemplo de uso:**
 * Se puede aplicar para manejar una **única conexión a la base de datos** en una app.
 *
 * 🔗 Más información: [Refactoring Guru - Singleton](https://refactoring.guru/es/design-patterns/singleton)
 */
object DatabaseCollection {
    private var instance: DatabaseCollection? = null
    private val data = mutableMapOf<Int, MutableMap<String, Any>>()

    fun dataBaseStatus():Boolean{
        if (instance == null){
            println("Debes inicializar tu base de datos")
        }
        return instance == null
    }
    fun connectDataBase(): DatabaseCollection {
        if (instance == null) {
            instance = DatabaseCollection
            println("Base de datos CREADA")
        } else
            println("Base de datos YA EXISTENTE")
        return instance as DatabaseCollection
    }

    fun disconnectDataBase() {
        if (instance != null){
            instance = null
            println("Base de datos APAGADA")
        }else{
            println("Base de datos DORMIDA")
        }
    }


    fun insert(key: Int, value: Map<String, Any>) {
        if (dataBaseStatus()) return
        data[key] = value.toMutableMap() // ✅ Convertimos a MutableMap para permitir modificaciones
        println("🟢 Insertado/Actualizado: $key -> $value")
    }

    fun get(key: Int): Map<String, Any>? {
        if (dataBaseStatus()) return null
        return data[key]?.also { println("🔍 Encontrado: $key -> $it") }
            ?: println("⚠️ No encontrado: $key").let { null }
    }

    fun delete(key: Int) {
        if (dataBaseStatus()) return
        if (data.remove(key) != null) {
            println("🗑 Eliminado: $key")
        } else {
            println("⚠️ No encontrado: $key")
        }
    }

    fun update(key: Int, updates: Map<String, Any>) {
        if (dataBaseStatus()) return
        data[key]?.let { record ->  // ✅ Ahora `record` es un `MutableMap<String, Any>`
            updates.forEach { (field, value) ->
                record[field] = value // ✅ Ahora sí podemos modificar los valores individualmente
            }
            println("✏️ Modificado: $key -> $record")
        } ?: println("⚠️ No encontrado para modificar: $key")
    }

    fun getAll(): Map<Int, Map<String, Any>> {
        if (dataBaseStatus()) return mutableMapOf<Int, MutableMap<String, Any>>()
        println("📜 Todos los registros: $data")
        return data
    }

}

fun main(){
    val AntonioComputer=DatabaseCollection.connectDataBase()
    AntonioComputer.insert(key = 0, value = hashMapOf("Nombre" to "Antonio", "Edad" to 27, "email" to "mailito.com.mx"))
    AntonioComputer.getAll()
    val MarioComputer=DatabaseCollection.connectDataBase()
    MarioComputer.insert(key = 1, value = hashMapOf("Nombre" to "Mario", "Edad" to 40, "email" to "mario@mailito.com.mx"))
    MarioComputer.insert(key = 2, value = hashMapOf("Nombre" to "Juana", "Edad" to 23, "email" to "juana@mailito.com.mx"))
    MarioComputer.getAll()
    AntonioComputer.update(key = 0, updates = hashMapOf("Nombre" to "Antonio", "Edad" to 25, "email" to "antonio@mailito.com.mx"))
    MarioComputer.insert(key = 3, value = hashMapOf("Nombre" to "Marcos", "Edad" to 10, "email" to "marcos@mailito.com.mx"))
    AntonioComputer.getAll()
    MarioComputer.delete(3)
    MarioComputer.getAll()
    val juana=DatabaseCollection.connectDataBase()
    juana.disconnectDataBase()
    juana.getAll()



}