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

    describe("Creación planta soja") {
        val soja = Soja(0.6, 2009)

        it("probamos los atributos altura  y anioSemilla") {
            soja.altura.shouldBe(1.0)
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
        val quinoa1 = Quinoa(1.5, 2010)
        val quinoa2 = Quinoa(0.8, 2006)

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

//La peperina se esparce más rápido que la menta y por eso el espacio que ocupa es el doble del que ocuparía una planta de menta de las mismas características.
class SemillaPeperinaTest: DescribeSpec ({
    val peperina1 = Peperina(1.2, 2008)
    val peperina2 = Peperina(0.7, 2004)

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









/*Agregar al modelo la soja transgénica y la peperina, que son similares a la soja y a la menta respectivamente, pero con algunas diferencias.

La soja transgénica nunca da nuevas semillas, porque las empresas que las comercializan las someten adrede a un proceso
de esterilización (que les asegura no perder nunca a su clientes). Ojo: la consulta siempre tiene que dar falso, incluso
 si se cumple la condición general.

La peperina se esparce más rápido que la menta y por eso el espacio que ocupa es el doble del que ocuparía
 una planta de menta de las mismas características.*/



class SojaTransgenicaTest: DescribeSpec({
    describe( "creacion de soja transgenica"){
        val sojaTrans1= SojaTransgenica(0.5, 2009)
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
            sojaTrans1.espacio().shouldBe(0.3)
        }

}




})



