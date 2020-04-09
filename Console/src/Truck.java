public class Truck extends Car {
    //与Bus相同的步骤，只不过将载人改为载货
    protected double goods;
    public Truck(int indice,String name,double rent,double goods){
        super(indice,name, rent);
        this.goods=goods;
    }

    public double getGoods() {
        return goods;
    }

    public void setGoods(double goods) {
        this.goods = goods;
    }

}
