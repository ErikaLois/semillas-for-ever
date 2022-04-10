package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe


class semillaMentaTest: DescribeSpec({
    describe("Creación de mentas") {
        //una menta de 1 metro, debería dar semillas y ocupar un espacio de 2 metros cuadrados.
        //una menta de solo 0.3 metros, no debería dar semillas y ocuparía 1.3 metros cuadrados de espacio.
        val menta1 = Menta(2000, 1.0)
        val menta2 = Menta(2015, 0.3)

        it("Se comprueban los atributos altura y año") {
            menta1.altura.shouldBe(1.0)
            menta2.altura.shouldBe(0.3)
            menta1.anioSemilla.shouldBe(2000)
            menta2.anioSemilla.shouldBe(2015)
        }

        it("Se comprueba si las mentas dan semillas") {
            menta1.daSemillas().shouldBeTrue()
            menta2.daSemillas().shouldBeFalse()
        }

        it("Se comprueba si las mentas son fuertes") {
            menta1.esFuerte().shouldBeFalse()
            menta2.esFuerte().shouldBeFalse()
        }

        it("Se comprueban los espacios") {
            menta1.espacio().shouldBe(2.0)
            menta2.espacio().shouldBe(1.3)
        }
    }

})


class semillaSojaTest: DescribeSpec({

    describe("Creación planta soja") {
        val soja = Soja(2009, 0.6)

        it("probamos los atributos altura  y anioSemilla") {
            soja.altura.shouldBe(0.6)
            soja.anioSemilla.shouldBe(2009)
        }

        it("verificar si da semillas") {
            soja.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            soja.espacio().shouldBe(0.3)
        }

    }

})



class SemillaQuinoaTest: DescribeSpec ({
    describe("Creación de la planta de quinoa") {
        val quinoa1 = Quinoa(2010, 1.5, 0.2)
        val quinoa2 = Quinoa(2006, 0.8, 0.9)

        it("Se comprueban los atributos altura y año") {
            quinoa1.altura.shouldBe(1.5)
            quinoa2.altura.shouldBe(0.8)
            quinoa1.anioSemilla.shouldBe(2010)
            quinoa2.anioSemilla.shouldBe(2006)
        }

        it("Se comprueba si las quinoas dan semillas") {
            quinoa1.daSemillas().shouldBeTrue()
            quinoa2.daSemillas().shouldBeTrue()
        }

        it("Se comprueba si las quinoas son fuertes") {
            quinoa1.esFuerte().shouldBeTrue()
            quinoa2.esFuerte().shouldBeFalse()
        }

        it("Se comprueban los espacios") {
            quinoa1.espacio().shouldBe(0.2)
            quinoa2.espacio().shouldBe(0.9)
        }
    }
})

class SemillaPeperinaTest: DescribeSpec ({
    val peperina1 = Peperina(2008, 1.2)
    val peperina2 = Peperina(2004, 0.7)

    it("Se comprueban los atributos altura y año") {
        peperina1.altura.shouldBe(1.2)
        peperina2.altura.shouldBe(0.7)
        peperina1.anioSemilla.shouldBe(2008)
        peperina2.anioSemilla.shouldBe(2004)
    }

    it("Se comprueba si las quinoas dan semillas") {
        peperina1.daSemillas().shouldBeTrue()
        peperina2.daSemillas().shouldBeTrue()
    }

    it("Se comprueba si las quinoas son fuertes") {
        peperina1.esFuerte().shouldBeFalse()
        peperina2.esFuerte().shouldBeFalse()
    }

    it("Se comprueban los espacios") {
        peperina1.espacio().shouldBe(4.4)
        peperina2.espacio().shouldBe(3.4)
    }
})

class SojaTransgenicaTest: DescribeSpec({
    describe( "creacion de soja transgenica"){
        val sojaTrans1= SojaTransgenica(2009, 0.5)

        it("probamos los atributos altura  y anioSemilla") {
            sojaTrans1.altura.shouldBe(0.5)
            sojaTrans1.anioSemilla.shouldBe(2009)
        }

        it("verificar si da semillas") {
            sojaTrans1.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            sojaTrans1.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            sojaTrans1.espacio().shouldBe(0.25)
        }

}

})



