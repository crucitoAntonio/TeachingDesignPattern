package BuilderPattern

fun main() {
    val oldComputer = BuilderComputer().apply {
        this.setCPU("Intel chip")
        this.setGPU("Nvidia")
        this.setRAM("2GB")
        this.setStorage("8GB")
    }.build()

    System.out.println("The current Computer has the next components\n\n")
    oldComputer.showComputer()
    System.out.println("\n\n")
    var newCOmputer = BuilderComputer().apply {
        this.setCPU("Intel chip")
        this.setGPU("Nvidia")
        this.setRAM("2GB")
    }.build()

    System.out.println("The current Computer has the next components\n\n")
    newCOmputer.showComputer()

    System.out.println("\n\n")
    var normalCOmputer = BuilderComputer().apply {
        this.setCPU("Intel chip")
    }.build()

    System.out.println("The current Computer has the next components\n\n")
    normalCOmputer.showComputer()

}
class Computer() {
    var GPU = "Sin GPU"
    var CPU = "Sin CPU"
    var RAM = "Sin RAM"
    var storage: String? = null

    fun showComputer() {
        System.out.println("GPU --> $GPU")
        System.out.println("CPU --> $CPU")
        System.out.println("RAM --> $RAM")
        System.out.println("storage --> ${storage ?: "Sin storage"}")
    }
}

class BuilderComputer(){
    var computer:Computer
    init {
        computer=Computer()
    }
    fun setGPU(gpu:String):BuilderComputer{
        this.computer.GPU = gpu
        return this
    }
    fun setCPU(cpu:String):BuilderComputer{
        this.computer.CPU = cpu
        return this
    }
    fun setRAM(ram:String):BuilderComputer{
        this.computer.RAM = ram
        return this
    }
    fun setStorage(storage:String):BuilderComputer{
        this.computer.storage = storage
        return this
    }
    fun build():Computer{
        return computer
    }
}