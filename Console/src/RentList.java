//用户租的车汇总
public class RentList {
    private  int Indice;//型号
    private  String Name;
    private  int Day;//要租该型号的天数

    public int getIndice() {
        return Indice;
    }
    public String getName() {
        return Name ;
    }
    public int getDay() {
        return Day;
    }

    public void setIndice(int newIndice) {
        Indice=newIndice;
    }

    public void setName(String newName) {
        Name = newName;
    }

    public void setDay(int newDay) {
        Day = newDay;
    }
}
