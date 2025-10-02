import com.coti.tools.Esdia; //Está amarillo porque todo lo de Esdia está comentado

public class App{
   
    public static void main(String[] args) throws Exception {
        /*Person persona1 = new Person();
        persona1.setNombre(Esdia.readString_ne("Dame el nombre: "));
        persona1.setPeso(Esdia.readFloat("Dame el peso: "));
        persona1.setAltura(Esdia.readFloat("Dame la altura: "));

        Person persona2= new Person();
        persona2.setNombre(Esdia.readString_ne("Dame el nombre: "));
        persona2.setPeso(Esdia.readFloat("Dame el peso: "));
        persona2.setAltura(Esdia.readFloat("Dame la altura: "));
        Person persona3= new Person();
        persona3.setNombre(Esdia.readString_ne("Dame el nombre: "));
        persona3.setPeso(Esdia.readFloat("Dame el peso: "));
        persona3.setAltura(Esdia.readFloat("Dame la altura: "));

        System.out.println(persona1.getNombre()+" mide "+persona1.getAltura()+" y pesa "+persona1.getPeso());
        System.out.println(persona2.getNombre()+" mide "+persona2.getAltura()+" y pesa "+persona2.getPeso());
        System.out.println(persona3.getNombre()+" mide "+persona3.getAltura()+" y pesa "+persona3.getPeso());*/
        //Ahora los atributos se pueden cambiar desde cualquier parte, queremos que sean privados, para eso los getters y los setters (Creo), loos ponemos privados,
        //y ahora con los getters podemos obtener su valor y con los setters los podemos cambiar

        //Ahora haremos los constructores, sirven para dar valores predeterminados a los atributos, así: (lo de constructores es parte del ejercicio 2)
        Person persona1=new Person(); //Al hacer los stops y darle a debuggear, avanzamos con f5 (Windows)
        Person persona2=new Person("Paco");
        Person persona3=new Person("Pepe",80,160 );

        //Esto sirve para comparar altura de las tres personas
        if (persona1.getAltura()>persona2.getAltura() && persona1.getAltura()>persona3.getAltura()) {
                System.out.println(persona1.getNombre()+"Es el más alto de todos");
            }else if(persona2.getAltura()>persona1.getAltura() && persona2.getAltura()>persona3.getAltura()){
                System.out.println(persona2.getNombre()+"Es el más alto de todos");
            }else{
                System.out.println("Qué pasa aquí");
            }
        System.out.println("El IMC de "+persona1.getNombre()+"es "+persona1.calcularIMC());
        System.out.println("El IMC de "+persona2.getNombre()+"es "+persona2.calcularIMC());
        System.out.println("El IMC de "+persona3.getNombre()+"es "+persona3.calcularIMC());
        
        persona1.imprimirInnformacion();
        persona2.imprimirInnformacion();
        persona3.imprimirInnformacion();

    }
}
