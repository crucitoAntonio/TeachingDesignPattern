package creationals.abtractFactory

/**
 * 🎭 **Patrón Abstract Factory** 🎭
 *
 * El patrón de diseño **Abstract Factory** permite crear **familias de objetos relacionados**
 * sin especificar sus clases concretas. 🏭 En lugar de instanciar objetos individuales directamente,
 * se define una **fábrica abstracta** que produce un conjunto de objetos relacionados.
 *
 * ✅ **Beneficios:**
 *   - 🔄 Facilita la creación de objetos que deben ser utilizados en conjunto.
 *   - 📦 Promueve la **cohesión** y el principio de **Inversión de Dependencias**.
 *   - 🚀 Mejora la **escalabilidad** y la **flexibilidad** del código.
 *
 * 🍔 **Caso de uso en este proyecto:**
 *   - Se aplica este patrón para modelar la creación de **hamburguesas y bebidas** 🥤,
 *     asegurando que cada combinación de productos pertenezca a una misma familia.
 *
 * 📌 Más información: [Refactoring Guru - Abstract Factory](https://refactoring.guru/es/design-patterns/abstract-factory)
 */

interface Hamburger{
    fun prepare()
}
interface Drink{
    fun pour()
}

class ChickenHamburger():Hamburger{
    override fun prepare() {
        println("Preparing Chiken hamburguer")
    }
}

class BeefHamburger():Hamburger{
    override fun prepare() {
        println("Preparing Beef hamburguer")
    }
}

class Water():Drink{
    override fun pour() {
        println("Pouring a Water glass")
    }
}

class Soda():Drink{
    override fun pour() {
        println("Pouring a coca cola")
    }
}
interface RestaurantFactory{
    fun createHamburger():Hamburger
    fun createDrink():Drink
}
class FastFoodRestaurantFactory():RestaurantFactory{
    override fun createHamburger(): Hamburger {
        return BeefHamburger()
    }

    override fun createDrink(): Drink {
        return Soda()
    }
}
class HealtFoodRestaurantFactory():RestaurantFactory{
    override fun createHamburger(): Hamburger {
        return ChickenHamburger()
    }

    override fun createDrink(): Drink {
        return Water()
    }
}

fun mainMenu(factory: RestaurantFactory) {
    var hamburger = factory.createHamburger()
    var drink = factory.createDrink()
    hamburger.prepare()
    drink.pour()
}
fun main(){
    mainMenu(HealtFoodRestaurantFactory())
    mainMenu(FastFoodRestaurantFactory())
}