import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentDemo {
    public static int logoutFlag = 0;
    public static void main(String[] args) throws IOException {
        ArrayList<Student> stuList = new ArrayList<Student>();
        while (true){
            System.out.println("--------------欢迎来到学生管理系统---------------");
            tip();
            Scanner sc = new Scanner(System.in);
            int inputNum = sc.nextInt();
            choose(inputNum, stuList);
            if (logoutFlag == 1){
                break;
            }
        }
    }

    public static void tip(){
        System.out.println("1: 查看所有学生");
        System.out.println("2: 增加学生");
        System.out.println("3: 修改学生");
        System.out.println("4: 查看某个学生");
        System.out.println("5: 退出系统");
    }

    public static void choose(int num,ArrayList<Student> stuList ) throws IOException {
        switch (num) {
            case 1: showAll();
                break;
            case 2: addStudent();
                break;
            case 3: changeStudent();
                break;
            case 4:showOneStu(stuList);
                break;
            case 5: logout();
                break;
            default:
                System.out.println("请重新输入");
                break;
        }
    }

    public static void showAll() throws IOException {
        ArrayList<Student> stuList = readData();
        System.out.println("姓名" + "  " + "学号" + "  " + "年龄");
        for (int x = 0;x < stuList.size();x++){
            System.out.println(stuList.get(x).getName() + "  " + stuList.get(x).getXuehao() + "  " + stuList.get(x).getAge());
        }
    }

    public static void addStudent() throws IOException {
        ArrayList<Student> stuList = readData();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = sc.nextLine();
        System.out.println("请输入学号");
        int xuehao = sc.nextInt();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        Student stu = new Student(name, xuehao, age);
        stuList.add(stu);
        BufferedWriter bw  = new BufferedWriter(new FileWriter("stu.txt"));
        StringBuffer sb = new StringBuffer();
        writeData(stuList);
    }

    public static  void changeStudent() throws IOException {
        ArrayList<Student> stuList = readData();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        int xuehao = sc.nextInt();
        boolean flag = false;
        int index = 0;
        for(int x = 0; x < stuList.size(); x++){
            if(stuList.get(x).getXuehao() == xuehao){
                flag = true;
                index = x;
            }
        }
        if(flag){
            Scanner sc1 = new Scanner(System.in);
            System.out.println("请输入姓名");
            String name = sc1.nextLine();
            System.out.println("请输入学号");
            int newXuehao = sc1.nextInt();
            System.out.println("请输入年龄");
            int age = sc1.nextInt();
            Student stu = new Student(name, newXuehao, age);
            stuList.set(index, stu);
            System.out.println(name + "---");
            writeData(stuList);
        }else {
            System.out.println("没有该学生的信息");
        }
    }

    public static void showOneStu(ArrayList<Student> stuList){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        int xuehao = sc.nextInt();
        boolean flag = false;
        int index = 0;
        for(int x = 0; x < stuList.size(); x++){
            if(stuList.get(x).getXuehao() == xuehao){
                flag = true;
                index = x;
            }
        }
        if(flag){
            System.out.println("姓名" + "  " + "学号" + "  " + "年龄");
            System.out.println(stuList.get(index).getName() + "  " + stuList.get(index).getXuehao() + "  " + stuList.get(index).getAge());

        }else {
            System.out.println("没有该学生的信息");
        }

    }

    public static void logout(){
        logoutFlag = 1;
    }

    public static ArrayList<Student> readData() throws IOException {
        ArrayList<Student> stuList = new ArrayList<Student>();
        BufferedReader br = new BufferedReader(new FileReader("stu.txt"));
        String line;
        while ((line = br.readLine()) != null){
            String[] tempArr = line.split("-");
            Student s = new Student();
            s.setXuehao(Integer.parseInt(tempArr[0]));
            s.setName(tempArr[1]);
            s.setAge(Integer.parseInt(tempArr[2]));
            stuList.add(s);
        }
        return  stuList;
    }

    public static void writeData(ArrayList<Student> stuList) throws IOException {
        BufferedWriter bw  = new BufferedWriter(new FileWriter("stu.txt"));
        StringBuffer sb = new StringBuffer();
        for (int x = 0; x < stuList.size(); x++){
            sb.append(stuList.get(x).getXuehao()).append("-").append(stuList.get(x).getName()).append("-").append(stuList.get(x).getAge());
            bw.write(sb.toString());
            sb.delete(0, sb.length()); // 清空 stringBuffer
            bw.newLine();
            bw.flush();
        }
        bw.close();
    }
}
