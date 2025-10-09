public class Person {
    //Atributos
    private String nombre;
    private float peso;
    private float altura;

    
    //Constructores: valores predeterminados
    Person(){
        this.nombre="";
        this.altura=0;
        this.peso=0;
    }
    Person(String nombre){
        this(); //Así llamamos al constructor que tenemos encima (No porque esté encima sino porque es el que no tiene parámetros)
        this.nombre=nombre;
        this.peso=0;
        this.altura=0;
    }
    Person(String nombre, float peso, float altura){
        this.nombre=nombre;
        this.peso=peso;
        this.altura=altura;
    }

    public static Person crearPersonDesdeArgumentos(String []args){
            if(args.length!=3){
                System.err.println("Debes introducir tres parámetros");
                return null;
            }

        try{
            float altura = Float.parseFloat(args[2]);
            float peso=Float.parseFloat(args[1]);

            Person persona = new Person(args[0], peso,altura);


           return persona;


        }catch(Exception e){
            System.err.println("No se han podido convertir correctamente el peso y la altura");
            return null;
        }
    }



    //Métodos: que nos diga toda la info del usuario
    public void imprimirInnformacion(){
        System.out.println(this.nombre+" pesa: "+this.peso+" y mide: "+this.altura);
    }
    public float calcularIMC(){
        float alturaEnMetros=this.altura/100;
        if(peso<=0 && alturaEnMetros<=0){
            System.err.println("peso o altura nulos");
        }
        return this.peso/(alturaEnMetros*alturaEnMetros);
    
    }



    //Getters and setters: para conseguir el valor y para cambiarlo resp.
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre; //El this indica el nombre que tenemos arriba definido, el otro es el nuevo valor (Creo xd)
    }


    public float getPeso() {
        return this.peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


    public float getAltura() {
        return this.altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }


}
