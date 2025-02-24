package creationals.singleton

class ConfigManager{
    private var config : MutableMap<String,String> = mutableMapOf()

    fun setConfig(key:String,value:String){
        config[key] = value
        println("\uD83D\uDD27 Configuración establecida: $key -> $value")
    }
    fun getConfig(key:String):String?{
        return config[key]
    }
    fun getAllConfig():MutableMap<String,String>{
        return config.toMutableMap()
    }
}