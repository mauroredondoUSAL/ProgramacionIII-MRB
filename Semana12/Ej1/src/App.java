public class App {
    public static void main(String[] args){
        try {
            metodoPeligroso();
        } catch (MyCustomCheckedException e) {
            System.out.println(e.toString());

        }
        try{
        metodoNoTanSeguro();
        System.out.println("He pasado por aquí");
        }catch(MyCustomRuntimeException e){
            System.out.println(e.toString());
        }
    }

    public static void metodoPeligroso() throws MyCustomCheckedException{
        throw new MyCustomCheckedException("Fallo controlado");

    }

    public static void metodoNoTanSeguro(){
        throw new MyCustomRuntimeException("Fallo no controlado");
    }


    //Para la aplicación, las excepciones se tienen que capturar o en el controlador (invocando un modelo vista.mostrarerror de la vista) o directamente carpturarlo en la vista
}
