import java.math.BigDecimal
/**
 * Convierte una cantidad de cuatro o más cifras a su representación escrita con letra.
 *el valor que recibe es la cantidad a convertir,  la que ingresa el usuario y retorna una cadena de texto que contiene la
 *  representación con letra, El valor se dividira para saber cual valor se ingreso y cambiarlo a letra, si no es mayor del 4
 *  cifras, se tomara el valor del metodo MenorMil
 */
fun MayorMil(s: String?): String? {
    val Resultado = StringBuilder()
    val Decimal = BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN)
    val Entero = Decimal.toBigInteger().toLong()
    val Unidad = (Entero % 1000).toInt()
    val Mil = (Entero / 1000 % 1000).toInt()
    val Millon = (Entero / 1000000 % 1000).toInt()
    val Milmillon = (Entero / 1000000000 % 1000).toInt()
    if (Entero == 0L) {
        Resultado.append("Cero ")
        return Resultado.toString()
    }
    if (Milmillon > 0) Resultado.append(MenorMil(Milmillon).toString() + "Mil ")
    if (Millon > 0) Resultado.append(MenorMil(Millon).toString())
    if (Milmillon == 0 && Millon == 1) Resultado.append("Millón ")
    else if (Milmillon > 0 || Millon > 0) Resultado.append(
        "Millones "
    )
    if (Mil > 0) Resultado.append(MenorMil(Mil).toString() + "Mil ")
    if (Unidad > 0) Resultado.append(MenorMil(Unidad).toString())
    return Resultado.toString()
}

/**
 * Convierte una cantidad de tres cifras a su representación escrita con letra.
 *el valor que recibe es la cantidad a convertir,  la que ingresa el usuario y retorna una cadena de texto que contiene la
 *  representación con letra, El valor se dividira para saber cual valor se ingreso y cambiarlo a letra
 */
private fun MenorMil(n: Int): StringBuilder {
    val resultado = StringBuilder()
    val Mayor100 = n / 100
    val Mayor10 = n % 100 / 10
    val Menor10 = n % 10
    when (Mayor100) {
        0 -> {}
        1 -> if (Mayor10 == 0 && Menor10 == 0) {
            resultado.append("Cien ")
            return resultado
        } else resultado.append("Ciento ")
        2 -> resultado.append("Doscientos ")
        3 -> resultado.append("Trescientos ")
        4 -> resultado.append("Cuatrocientos ")
        5 -> resultado.append("Quinientos ")
        6 -> resultado.append("Seiscientos ")
        7 -> resultado.append("Setecientos ")
        8 -> resultado.append("Ochocientos ")
        9 -> resultado.append("Novecientos ")
    }
    when (Mayor10) {
        0 -> {}
        1 -> if (Menor10 == 0) {
            resultado.append("Diez ")
            return resultado
        } else if (Menor10 == 1) {
            resultado.append("Once ")
            return resultado
        } else if (Menor10 == 2) {
            resultado.append("Doce ")
            return resultado
        } else if (Menor10 == 3) {
            resultado.append("Trece ")
            return resultado
        } else if (Menor10 == 4) {
            resultado.append("Catorce ")
            return resultado
        } else if (Menor10 == 5) {
            resultado.append("Quince ")
            return resultado
        } else resultado.append("Dieci")
        2 -> if (Menor10 == 0) {
            resultado.append("Veinte ")
            return resultado
        } else resultado.append("Veinti")
        3 -> resultado.append("Treinta ")
        4 -> resultado.append("Cuarenta ")
        5 -> resultado.append("Cincuenta ")
        6 -> resultado.append("Sesenta ")
        7 -> resultado.append("Setenta ")
        8 -> resultado.append("Ochenta ")
        9 -> resultado.append("Noventa ")
    }
    if (Mayor10 > 2 && Menor10 > 0) resultado.append("y ")
    when (Menor10) {
        0 -> {}
        1 -> resultado.append("Un ")
        2 -> resultado.append("Dos ")
        3 -> resultado.append("Tres ")
        4 -> resultado.append("Cuatro ")
        5 -> resultado.append("Cinco ")
        6 -> resultado.append("Seis ")
        7 -> resultado.append("Siete ")
        8 -> resultado.append("Ocho ")
        9 -> resultado.append("Nueve ")
    }
    return resultado
}

fun main(args: Array<String>) {

//    println("Escribe un número entero entre 1-1000000: ")
//    val valor= readLine() //Se pide y se guarda el valor que ingresa el usuario
//    var numero= valor?.toIntOrNull()//Se lee el valor ingresado por el usuario como un int,
//    // en caso de que no sea de tipo int regresa null
//    if (numero != null) { // Se hace la commparación para saber si es nulo, esto se hace más que nada para que no nos de error
//        // con las operaciones % ya que estas nos e pueden hacer con valores nulos
//        when{
//            numero %3 == 0 && numero % 5 == 0->print("FizzBuzz") // si el número ingresado por el usuario al dividirlo
//            // entre 3 y 5 da como residuo 0, se imprime en la consola "FizzBuzz"
//            numero %3 == 0 -> print("Fizz")// si el número al dividirlo entre 3 el reciduo es 0, se escribe Fizz
//            numero %5 == 0 -> print("Buzz")// si el número al dividirlo entre 5 el reciduo es 0, se escribe Buzz
//            else ->  println(valor + "!")  // Si no cumple con ninguna de las anteriores, se imprimira el valor ingresado,
//            // concatenado de un !
//        }
//    }
    println("Escribe un número entero entre 1-100000: ") //Imprime en la pantalla
    val Valor = readLine()!!.toInt()//Pide el valor al usuario

    if (Valor != null) { // Se hace la commparación para saber si es nulo, esto se hace más que nada para que no nos de error
//        // con las operaciones % ya que estas nos e pueden hacer con valores nulos
        if (Valor <= 1000000 && Valor >= 1) {// Se valida si el valor esta entre 1 y 1000000

            when{
            Valor %3 == 0 && Valor % 5 == 0->print("FizzBuzz") // si el número ingresado por el usuario al dividirlo
            // entre 3 y 5 da como residuo 0, se imprime en la consola "FizzBuzz"
            Valor %3 == 0 -> print("Fizz")// si el número al dividirlo entre 3 el reciduo es 0, se escribe Fizz
            Valor %5 == 0 -> print("Buzz")// si el número al dividirlo entre 5 el reciduo es 0, se escribe Buzz
                else -> println(MayorMil(Valor.toString()) + "!")  // Si no cumple con ninguna de las anteriores,
            // se mada llamar el metodo Letra que retora el valor ingresado en letra, lo imprime concatenado de un !
        }



        } else {
            println("El valor ingresado no esta entre el rango 1-1000000") // si no ingresa un valor entre 1 y 10000000,
            // imprime este mendaje

        }
    } else {
        println("El valor es nulo") // Si el valor es nulo imprime esto
    }
}