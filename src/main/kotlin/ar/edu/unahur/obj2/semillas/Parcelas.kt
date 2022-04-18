package ar.edu.unahur.obj2.semillas

open class Parcela(val ancho: Double, val largo: Double, val horasDeSol: Int, var plantas: MutableList<Plantas>) {

    fun superficie() = ancho * largo

    fun maximoDePlantas(): Int {
    //Máximo de plantas que tolera la parcela
        return if (ancho > largo) {
            (this.superficie() / 5).toInt()
        } else {
            (this.superficie() / 3 + largo).toInt()
        }
    }

    fun tieneComplicaciones() = plantas.any { it.horasDeSol() < horasDeSol } //Es así si alguna de sus plantas tolera menos sol del que recibe la parcela.

    fun plantar(planta: Plantas) {
        //Primero chequea que haya lugar y que las horas de sol que recibe la parcela es válida para la planta. Si esto no ocurre, lanza una excepción.
        if (plantas.size == this.maximoDePlantas() || horasDeSol >= planta.horasDeSol() + 2 ) {
            throw Exception("No se puede plantar la planta.")
        }
        else {plantas.add(planta)}
    }





}

class ParcelasEcologicas ( ancho: Double, largo: Double, horasDeSol: Int, plantas: MutableList<Plantas>): Parcela(ancho, largo, horasDeSol,plantas){

    fun seAsocianBien(planta: Plantas)= !this.tieneComplicaciones() && planta.parcelaIdeal(this)

}

class ParcelasIndustriales ( ancho: Double, largo: Double, horasDeSol: Int, plantas: MutableList<Plantas>): Parcela(ancho, largo, horasDeSol,plantas){

    fun seAsocianBien(planta: Plantas)= this.maximoDePlantas()<=2 && planta.esFuerte()

}