public class MyCustomCheckedException extends Exception{
    public MyCustomCheckedException() {
        super("Ha ocurrido un error en MyCustomCheckedException");
    }
    public MyCustomCheckedException(String mensaje){
        super(mensaje);
    }

    public MyCustomCheckedException(String mensaje, Throwable cause){
        super(mensaje, cause);
    }


}
