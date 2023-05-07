//Elaborado Por Camilo José Martínez & Alberto Luis Vigna
package com.javeriana


trait Pagos {
  def calculoComision(reportVentas: Double): Double = {
    reportVentas * 0.01
  }
}
class Empleado(val nombre: String, val salario: Double) {
  def pagoMensual(): Double = {
    salario
  }
}
class Contratista(override val nombre: String, override val salario: Double, val tiempo: Int) extends Empleado(nombre, salario) {
  override def pagoMensual(): Double = {
    salario * tiempo
  }
}
class VendedorExterno(override val nombre: String, override val salario: Double, override val tiempo: Int, val reportVentas: Double) extends Contratista(nombre, salario, tiempo) with Pagos {
  override def pagoMensual(): Double = {
    super.pagoMensual() + calculoComision(reportVentas)
  }
}
class EmpleadoDePlanta(override val nombre: String, override val salario: Double, val descuentoMes: Double) extends Empleado(nombre, salario) {
  override def pagoMensual(): Double = {
    salario - descuentoMes
  }
}
class VendedorDePlanta(override val nombre: String, override val salario: Double, override val descuentoMes: Double, val reportVentas: Double) extends EmpleadoDePlanta(nombre, salario, descuentoMes) with Pagos {
  override def pagoMensual(): Double = {
    super.pagoMensual() + calculoComision(reportVentas)
  }
}

object Main extends App {
  val empleadoDePlanta = new EmpleadoDePlanta("Juan", 3000000, 1000000)
  val vendedorDePlanta = new VendedorDePlanta("Pedro", 3000000, 1000000, 150000000)
  val contratista = new Contratista("Maria", 150000, 20)
  val vendedorExterno = new VendedorExterno("Luis", 150000, 20, 150000000)

  println(s"El pago mensual de ${empleadoDePlanta.nombre} es ${empleadoDePlanta.pagoMensual()}")
  println(s"El pago mensual de ${vendedorDePlanta.nombre} es ${vendedorDePlanta.pagoMensual()}")
  println(s"El pago mensual de ${contratista.nombre} es ${contratista.pagoMensual()}")
  println(s"El pago mensual de ${vendedorExterno.nombre} es ${vendedorExterno.pagoMensual()}")
}
