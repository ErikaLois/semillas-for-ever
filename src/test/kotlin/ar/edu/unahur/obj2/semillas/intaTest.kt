package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class intaTest: DescribeSpec({
    describe("test INTA"){
        val menta1 = Menta(2000,1.0)
        val menta2 = Menta(2015, 0.3)
        val soja1 = Soja(2009, 1.5)
        val soja2 = Soja(2000, 2.00)
        val quinoa1 = Quinoa(2010, 1.5, 0.2)
        val peperina3 = Peperina(2000, 1.0)
        val sojaTrans1= SojaTransgenica(2009, 0.5)
        val parcela1 = ParcelasEcologicas(20.0,  1.0, 10, mutableListOf(menta1, menta2, menta1))
        val parcela2 = Parcela(1.0, 20.0, 6, mutableListOf(menta2, menta2, soja1))
        val parcela3 = ParcelasEcologicas(3.00, 2.00, 12, mutableListOf(soja2))
        val parcela4 = ParcelasEcologicas(20.0, 1.0, 8,mutableListOf(menta1,peperina3, quinoa1, soja1))
        val parcela5 = ParcelasEcologicas(2.5, 2.0, 8,mutableListOf(sojaTrans1))
        val parcela6 = ParcelasEcologicas(10.0, 5.0, 7,mutableListOf(menta2, menta2, soja1))

        val inta1= Inta(mutableListOf(parcela1,parcela2))
        val inta2= Inta(mutableListOf(parcela3,parcela4,parcela5))
        val inta3= Inta(mutableListOf(parcela2,parcela6,parcela5))

        it ("pomedio de plantas segun INTA") {
            inta1.promedioDePlantasPorParcela().shouldBe(3)
            inta2.promedioDePlantasPorParcela().shouldBe(2)
            inta3.promedioDePlantasPorParcela().shouldBe(2)
        }
    }



})
