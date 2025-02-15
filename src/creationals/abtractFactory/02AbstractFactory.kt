package creationals.abtractFactory

/**
 * !Instrucciones:
1.Completen las Clases de Productos:
•	ElectricCar debe implementar Vehicle y mostrar el mensaje "Ensamblando un auto eléctrico".
•	GasCar debe implementar Vehicle y mostrar el mensaje "Ensamblando un auto de combustión".
•	ElectricEngine debe implementar Engine y mostrar el mensaje "Arrancando motor eléctrico".
•	GasEngine debe implementar Engine y mostrar el mensaje "Arrancando motor de combustión".

2.	Completen las Clases de Fábricas:
•	ElectricVehicleFactory debe crear un ElectricCar y un ElectricEngine.
•	GasVehicleFactory debe crear un GasCar y un GasEngine.

3. Prueben el Código:
•	Ejecuten el código para asegurarse de que cada fábrica produce el tipo correcto de vehículo y motor.

 */
interface Vehicle{
    fun Ensambling()
}
interface Engine{
    fun Starting()
}
class ElectricCarEnsambling():Vehicle{
    override fun Ensambling() {
        println("Ensamblando un auto eléctrico")
    }
}
class CombustionCarEnsambling():Vehicle{
    override fun Ensambling() {
        println("Ensamblando un auto de combustión")
    }
}
class ElectricalCaStartingr():Engine{
    override fun Starting() {
        println("Starting motor eléctrico")
    }
}
class CombustionCaStartingr():Engine{
    override fun Starting() {
        println("Starting motor de combustión")
    }
}
interface CreatingCarFactory{
    fun CreateCar():Vehicle
    fun CreateEngine():Engine
}
class ElectricVehicleFactory:CreatingCarFactory{
    override fun CreateCar(): Vehicle {
        return ElectricCarEnsambling()
    }
    override fun CreateEngine(): Engine {
        return ElectricalCaStartingr()
    }
}
class CombustionVehicleFactory:CreatingCarFactory{
    override fun CreateCar(): Vehicle {
        return CombustionCarEnsambling()
    }
    override fun CreateEngine(): Engine {
        return CombustionCaStartingr()
    }
}
fun initialization(carFactory:CreatingCarFactory){
    var carType=carFactory.CreateCar()
    var engineType=carFactory.CreateEngine()
    carType.Ensambling()
    engineType.Starting()

}

fun main(){
    println("Electrical Car Chose")
    initialization(ElectricVehicleFactory())
    println("\n\n")
    println("Combustion Car Chose")
    initialization(CombustionVehicleFactory())
}