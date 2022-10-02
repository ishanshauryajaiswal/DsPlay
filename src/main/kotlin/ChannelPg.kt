import javafx.application.Application.launch
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class ChannelPg {

    private val sharedChannel = Channel<Int>(Channel.BUFFERED)

    fun main() = runBlocking {
        launch{
            for (i in 1..5) {
                delay(1000)
                sharedChannel.send(i)
                println("sharedChannel.send($i)")
            }
        }
        getReceiverChannel().consumeEach {
            println("sharedChannel.received($it)")
        }
        println("finish hurray")
    }


    fun getReceiverChannel(): ReceiveChannel<Int> = sharedChannel
}