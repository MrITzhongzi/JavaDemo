public class Student {
    private String name;
    private int xuehao;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getXuehao() {
        return xuehao;
    }

    public void setXuehao(int xuehao) {
        this.xuehao = xuehao;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public Student(){}

    public Student(String name, int xuehao, int age) {
        this.name = name;
        this.xuehao = xuehao;
        this.age = age;
    }
}
