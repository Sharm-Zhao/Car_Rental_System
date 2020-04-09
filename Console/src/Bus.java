public class Bus extends Car {
    //bus 载人汽车
    //子类的构造过程中必须调用其父类的构造方法
    //因为超类Car类已经有这些东西了，所以子类就不需要再写一遍
    protected int person;

    //构造方法
    public Bus(int indice,String name,double rent,int person){
        super(indice,name,rent);
        this.person=person;
    }

    public int getPerson(){
        return person;
    }
    public void setPerson(int newPerson){
        this.person=newPerson;
    }


}
