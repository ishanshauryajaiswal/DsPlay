import `xpert-array`.ApartmentHunting
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainKotlin {

    fun getPublisherFlow() = flow<Int>{
        for(i in 0..4){
            delay(2000)
            emit(i)
        }
    }

    fun main() = runBlocking<Unit> {
        val channel = Channel<Int>()

        launch {
            for (i in 1..5) {
                delay(1000)
                channel.send(i)
            }
            //channel.close()
        }

        /*for (i in channel) {
            println("received: $i+1")
        }*/

        channel.consumeAsFlow().collect {
            println("received: $it")
        }
    }

    fun gson(){
        val jsonString = "['Alex','Brian','Charles','Alex']"
        print(Gson().fromJson(jsonString, ConsentWhitelistedApiSet::class.java))
        print("")
    }

}
class ConsentWhitelistedApiSet: HashSet<String>()

data class Banks(
    @SerializedName("id") var id: String)