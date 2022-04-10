package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

class ParcelasTests: DescribeSpec ({
    describe("Se crean parcelas") {
        val menta1 = Menta(1.0, 2000)
        val menta2 = Menta(0.3, 2015)
        val quinoa1 = Quinoa(1.5, 2010)
        val quinoa2 = Quinoa(0.8, 2006)
        val parcela1 = Parcela(20.0,  1.0, 10, (menta1, menta2, menta2) )
        //val parcela2 = Parcela(ancho: 15.0, largo: 2.0, horasDeSol: 7, plantas: [menta1, menta2, menta2])

        it("Se prueban los atributos ancho, largo, horasDeSol y plantas") {
            parcela1.ancho.shouldBe(20.0)
            parcela1.largo.shouldBe(1.0)
            parcela1.horasDeSol.shouldBe(10)
            parcela1.plantas.shouldBe((menta1, menta2, quinoa1))
        }

        it("La superficie de la parcela1 es 20m2") {
            parcela1.superficie().shouldBe(20)
        }

        it("La parcela1 tolera una cantidad máxima de 4 plantas") {
            parcela1.maximoDePlantas().shouldBe(4)
        }

        it("La parcela1 tiene complicaciones") {
            parcela1.tieneComplicaciones().shouldBeTrue()
        }

        it("Plantar una nueva planta y corrobar si funcionó") {
            parcela1.plantar(quinoa2)
            parcela1.plantas.shouldBe([menta1, menta2, quinoa1])
        }
    }

})