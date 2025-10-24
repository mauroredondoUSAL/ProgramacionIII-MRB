public class App {
    public static void main(String[] args) throws Exception {
        Person personita = Person.crearPersonDesdeArgumentos(args);

        Float imc = personita.calcularIMC();
        System.out.println("El imc es: "+ imc);
    }
}
