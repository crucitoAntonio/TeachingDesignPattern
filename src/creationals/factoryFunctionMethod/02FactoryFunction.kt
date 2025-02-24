package creationals.factoryFunctionMethod

import java.util.Calendar
import java.util.Date

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
// [INFO:2025-10-21:07] Aplicación iniciada correctamente.
// [WARNING:2025-10-21:07] El uso de memoria está alto.
// [ERROR:2025-10-21:07] Error de conexión a la base de datos.
data class DATA_ENUM(
    var INFO: String ="INFO",
    var WARNING:String ="WARNING",
    var ERROR:String ="ERROR"
        )

fun getDetailAlert(data: String):(String)->Unit{
    var message:String =
        when(data){
            DATA_ENUM().INFO -> {"[${DATA_ENUM().INFO}: ${getDate()}]"}
            DATA_ENUM().WARNING -> {"[${DATA_ENUM().WARNING}: ${getDate()}]"}
            DATA_ENUM().ERROR -> {"[${DATA_ENUM().ERROR}: ${getDate()}]"}
            else -> {"[${DATA_ENUM().ERROR}: ${getDate()}]"}
        }
    return {text :String->
       println("$message $text")
    }
}
fun getDate():String{
    return "${Calendar.getInstance().get(Calendar.YEAR)}-${Calendar.getInstance().get(Calendar.MONTH)+1}-${Calendar.getInstance().get(Calendar.DAY_OF_MONTH)}"
}
fun main(){
    var error = getDetailAlert(DATA_ENUM().ERROR)
    var info = getDetailAlert(DATA_ENUM().INFO)
    var warning = getDetailAlert(DATA_ENUM().WARNING)
    (info("Aplicación iniciada correctamente"))
    (warning("El uso de memoria está alto."))
    (error("Error de conexión a la base de datos."))
}