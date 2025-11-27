package paquete2;

import paquete1.Clase1; //solo podremos importar la clase 1 ya que la 2 es privada


public class App {
    public static void main(String[] args) throws Exception {

    Clase1 clase1 = new Clase1();
    System.out.println(clase1.publico);// Se puede acceder al ser público
        // System.out.println(clase1.noModificador); Sin modificador no podemos llamarlo y hacer uso de este
        // System.out.println(clase1.protegido); Al ser protegido no podemos llamarlo y hacer uso de este
        // System.out.println(clase1.privado); Al ser privado no podemos llamarlo y hacer uso de este

        clase1.metodoPublic();// Se puede acceder al ser público
        // clase1.metodoNoModificador();Sin modificador no podemos llamarlo y hacer uso de este
        // clase1.metodoProtegido(); Al ser protegido no podemos llamarlo y hacer uso de este
        // clase1.metodoPrivado(); Al ser privado no podemos llamarlo y hacer uso de este

    }
}

//Los modificadores de visibilidad sirven para tener controlados los datos, para tener un mayor control en su flujo, y también
//sirven para ocultar alguna información que no deba ser pública:
//Un ejemplo sería en una cuenta de una subscripción, el dato "contraseña" iría de forma privada