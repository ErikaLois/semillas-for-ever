package ar.edu.unahur.obj2.semillas


abstract class Plantas( val anioSemilla: Int , var altura: Double){
    fun horasDeSol()=7

    fun esFuerte()= horasDeSol() >= 9


    open fun daSemillas()= esFuerte()

    abstract fun horasDeSol(altura: Int): Int
}

open class Menta( anioSemilla:Int, altura:Double):Plantas(anioSemilla, altura) {
    fun espacio()= altura + 1
    override fun horasDeSol(altura: Int): Int {
        TODO("Not yet implemented")
    }

    override fun daSemillas()= altura >0.4

}

open class Soja(anioSemilla:Int, altura:Double): Plantas(anioSemilla, altura) {
    override fun horasDeSol(altura: Int): Int{
        var horas=0
        if(altura < 0.5 ){
            horas= 6
        }
        else if(  0.5 > altura <1.0 ){
            horas =8
        }
        else {
            horas= 12
        }
        return horas
    }

    override fun daSemillas()= anioSemilla >= 2007 and 0.75.toInt() > altura < 0.9

}

private operator fun Boolean.compareTo(d: Double) {

}

private infix fun Double.and(altura: Int): Byte {

}

class Quinoa(anioSemilla:Int, altura:Double, val espacio: Int): Plantas(anioSemilla, altura){
    override fun horasDeSol(altura: Int): Int{
        var horas=0
        if(espacio < 0.3 ){
            horas= 10
        }
        else {
            horas =7
        }
        return horas
    }

    override fun daSemillas()= 2001 >= anioSemilla <= 2008


}

private operator fun Boolean.compareTo(i: Int): Int {

}

/*
class  SojaTransgenica: Soja(){


}


class Peperina: Menta(){

}*/