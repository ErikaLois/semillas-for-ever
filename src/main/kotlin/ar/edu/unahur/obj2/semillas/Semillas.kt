package ar.edu.unahur.obj2.semillas


abstract class Plantas( val anioSemilla: Int , var altura: Double){

    open fun horasDeSol() = 7 //En principio, las plantas toleran 7 horas de sol por día, esto cambia para algunos tipos de planta

    fun esFuerte()= this.horasDeSol() > 9

    abstract fun espacio(): Double

    open fun daSemillas()= this.esFuerte()

    abstract fun parcelaIdeal(parcela: Parcela): Boolean

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
        else if(altura in 0.5..1.0){
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

        return if (this.espacio() < 0.3 ) { 10 }

        else { super.horasDeSol() }
    }

    override fun daSemillas()= super.daSemillas() or(anioSemilla in 2001..2008)

    override fun espacio() = espacio
}

class  SojaTransgenica(anioSemilla: Int, altura: Double): Soja(anioSemilla, altura){

    override fun daSemillas() = false //Esta función siempre debe dar falso.
}


class Peperina(anioSemilla: Int, altura: Double): Menta(anioSemilla, altura){

    override fun espacio() = super.espacio() * 2 //Es del doble de espacio que ocuparía una planta de Menta.
}