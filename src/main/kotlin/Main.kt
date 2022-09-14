
fun main(args: Array<String>) {
    println("Escribe un número entero entre 1-1000000: ")
    val valor= readLine() //Se pide y se guarda el valor que ingresa el usuario
    var numero= valor?.toIntOrNull()//Se lee el valor ingresado por el usuario como un int,
    // en caso de que no sea de tipo int regresa null
    if (numero != null) { // Se hace la commparación para saber si es nulo, esto se hace más que nada para que no nos de error
        // con las operaciones % ya que estas nos e pueden hacer con valores nulos
        when{
            numero %3 == 0 && numero % 5 == 0->print("FizzBuzz") // si el número ingresado por el usuario al dividirlo
            // entre 3 y 5 da como residuo 0, se imprime en la consola "FizzBuzz"
            numero %3 == 0 -> print("Fizz")// si el número al dividirlo entre 3 el reciduo es 0, se escribe Fizz
            numero %5 == 0 -> print("Buzz")// si el número al dividirlo entre 5 el reciduo es 0, se escribe Buzz
            else ->  println(valor + "!")  // Si no cumple con ninguna de las anteriores, se imprimira el valor ingresado,
            // concatenado de un !
        }
    }
    /**
     * Intente realizarlo con if pero no me los validaba
     */
    /*    println("Escribe un número entero entre 1-100000: ")
        val Valor= readLine()!!.toInt()

        if (Valor != null) {
            if (Valor <= 1000000 || Valor >= 1){
                if (Valor != null) {
                    when{
                        Valor %3 == 0 && Valor % 5 == 0->print("fizzbuzz")
                        Valor %3 == 0 -> print("Fizz")
                        Valor %5 == 0 -> print("buzz")
                        else ->  println((Valor.toString()) + "!")
                    }
                }
            }else{
                println("El valor ingresado no esta entre el rango 1-1000000")

            }
        }else{
            println("El valor es nulo")
        }*/
}