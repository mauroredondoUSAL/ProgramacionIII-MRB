public class App {
    public static void main(String[] args) throws Exception {

        //Comprobar que el tamaño es 2 (El tamaño de args)
        //->Si no es dos, imprimir un error
        if(args.length!=2){
            System.err.println("Debes introducir dos parámetros");
            return;
        }


        //Intentar convertirlos a float
        //->si da error, imprimir un error
        //Si todo va bien, sumarlos
        try{float a =Float.parseFloat(args[0]);
        float b = Float.parseFloat(args[1]);
        System.out.println("La suma es: "+(a+b));
        }catch(Exception e){
            System.err.println("No se han podido convertir los números");
        }
        
    }
}
