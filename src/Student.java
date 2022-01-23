import java.util.Objects;

public class Student implements Comparable<Student>{

    private String name;
    private int age;
    private String eduClass;
    private Subject preferredSubject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEduClass() {
        return eduClass;
    }

    public void setEduClass(String eduClass) {
        this.eduClass = eduClass;
    }

    public Subject getPreferredSubject() {
        return preferredSubject;
    }

    public void setPreferredSubject(Subject preferredSubject) {
        this.preferredSubject = preferredSubject;
    }

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
                ", preferredSubject=" + preferredSubject.getSubject() +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return getName().compareTo(o.getName()) + Integer.compare(getAge(), o.getAge());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name) && Objects.equals(eduClass, student.eduClass) && preferredSubject == student.preferredSubject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, eduClass, preferredSubject);
    }
}
