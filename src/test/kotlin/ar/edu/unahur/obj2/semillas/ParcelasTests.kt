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
        val parcela1 = Parcela(20.0,  1.0, 10, mutableListOf(menta1, menta2, menta1))
        val parcela2 = Parcela(1.0, 20.0, 6, mutableListOf(menta2, menta2, soja1))


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
        }

        it("La parcela1 tiene complicaciones") {
            parcela1.tieneComplicaciones().shouldBeTrue()
            parcela2.tieneComplicaciones().shouldBeFalse()
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
    }

})