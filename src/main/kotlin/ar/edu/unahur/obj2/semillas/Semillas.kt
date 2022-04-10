package ar.edu.unahur.obj2.semillas


abstract class Plantas( val anioSemilla: Int , var altura: Double){

    open fun horasDeSol() = 7 //En principio, las plantas toleran 7 horas de sol por día, esto cambia para algunos tipos de planta

    fun esFuerte()= this.horasDeSol() > 9

    abstract fun espacio(): Double

    open fun daSemillas()= this.esFuerte()

    // abstract fun horasDeSolQueTolera(): Int
}

open class Menta(anioSemilla: Int, altura: Double): Plantas(anioSemilla, altura){

    override fun espacio()= altura + 1

    override fun daSemillas()= altura > 0.4

}

open class Soja(anioSemilla: Int, altura: Double): Plantas(anioSemilla, altura) {

    override fun horasDeSol(): Int{

        return if(altura < 0.5 ){
            6
        }
        else if(  altura > 0.5 && altura < 1.0 ){
            8
        }
        else {
            12
        }
    }

    override fun espacio() = altura / 2

    override fun daSemillas()= super.daSemillas() or(anioSemilla >= 2007 && 0.75 < altura  && altura < 0.9)

}

class Quinoa(anioSemilla: Int, altura: Double, val espacio: Double): Plantas(anioSemilla, altura){

    override fun horasDeSol(): Int{
        return if(this.espacio() < 0.3 ) { 10 }
        else { 7 }
    }

    override fun daSemillas()= 2001 >= anioSemilla && anioSemilla <= 2008

    override fun espacio() = espacio
}

/*
open class Menta( anioSemilla:Int, altura:Double): Plantas(anioSemilla, altura) {
    open fun espacio()= altura + 1
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
*/

class  SojaTransgenica(anioSemilla: Int, altura: Double): Soja(anioSemilla, altura){

    override fun daSemillas() = false //Esta función siempre debe dar falso.
}


class Peperina(anioSemilla: Int, altura: Double): Menta(anioSemilla, altura){

    override fun espacio() = super.espacio() * 2 //Es del doble de espacio que ocuparía una planta de Menta.
}