package ar.edu.unahur.obj2.semillas

class Parcela(val ancho: Double, val largo: Double, val horasDeSol: Int, var plantas: MutableList<Plantas>) {

    fun superficie() = ancho * largo

    fun maximoDePlantas(): Int {

        return if (ancho > largo) {
            (this.superficie() / 5).toInt()
        } else {
            (this.superficie() / 3 + largo).toInt()
        }
    }

    fun tieneComplicaciones() = plantas.any { it.horasDeSol() < horasDeSol }

    fun plantar(planta: Plantas) {
        if (plantas.size == this.maximoDePlantas() || horasDeSol > planta.horasDeSol() + 2 ) {
            throw Exception("No se puede plantar la planta.")
        }
        else {plantas.add(planta)}
    }

}