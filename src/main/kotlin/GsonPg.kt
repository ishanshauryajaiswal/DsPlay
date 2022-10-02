import JSONComapare.compareJSON
import com.google.gson.Gson
import java.lang.Exception
import java.nio.file.Files
import java.nio.file.Paths


class GsonPg {

    fun main() {
        val gson = Gson()
        val string =
            "{\"pinChangeAcknowledgementHurdleMeta\":{\"messageDetails\":{\"defaultValue\":\"You will be automatically logged out of PhonePe after you change your password, @ Login with new password\",\"configKey\":\"PIN_CHANGE_ACK_HURDLE_MSG\",\"configTag\":\"generalLanguage\"},\"titleDetails\":{\"defaultValue\":\"Confirmation Needed!\",\"configKey\":\"PIN_CHANGE_ACK_HURDLE_TITLE\",\"configTag\":\"generalLanguage\"},\"acceptButtonDetails\":{\"defaultValue\":\"Confirm\",\"configKey\":\"BUTTON_TITLE_CONFIRM\",\"configTag\":\"generalLanguage\"},\"denyButtonDetails\":{\"defaultValue\":\"Cancel\",\"configKey\":\"BUTTON_TITLE_CANCEL\",\"configTag\":\"generalLanguage\"},\"deniable\":true},\"acknowledgementHurdleMeta\":{\"pinChangeAcknowledgementHurdleMeta\":{\"messageDetails\":{\"defaultValue\":\"You will be automatically logged out of PhonePe after you change your password\",\"configKey\":\"PIN_CHANGE_ACK_HURDLE_MSG\",\"configTag\":\"generalLanguage\"},\"titleDetails\":{\"defaultValue\":\"Confirmation!\",\"configKey\":\"PIN_CHANGE_ACK_HURDLE_TITLE\",\"configTag\":\"generalLanguage\"},\"acceptButtonDetails\":{\"defaultValue\":\"Allow\",\"configKey\":\"BUTTON_TITLE_CONFIRM\",\"configTag\":\"generalLanguage\"},\"denyButtonDetails\":{\"defaultValue\":\"Deny\",\"configKey\":\"BUTTON_TITLE_CANCEL\",\"configTag\":\"generalLanguage\"},\"deniable\":true}},\"hurdleKillSwitchEnabled\":true}"
        val map = gson.fromJson(string, OO::class.java)


        val readLeft = String(Files.readAllBytes(Paths.get("src/main/resources/102.json")))
        val readRight = String(Files.readAllBytes(Paths.get("src/main/resources/103.json")))
        compareJSON(readLeft,readRight)

    }

     class OO : HashMap<String, Any>()
}

