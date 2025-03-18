


fun a(){
    val int = ObjWrap(1)
    println(int.value)
    int.value = 10
    println(int.value)
    swap(int, ObjWrap(2))
}



data class ObjWrap<T>(var value: T)

fun <T> swap(v1: ObjWrap<T>, v2: ObjWrap<T>){
    v1.value = v2.value.also { v2.value = v1.value }
}

