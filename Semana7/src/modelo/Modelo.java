package modelo;

public class Modelo {
    float num1;
    float num2;
    float sum;

    public Modelo(){
        num1=0;
        num2=0;
        sum=0;
    }
    public void setNum1Num2(float num1,float num2){
        this.num1=num1;
        this.num2=num2;
    }

    public void realizarSuma(){
        this.sum=this.num1+this.num2;
    }

    public float getSuma(){
        return this.sum;
    }
    
}
