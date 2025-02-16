package creationals.inmutabilidad

/**
 * 🚀 **Inmutabilidad con Copia**
 *
 * Aunque la **inmutabilidad** es una buena práctica en el desarrollo de software,
 * no siempre es posible aplicarla en todos los casos. En situaciones donde un objeto
 * necesita ser modificado sin alterar su estado original, una solución efectiva es
 * **crear una copia y modificar la copia en su lugar**.
 *
 * ✅ **Ventajas:**
 *   - 🔄 Evita efectos secundarios al modificar objetos.
 *   - 🛠 Facilita la depuración y el mantenimiento del código.
 *   - 📜 Útil para **mantener un historial de estados** en aplicaciones interactivas.
 *   - 🏗️ Compatible con el paradigma funcional y arquitecturas reactivas.
 *
 * 📌 **Ejemplo de uso:**
 * En sistemas donde se requiere **control de versiones**, **deshacer cambios** o **gestión de estados**,
 * este enfoque permite preservar versiones previas sin necesidad de mutar el objeto original.
 */
data class CodeEditorState(
    private val content: String,
    private val cursorPosition: Int,
    private val unsavedChanges: Boolean) {
    fun displayState(){
        println("Estado del editor")
        println("Content:$content\nCursor position:$cursorPosition\nUnsaved changes:$unsavedChanges\n")
    }
    fun copyWith(
        content: String? = null,
        cursorPosition: Int? = null,
        unsavedChanges: Boolean? = null
    ):CodeEditorState{
        return this.copy(
            content = content ?: this.content,
            cursorPosition = cursorPosition ?: this.cursorPosition,
            unsavedChanges = unsavedChanges ?: this.unsavedChanges)
    }
}
class CodeEditorHistory(){
    var history:ArrayList<CodeEditorState> = ArrayList()
    private var currentIndex = -1

    fun save(state: CodeEditorState) {
        if (currentIndex < history.size - 1) {
            val newHistory = history.subList(0, currentIndex + 1).toList() // 🔥 Clonamos la sublista
            history.clear()
            history.addAll(newHistory)  // ✅ Ahora usamos una copia en lugar de una vista
        }

        history.add(state)
        currentIndex++  // 🚀 También corregimos el incremento incorrecto
    }

    fun unDo():CodeEditorState?{
        if (this.currentIndex>0){
            this.currentIndex--
            return this.history[currentIndex]
        }else return null
    }
    fun readDo(): CodeEditorState? {
        if (currentIndex<history.size){
            currentIndex++
            return this.history[this.currentIndex]
        }else return null

    }


}
fun initializationPrototype(){
    var codeEditorHystory=CodeEditorHistory()
    var codeEditorState=CodeEditorState("println(\"Hola mundo\")",2,false)

    codeEditorHystory.save(codeEditorState)
    println("Estado inicial:")
    println(codeEditorState.displayState())

    codeEditorState = codeEditorState.copyWith(content = "println(\"Bye mundo\")", cursorPosition = 3, unsavedChanges = false)
    codeEditorHystory.save(codeEditorState)

    println("Despues del cambio:")
    println(codeEditorState.displayState())

    codeEditorState= codeEditorState.copyWith(cursorPosition = 5)
    codeEditorHystory.save(codeEditorState)
    println("Ultimo cambio:")
    println(codeEditorState.displayState())
    println("Despues del UnDo:")
    codeEditorState = codeEditorHystory.unDo()!!
    println(codeEditorState.displayState())
    println("Despues del ReDo:")
    codeEditorState = codeEditorHystory.readDo()!!
    println(codeEditorState.displayState())

}
fun main(){
    initializationPrototype()
}

