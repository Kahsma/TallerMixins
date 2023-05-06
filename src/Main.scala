package com.javeriana

trait Pagos {

  def calculosComision (): Double = {





  }

}
class  Empleado(val nombre: String,val salario: Double ) {

  def pagoMensual(salario: Double): Double = {
    0
  }
}


class Contratista(override val nombre: String,override val salario: Double, val tiempo: Int) extends Empleado(nombre, salario) {

  override def pagoMensual(salario: Double): Double = {


    salario * tiempo


  }


}
class VendedorExterno(override val nombre: String, override val salario: Double, override val tiempo: Int, val comision: Double) extends Contratista(nombre, salario, tiempo) {




}

class EmpleadoDePlanta(override val nombre: String,override val salario: Double,val descuentoMes:Double) extends Empleado(nombre, salario) {
  override def pagoMensual(base: Double): Double = {
    salario-descuentoMes
  }

}

class VendedorDePlanta(override val nombre: String,override val salario: Double, override val descuentoMes:Double,val comision:Double) extends EmpleadoDePlanta(nombre, salario,descuentoMes) with Pagos{

}


object Main {
  def buscarComision(pagoCompleto:Pagos) = pagoCompleto.calculosComision()
  def main(args: Array[String]): Unit = {










  }
}