package ar.edu.unahur.obj2.semillas

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

import io.kotest.matchers.shouldHave
import kotlin.math.round

class ParcelasTests: DescribeSpec ({
    describe("Se crean parcelas") {
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

        it("Se prueban los atributos ancho, largo, horasDeSol y plantas") {
            parcela1.ancho.shouldBe(20.0)
            parcela2.ancho.shouldBe(1.0)
            parcela1.largo.shouldBe(1.0)
            parcela2.largo.shouldBe(20.0)
            parcela1.horasDeSol.shouldBe(10)
            parcela2.horasDeSol.shouldBe(6)
            parcela1.plantas.shouldContainExactly(menta1, menta2, menta1)
            parcela2.plantas.shouldContainExactly(menta2,  menta2, soja1)
        }

        it("La superficie de la parcela1 es 20m2") {
            parcela1.superficie().shouldBe(20.0)
            parcela2.superficie().shouldBe(20.0)
        }

        it("La parcela1 tolera una cantidad máxima de 4 plantas") {
            parcela1.maximoDePlantas().shouldBe(4)
            parcela2.maximoDePlantas().shouldBe(26)
            parcela5.maximoDePlantas().shouldBe(1)
        }

        it("La parcela1 tiene complicaciones") {
            parcela1.tieneComplicaciones().shouldBeTrue()
            parcela2.tieneComplicaciones().shouldBeFalse()
            parcela3.tieneComplicaciones().shouldBeFalse()
            parcela4.tieneComplicaciones().shouldBeTrue()
        }

        it("Plantar una nueva planta sin que arroje error") {
            parcela1.plantar(soja1)
            parcela1.plantas.shouldContainExactly(menta1, menta2, menta1, soja1)
            parcela2.plantar(soja1)
            parcela2.plantas.shouldContainExactly(menta2,  menta2, soja1, soja1)
        }

        it("Plantar una nueva plata y que arroje un error") {
            shouldThrowAny { parcela1.plantar(menta1) }
        }

        it("Parcelas ideales para cada planta") {
            menta1.parcelaIdeal(parcela1).shouldBeTrue()
            peperina3.parcelaIdeal(parcela1).shouldBeTrue()
            quinoa1.parcelaIdeal(parcela1).shouldBeTrue()
            soja1.parcelaIdeal(parcela3).shouldBeTrue()
            sojaTrans1.parcelaIdeal(parcela3).shouldBeTrue()
        }

        it("Parcelas que no son ideales para cada planta") {
            menta1.parcelaIdeal(parcela3).shouldBeFalse()
            peperina3.parcelaIdeal(parcela3).shouldBeFalse()
            quinoa1.parcelaIdeal(parcela3).shouldBeFalse()
            soja1.parcelaIdeal(parcela1).shouldBeFalse()
            sojaTrans1.parcelaIdeal(parcela1).shouldBeFalse()
        }

        it("Parcelas ecológicas que se asocian bien para cada planta"){
            parcela6.seAsocianBien(menta1).shouldBeTrue()
            parcela6.seAsocianBien(peperina3).shouldBeTrue()
            parcela5.seAsocianBien(quinoa1).shouldBeTrue()
            parcela3.seAsocianBien(soja1).shouldBeTrue()
            parcela5.seAsocianBien(sojaTrans1).shouldBeTrue()
        }

        it("Parcelas ecológicas que no se asocian bien para cada planta"){
            parcela3.seAsocianBien(menta1).shouldBeFalse()
            parcela3.seAsocianBien(peperina3).shouldBeFalse()
            parcela3.seAsocianBien(quinoa1).shouldBeFalse()
            parcela1.seAsocianBien(soja1).shouldBeFalse()
            parcela1.seAsocianBien(sojaTrans1).shouldBeFalse()
        }





    }

})