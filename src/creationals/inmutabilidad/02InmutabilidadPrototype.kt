package creationals.inmutabilidad

/**
1.	Completen el método copyWith en la clase Player para que permita
crear una copia con cambios en name, score o level.

2.	Usen el código cliente para probar el funcionamiento de copyWith,
haciendo cambios en el puntaje, nivel y nombre del jugador.
 */
interface PlayerProps {
    val name: String?
    val score: Int?
    val level: Int?
}

data class PlayerData(override val name: String? = null,
                      override val score: Int? = null,
                      override val level: Int? = null):PlayerProps

data class Player(val playerData:PlayerData){
    fun copyWith( playerProps:PlayerProps):Player{
        return Player(
            (playerProps as? PlayerData)?.copy(
                name = playerProps.name ?: playerData.name,
                score = playerProps.score ?: playerData.score,
                level = playerProps.level ?: playerData.level
            ) ?: playerData)
    }
    fun showData(){
        println()
        println("..............................................")
        println()
        println("Player Data:\nName:${playerData.name}\nScore:${playerData.score}\nLevel:${playerData.level}")
    }
}

fun initializationPrototypeExample(){
    var player=Player(PlayerData("Cruz",34,1))
    player.showData()
    player = player.copyWith(PlayerData(level = 5))
    player.showData()
    player = player.copyWith(PlayerData(name = "Antonio"))
    player.showData()
    player = player.copyWith(PlayerData(score = 101010, level =99 ))
    player.showData()
}
fun main(){
    initializationPrototypeExample()
}