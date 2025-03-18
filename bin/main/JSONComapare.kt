import com.google.common.collect.Maps
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JSONComapare{
    fun compareJSON(leftJSON: String?, rightJSON: String?) {
        val gson = Gson()
        val type = object : TypeToken<Map<String?, Any?>?>() {}.type
        val leftMap = gson.fromJson<Map<String, Any>>(leftJSON, type)
        val rightMap = gson.fromJson<Map<String, Any>>(rightJSON, type)
        println(Maps.difference(leftMap, rightMap))
    }
}