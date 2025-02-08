package creationals.factoryMethod
/**
 * 🏭 **Factory Method:**
 *
 * El patrón **Factory Method** es un patrón de diseño creacional que permite
 * crear objetos sin especificar la clase concreta que será instanciada.
 *
 * 🚀 **¿Cómo funciona?**
 * - La creación de objetos se delega a métodos especializados (o subclases),
 *   encapsulando la lógica de construcción.
 *
 * ✅ **¿Cuándo usarlo?**
 * - Cuando una clase no puede anticipar qué clase concreta debe crear.
 * - Cuando queremos que la lógica de creación esté centralizada y sea fácil
 *   de modificar o extender.
 *
 * 📌 **Beneficios:**
 * - Reduce la dependencia directa de clases concretas.
 * - Mejora la flexibilidad y facilita el mantenimiento.
 * - Permite incorporar nuevas clases de objetos sin cambiar el código existente.
 *
 * 🔗 **Referencia:**
 * [Refactoring Guru - Factory Method](https://refactoring.guru/es/design-patterns/factory-method)
 */
fun main(){
    var restaurant:Restaurant
    var opcion = ""
    println("🍔 Bienvenido al restaurante. ¿Qué tipo de hamburguesa desea preparar?")
    println("1. Hamburguesa de Res")
    println("2. Hamburguesa de Pollo")
    println("3. Hamburguesa de Frijol")
    opcion = readlnOrNull() ?:""
    restaurant = when (opcion) {
        "1" -> BeefRestaurant()
        "2" -> ChickenRestaurant()
        "3" -> BeenRestaurant()
        else -> {
            println("❌ Opción inválida. Preparando hamburguesa de pollo por defecto.")
            ChickenRestaurant()
        }
    }
    restaurant.orderHamburger()
}
/**
 * HAMBURGUESAS*/
interface Hamburger{
    fun prepare()
}

class ChickenHamburger():Hamburger{
    override fun prepare() {
        println("Preparando una hamburguesa de POLLO")
    }
}
class BeefHamburger():Hamburger{
    override fun prepare() {
        println("Preparando una hamburguesa de RES")
    }
}
class BeanHamburger():Hamburger{
    override fun prepare() {
        println("Preparando una hamburguesa de FRIJOL")
    }
}
/**
 * RESTAURANTES*/
abstract class Restaurant(){
    abstract fun createHamburger():Hamburger
    fun orderHamburger(){
        var hamburger = this.createHamburger()
        hamburger.prepare()
    }
}

class ChickenRestaurant():Restaurant(){
    override fun createHamburger(): Hamburger {
        return ChickenHamburger()
    }
}
class BeefRestaurant():Restaurant(){
    override fun createHamburger(): Hamburger {
        return BeefHamburger()
    }
}
class BeenRestaurant():Restaurant(){
    override fun createHamburger(): Hamburger {
        return BeanHamburger()
    }
}