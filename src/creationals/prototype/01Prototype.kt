package creationals.prototype
/**
 * 🔄 **Patrón Prototype** 🔄
 *
 * El patrón de diseño **Prototype** es un patrón creacional que permite **copiar objetos existentes**
 * sin hacer que el código dependa de sus clases concretas. Esto se logra mediante la clonación de instancias,
 * evitando la necesidad de crear nuevos objetos desde cero.
 *
 * ✅ **Beneficios:**
 *   - 🚀 Permite la creación eficiente de objetos sin depender de su implementación específica.
 *   - 🔁 Evita la sobrecarga de instanciación cuando los objetos son costosos de crear.
 *   - 🔄 Facilita la modificación de instancias sin afectar los objetos originales.
 *
 * 📄 **Caso de uso en este proyecto:**
 *   - Se utiliza este patrón para duplicar objetos complejos, como documentos con **contenido, título y autor**,
 *     asegurando que las copias sean independientes del original.
 *
 * 📌 Más información: [Refactoring Guru - Prototype](https://refactoring.guru/es/design-patterns/prototype)
 */

data class Document(var title: String,
               private var author: String,
               var content: String){
    fun clone():Document{
        return Document(this.title,this.author,this.content)
    }
     fun displayInfo(){
        println("title = $title\nauthor = $author\ncontent = $content\n")
    }
}


fun initialization(){
    val document1=Document("Cotizacion","$500","Mario")
    println("document1 $document1")
    document1.displayInfo()
    val document2 = document1.copy(title = "Nueva Cotización")
    println("document2 $document2")
    document2.displayInfo()
    val document3 = document1.clone()
    document3.title = "Nueva Cotización"
    println("document3 $document3")
    document3.displayInfo()
}
fun main(){
    initialization()
}
