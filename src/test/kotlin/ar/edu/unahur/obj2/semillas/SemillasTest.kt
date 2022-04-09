package ar.edu.unahur.obj2.semillas

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.shouldBe

/*
class SemillasTest : DescribeSpec ({
    // hay una clase Planta que tiene por atributos
    // anioSemilla, altura
    describe("Creación de las plantas") {
        val menta = Menta(1.0, 2021)
        val mentita = Menta(0.3, 2021)
        val soja = Soja(0.6, 2009)

        it("probamos los atributos altura  y anioSemilla") {
            menta.altura.shouldBe(1.0)
            menta.anioSemilla.shouldBe(2021)
        }

        it("verificar si da semillas") {
            menta.daSemillas().shouldBeTrue()
            mentita.daSemillas().shouldBeFalse()
            soja.daSemillas().shouldBeFalse()
        }

        it("es fuerte") {
            menta.esFuerte().shouldBeFalse()
            soja.esFuerte().shouldBeFalse()
        }

        it("espacio") {
            menta.espacio().shouldBe(2.0)
            mentita.espacio().shouldBe(1.3)
            soja.espacio().shouldBe(0.3)
        }

        it("verifico la suma de varias") {
            val superficie = mutableListOf(
                soja.espacio(),
                menta.espacio(),
                mentita.espacio()
            ).sum()
            Math.ceil(superficie).shouldBe(4)
        }
    }
})*/

class semillaMentaTest: DescribeSpec({
    describe("Creación de mentas") {
        //una menta de 1 metro, debería dar semillas y ocupar un espacio de 2 metros cuadrados.
        //una menta de solo 0.3 metros, no debería dar semillas y ocuparía 1.3 metros cuadrados de espacio.
        val menta1 = Menta(1.0, 2000)
        val menta2 = Menta(0.3, 2015)

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

/*
La tolerancia al sol depende de su altura:

menor a 0,5 metros: 6 horas;
entre 0,5 y 1 metro: 7 horas;
más de 1 metro: 9 horas;
La condición alternativa para que de semillas es su propia semilla sea de obtención reciente
 (posterior al 2007) y además su altura sea de más de 1 metro. El espacio que ocupa es la mitad de su altura.

Por ejemplo, si tuviéramos una soja de 0,6 metros y de semilla de 2009, la planta tendría una tolerancia
al sol de 7 horas, no daría semillas y ocuparía 0,3 m2.
*/



    describe("Creación planta soja") {
        val soja = Soja(0.6, 2009)

        it("probamos los atributos altura  y anioSemilla") {
            soja.altura.shouldBe(1.0)
            soja.anioSemilla.shouldBe(2021)
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


//si tenemos una quinoa que ocupa 0.2 m2 y su semilla de origen es de 2010, se trata de una planta que da semillas.
//si tenemos una planta que ocupa 0.9 m2 pero cuya semilla de origen es de 2006, también da semillas.
class SemillaQuinoaTest: DescribeSpec ({
    describe("Creación de la planta de quinoa") {
        val quinoa1 = Quinoa(0.2, 2010)
        val quinoa2 = Quinoa(0.9, 2006)
    }
})





