/**
花费了很多时间，终于将这个代码改好，调试成功了。
 虽然是借鉴了别人的方法，但是，不识人间烟火并不是最好的，万物为我所用才是，将自己所能找到的有价值的东西都消化下来为我所用。
 这是自己第一个Java的项目，项目名字在慕课网上的《Java入门第二季》，我相信，随着自己的不断实践、不断努力，自己可以不断进步的。
 任何东西都是这样。
 这次我还学会了将自己的代码放在GitHub上。
 Yeah！
 Sharm-Zhao 2020/4/9
 */
import  java.util.Scanner;
//从功能上分，总共分为三种，载人汽车，载货汽车，既载人又载货。
//对应Bus,Truck,PickUp
public class Main {
    private static int choice;
    //知道了这里为什么使用static静态域，因为后面的静态方法只能调用静态方法
    static Scanner input = new Scanner(System.in);

    //这里Car是超类，其他是子类。
    private static Car[] cars = new Car[]{
            new Bus(1, "奥迪A4", 500, 4),
            new Bus(2, "马自达6", 400, 4),
            new PickUp(3, "皮卡雪6", 450, 4, 2),
            new Bus(4, "金龙", 800, 20),
            new Truck(5, "松花江", 400, 4),
            new Truck(6, "依维柯", 1000, 20)
    };

    public static void isNeed() {
        System.out.println("欢迎使用答答租车系统：\n" +
                "您是否要租车：1是 0否");
        int isneed = input.nextInt();
        if (isneed == 0) System.out.println("您是否要租车：1是 0否");
        else if (isneed != 1) System.out.println("您输入的序号有误，请重新运行输入");


    }

    public static void DisplayList() {
        System.out.println("您可租车的型号和价格表");
        //cars这个数组中的每一个元素都是一个对象
        //?这里也可以想到使输出对齐
        //关键字instanceof,测试一个对象是否为一个类的实例
        for (int i = 0; i < cars.length; i++) {
            if (cars[i] instanceof Bus) {
                Bus car = (Bus) cars[i];//强制类型转换
                System.out.println(car.indice + " " + car.name + " " + car.rent + "元/天" + " " + "核载" + car.person + "人");
            } else if (cars[i] instanceof Truck) {
                Truck car = (Truck) cars[i];
                System.out.println(car.indice + " " + car.name + " " + car.rent + "元/天" + " " + "核载" + car.goods + "吨");
            } else if (cars[i] instanceof PickUp) {
                PickUp car = (PickUp) cars[i];
                System.out.println(car.indice + " " + car.name + " " + car.rent + "元/天" + " " + "核载" + car.person + "人" + " " + "核载" + car.goods + "吨");
            }
        }
    }

    private static int RentNum() {
        System.out.println("请输入您要租的汽车的数量:");
        int RentNum = input.nextInt();
        return RentNum;
    }

    //租车信息表
    //方法 关键字     返回值类型  方法名     参数
    private static RentList[] RentForm(int num) {
        //租车信息对象数组
        RentList[] rentLists = new RentList[num];
        //租的天数
        System.out.print("请输入您要租车的天数：");
        int Day = input.nextInt();
        for (int i = 0; i < num; i++) {
            //型号
            System.out.println("请输入租的第" + (i + 1) + "辆车的序号");
            int Indice = input.nextInt();
            //将信息存入对象数组
            //我懂这个意思了

            rentLists[i] = new RentList();//这步不能掉
            rentLists[i].setIndice(Indice);
            rentLists[i].setName(cars[i].name);
            rentLists[i].setDay(Day);
        }
        return rentLists;
    }

    public static void main(String[] args) {
        System.out.println("欢迎使用租车系统");
        // 原因是：类加载编译时就把程序的入口初始化了，执行时是JAVA虚拟机所识别的特定字节码，
        // C却是处理器可直接执行的二进制指令，编译的原理不一样，语言独特的特性与运行环境不一样。

        isNeed();//判断是否要租车

        DisplayList(); //显示可租车清单

        int num = RentNum();//用户租车的数量

        RentList[] rentLists; //填写出租信息表 定义

        //下面语句成立的前提是RentForm返回一个数组  赋值
        rentLists = RentForm(num);

        Pay(rentLists);//生成账单
    }


    public static void Pay(RentList[] rentLists) {
        System.out.println("您的账单：");

        int sumPerson = 0;
        double sumGood = 0d;
        double sumRent = 0d;

        System.out.println("你选择的车分别是：");
        for (int i = 0; i < rentLists.length; i++) {
            int temporary = rentLists[i].getIndice();

            if (cars[temporary-1] instanceof Bus) {
                Bus car = (Bus) cars[i];//强制类型转换
                sumPerson += car.person;
                sumRent += car.rent;
            } else if (cars[temporary-1] instanceof Truck) {
                Truck car = (Truck) cars[i];
                sumGood += car.goods;
                sumRent += car.rent;
            } else if (cars[temporary-1] instanceof PickUp){
                PickUp car = (PickUp) cars[i];
                sumPerson += car.person;
                sumGood += car.goods;
                sumRent += car.rent;
            }
            System.out.println(rentLists[i].getName());
        }
        sumRent*=3;

        System.out.println("所有车总共载人:"+sumPerson+",总共载货"+sumGood+"\n"+
                            "您需要花费的总租金为"+sumRent);
    }
}


