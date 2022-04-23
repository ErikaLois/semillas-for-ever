package ar.edu.unahur.obj2.semillas

class Inta(var parcelas: MutableList<Parcela>) {

    fun plantasTotales()= parcelas.sumBy { p-> p.plantas.size }
    fun promedioDePlantasPorParcela() = this.plantasTotales() / parcelas.size


}