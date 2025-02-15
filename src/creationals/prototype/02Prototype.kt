package creationals.prototype

/**
 * ! Patrón Prototype:

 * Es un patrón de diseño creacional que nos permite copiar objetos existentes sin hacer
 * que el código dependa de sus clases.
 *
 * * Es útil cuando queremos duplicar el contenido,
 * * el título y el autor de un documento, por ejemplo o cualquier objeto complejo.
 *
 * https://refactoring.guru/es/design-patterns/prototype
 */
data class Pokemon(var name:String, var type:String, var level:String, var atacks:ArrayList<String>){
    fun clone():Pokemon{
        //return Pokemon(this.name,this.type,this.level,java.util.ArrayList(this.atacks))
        return this.copy(atacks=java.util.ArrayList(this.atacks))
    }
    fun showData(){
        println("Nombre: $name\nType: $type\nLevel: $level\nAtacks: ${atacks}\n")
    }
}

fun initializationExample(){
    val charmander=Pokemon("charmander","fuego","1", arrayListOf("Llamarada","Arañazo"))
    println(charmander.toString())
    println(charmander.showData())
    val charmeleon = charmander.clone()
    charmeleon.name ="charmeleon"
    charmeleon.level ="16"
    charmeleon.atacks.add("Lanzallamas")
    println(charmeleon.toString())
    println(charmeleon.showData())
    println("----------------------")
    println(charmander.toString())
    println(charmander.showData())

}

fun main(){
    initializationExample()
}