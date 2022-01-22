public class Student {
    String name;
    int age;
    String eduClass;
    Subject preferredSubject;

    public Student(){}

    public Student(String name, int age, String eduClass, Subject preferredSubject) {
        this.name = name;
        this.age = age;
        this.eduClass = eduClass;
        this.preferredSubject = preferredSubject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", eduClass='" + eduClass + '\'' +
                ", preferredSubject=" + preferredSubject +
                '}';
    }
}
