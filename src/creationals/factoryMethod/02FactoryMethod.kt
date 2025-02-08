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
    var chosedOption = ""
    println("Choose a report to Create")
    println("1.- Sales Report")
    println("2.- Medical Report")
    println("3.- Salary Report")
    chosedOption = readlnOrNull()?:""
    var factoryChosed = when(chosedOption){
        "1"->InventoryReport()
        "2"->MedicalCreatingReport()
        "3"->JobReport()
        else ->{
            println("Error choosing report, normal job report creating...")
            JobReport()
        }
    }
    factoryChosed.creatingReport()
}
/**
 * Report*/
interface Report{
    fun createReport()
}
class SalesReport():Report{
    override fun createReport() {
        println("Sales Report Created")
    }
}
class MedicalReport():Report{
    override fun createReport() {
        println("Medica Report Created")
    }
}
class SalaryReport():Report{
    override fun createReport() {
        println("Salary Report Created")
    }
}
/**
 * Factory Report*/
abstract class ReportFactory(){//No sirva para crear una nueva isntancia, sino sea para definir un esqueleto para crear otras clases
     protected abstract fun newReport() : Report
    fun creatingReport(){
        var builtRepor = this.newReport()
        builtRepor.createReport()
    }
}
class InventoryReport():ReportFactory(){
    override fun newReport(): Report {
        return SalesReport()
    }
}
class MedicalCreatingReport():ReportFactory(){
    override fun newReport(): Report {
        return MedicalReport()
    }
}
class JobReport():ReportFactory(){
    override fun newReport(): Report {
        return SalaryReport()
    }
}
