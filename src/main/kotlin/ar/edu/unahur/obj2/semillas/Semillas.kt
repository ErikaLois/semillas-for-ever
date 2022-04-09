package ar.edu.unahur.obj2.semillas


abstract class Plantas( val anioSemilla: Int , var altura: Double){
    fun horasDeSol()=7

    fun esFuerte()= horasDeSol() >= 9


    open fun daSemillas()= esFuerte()

    abstract fun horasDeSol(altura: Int): Int
}

open class Menta( anioSemilla:Int, altura:Double):Plantas(anioSemilla, altura) {
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


/*
Agregar al modelo la soja transgénica y la peperina, que son similares a la soja y a la menta respectivamente, pero con algunas diferencias.

La soja transgénica nunca da nuevas semillas, porque las empresas que las comercializan las someten adrede a un proceso de esterilización (que les asegura no perder nunca a su clientes).
Ojo: la consulta siempre tiene que dar falso, incluso si se cumple la condición general.

La peperina se esparce más rápido que la menta y por eso el espacio que ocupa es el doble del que ocuparía una planta de menta de las mismas características.
 */


class  SojaTransgenica: Soja(){

    override fun daSemillas() = false
}


class Peperina: Menta(){

    override fun espacio() = super.espacio() * 2
}