public class Car {
    protected   int  indice; //车的序号
    protected   String  name;//车型,protect方便继承
    protected   double  rent;//租金

    public Car(int indice,String name,double rent){//用构造方法初始化
        this.indice=indice;
        this.name=name;
        this.rent=rent;
    }
    public int getIndice() {
        return indice;
    }

    public String getName() {
        return name;
    }
    public double getRent() {
        return rent;
    }

    public void setIndice(int  indice) {
        this.indice = indice;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

}
