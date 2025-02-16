package creationals.singleton

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
object DragonBalls {
    private var instance: DragonBalls? = null
    private var ballsCollected: Int = 0

    fun getInstance(): DragonBalls {
        if (instance == null) {
            instance = DragonBalls
            println("Las esferas del dragon han sido creadas")
        }
        return instance as DragonBalls
    }

    fun collectBalls(){
        if (ballsCollected<7){
            ballsCollected++
            println("Esfera del dragon recolectada.\nTotal de esferas recolectadas $ballsCollected")
            return
        }
        println("Ya has recolectado todas las esferas del dragon, ya puedes invocar a Shen-Long")
    }

    fun `summon_Shen-Long`(){
        if (ballsCollected==7){
            println("Sheng-Long ha sido invicado, Pide un deseo")
            ballsCollected=0
            return
        }
        println("Aún faltan ${7-ballsCollected} esferas del dragon")
    }
}

fun main() {
    val gokuCollectDragonBalls =DragonBalls.getInstance()
    println()
    gokuCollectDragonBalls.collectBalls()
    gokuCollectDragonBalls.collectBalls()
    gokuCollectDragonBalls.collectBalls()
    gokuCollectDragonBalls.`summon_Shen-Long`()
    println()
    val vegetaCollectDragonBalls=DragonBalls.getInstance()
    vegetaCollectDragonBalls.collectBalls()
    vegetaCollectDragonBalls.collectBalls()
    vegetaCollectDragonBalls.collectBalls()
    vegetaCollectDragonBalls.`summon_Shen-Long`()
    println()
    val milkCollectDragonBall= DragonBalls.getInstance()
    milkCollectDragonBall.collectBalls()
    milkCollectDragonBall.collectBalls()
    //milkCollectDragonBall.`summon_Shen-Long`()
    val numero18 = DragonBalls.getInstance()
    numero18.`summon_Shen-Long`()
    vegetaCollectDragonBalls.`summon_Shen-Long`()


}

