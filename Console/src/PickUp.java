public class PickUp extends Car{

    protected int person;//载人数
    protected double goods;//货物
    //构造方法
    public PickUp(int indice,String name, double rent,int person,double goods) {
        super(indice,name, rent);
        this.person=person;
        this.goods=goods;
    }

    public int getPerson() {
        return person;
    }

    public double getGoods() {
        return goods;
    }

    public void setPerson(int person) {
        this.person = person;
    }

    public void setGoods(double goods) {
        this.goods = goods;
    }
}

