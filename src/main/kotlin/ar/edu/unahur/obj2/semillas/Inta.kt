package ar.edu.unahur.obj2.semillas

class Inta(var parcelas: MutableList<Parcela>) {

    fun plantasTotales()= parcelas.sumBy { p-> p.plantas.size }

    fun promedioDePlantasPorParcela() = this.plantasTotales() / parcelas.size

    fun parcelasConMasDe4Plantas() = parcelas.filter { it.cantidadDePlantas() > 4 }

    fun masSustentable() = this.parcelasConMasDe4Plantas().maxByOrNull { it.bienAsociadas() }

}