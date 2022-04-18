package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe


class semillaMentaTest: DescribeSpec({
    describe("Creación de mentas") {
        
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
        val soja1 = Soja(2009, 0.6) // no da semilla
        val soja2 = Soja(2008,0.78) // da semilla
        val soja3 = Soja(2005, 0.80) // no da semilla
        val soja4 = Soja(2010, 1.0)  // no da semillas
        val soja5 = Soja(2010, 1.5)  // no da semillas

        it("Horas de sol"){
            soja1.horasDeSol().shouldBe(8)
            soja2.horasDeSol().shouldBe(8)
            soja3.horasDeSol().shouldBe(8)
            soja4.horasDeSol().shouldBe(8)
            soja5.horasDeSol().shouldBe(12)

        }

        it("verificar si da semillas") {
            soja1.daSemillas().shouldBeFalse()
            soja2.daSemillas().shouldBeTrue()
            soja3.daSemillas().shouldBeFalse()
            soja4.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            soja1.esFuerte().shouldBeFalse()
            soja2.esFuerte().shouldBeFalse()
            soja3.esFuerte().shouldBeFalse()
            soja4.esFuerte().shouldBeFalse()
            soja5.esFuerte().shouldBeTrue()

        }

        it("espacio") {
            soja1.espacio().shouldBe(0.3)
            soja2.espacio().shouldBe(0.39)
            soja3.espacio().shouldBe(0.4)
            soja4.espacio().shouldBe(0.5)
            soja5.espacio().shouldBe(0.75)
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
    val peperina3 = Peperina(2000, 1.0)
    val peperina4 = Peperina(2015, 0.3)

    it("Se comprueban los atributos altura y año") {
        peperina1.altura.shouldBe(1.2)
        peperina2.altura.shouldBe(0.7)
        peperina1.anioSemilla.shouldBe(2008)
        peperina2.anioSemilla.shouldBe(2004)
    }

    it("Se comprueba si las quinoas dan semillas") {
        peperina1.daSemillas().shouldBeTrue()
        peperina2.daSemillas().shouldBeTrue()
        peperina3.daSemillas().shouldBeTrue()
        peperina4.daSemillas().shouldBeFalse()
    }

    it("Se comprueba si las quinoas son fuertes") {
        peperina1.esFuerte().shouldBeFalse()
        peperina2.esFuerte().shouldBeFalse()
        peperina3.esFuerte().shouldBeFalse()
        peperina4.esFuerte().shouldBeFalse()
    }

    it("Se comprueban los espacios") {
        peperina1.espacio().shouldBe(4.4)
        peperina2.espacio().shouldBe(3.4)
        peperina3.espacio().shouldBe(4.0)
        peperina4.espacio().shouldBe(2.6)
    }
})

class SojaTransgenicaTest: DescribeSpec({
    describe( "creacion de soja transgenica"){
        val sojaTrans1= SojaTransgenica(2009, 0.5)
        val sojaTrans2 = SojaTransgenica(2008,0.78) // da semilla

        it("probamos los atributos altura  y anioSemilla") {
            sojaTrans1.altura.shouldBe(0.5)
            sojaTrans1.anioSemilla.shouldBe(2009)
        }

        it("verificar si da semillas") {
            sojaTrans1.daSemillas().shouldBeFalse()
            sojaTrans2.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            sojaTrans1.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            sojaTrans1.espacio().shouldBe(0.25)
        }

}

})



