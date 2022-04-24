package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.maps.beEmpty
import io.kotest.matchers.shouldBe

class intaTest: DescribeSpec({
    describe("test INTA") {
        val menta1 = Menta(2000, 1.0)
        val menta2 = Menta(2015, 0.3)
        val soja1 = Soja(2009, 1.5)
        val soja2 = Soja(2000, 2.00)
        val soja3 = Soja(2002, 1.6)
        val soja4 = Soja(2020, 1.4)
        val soja5 = Soja(2005, 1.8)
        val quinoa1 = Quinoa(2010, 1.5, 0.2)
        val quinoa2 = Quinoa(2015, 0.8, 0.5)
        val peperina3 = Peperina(2000, 1.0)
        val peperina2 = Peperina(2005, 0.5)
        val sojaTrans1 = SojaTransgenica(2009, 0.5)
        val parcela1 = ParcelasEcologicas(20.0, 1.0, 10, mutableListOf(menta1, menta2, menta1))
        val parcela2 = Parcela(1.0, 20.0, 6, mutableListOf(menta2, menta2, soja1))
        val parcela3 = ParcelasEcologicas(3.00, 2.00, 12, mutableListOf(soja2))
        val parcela4 = ParcelasEcologicas(20.0, 1.0, 8, mutableListOf(menta1, peperina3, quinoa1, soja1))
        val parcela5 = ParcelasEcologicas(2.5, 2.0, 8, mutableListOf(sojaTrans1))
        val parcela6 = ParcelasEcologicas(10.0, 5.0, 7, mutableListOf(menta2, menta2, soja1))
        val parcela7 = ParcelasIndustriales(5.0, 15.0, 10, mutableListOf(quinoa2, quinoa1))
        val parcela8 = ParcelasIndustriales(10.0, 10.0, 10, mutableListOf(quinoa1))
        val parcela9 = ParcelasEcologicas(8.0, 4.0, 12, mutableListOf(menta1, peperina3, menta1, soja1, quinoa1))
        val parcela10 = ParcelasEcologicas(10.0, 2.0, 12, mutableListOf(soja1, soja2, soja3, soja4, soja5))
        val parcela11 = ParcelasEcologicas(7.0, 4.0, 5, mutableListOf(menta1, peperina3, menta2, quinoa1, soja1))
        val parcela12 =
            ParcelasEcologicas(17.0, 1.0, 6, mutableListOf(menta1, peperina3, menta2, quinoa1, peperina2, soja1, soja2))
        val parcela13 =
            ParcelasEcologicas(2.0, 4.0, 4, mutableListOf(menta1, peperina3, menta2, quinoa1, peperina2, menta1))
        val parcela14 = ParcelasEcologicas(10.0, 5.0, 12, mutableListOf(soja1, soja2, soja3, soja4, soja5))

        val inta1 = Inta(mutableListOf(parcela1, parcela2))
        val inta2 = Inta(mutableListOf(parcela3, parcela4, parcela5))
        val inta3 = Inta(mutableListOf(parcela2, parcela6, parcela5))
        val inta4 = Inta(mutableListOf(parcela10, parcela9, parcela8, parcela7, parcela5))
        val inta5 = Inta(mutableListOf(parcela9, parcela11, parcela10, parcela4))
        val inta6 = Inta(mutableListOf(parcela11, parcela12, parcela13, parcela14))

        it("pomedio de plantas segun INTA") {
            inta1.promedioDePlantasPorParcela().shouldBe(3)
            inta2.promedioDePlantasPorParcela().shouldBe(2)
            inta3.promedioDePlantasPorParcela().shouldBe(2)
        }

        it("La parcela 10 es la más sustentable") {
            inta4.masSustentable().shouldBe(parcela10)
            inta5.masSustentable().shouldBe(parcela10)
        }

        it("La parcela 13 es la más sustentable") {
            inta6.masSustentable().shouldBe(parcela13)
        }

        it("No tiene parcelas sustentables") {
            inta3.masSustentable().shouldBe(null)
        }
    }

})
