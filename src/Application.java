import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    List<Student> students = new ArrayList<>();
    Scanner scr = new Scanner(System.in);

    public Application(){

    }

    public void run(){
        boolean flag = true;
        while(flag){
            System.out.println("1. Ввести ученика\n" +
                    "2. Вывести всех учеников по возрастанию\n" +
                    "3. Вывести всех учеников по убыванию\n" +
                    "4. Удалить ученика по индексу\n" +
                    "5. Выйти из программы\n");
            switch (chooseOption()) {
                case 1 -> addNewStudent();
                case 2 -> showStudentsAsc();
                case 3 -> showStudentsDesc();
                case 4 -> deleteStudentByIndex();
                case 5 -> flag = false;
                default -> System.out.println("Выбрана невалидная опция, попробуйте ещё раз");
            }
        }
    }

    //TODO тест
    private void deleteStudentByIndex() {
        showStudentsAsc();
        System.out.print("\nВведите индекс студента, которого необходимо удалить из списка: ");
        int studentIndex = scr.nextInt();
        if(studentIndex >= 0 && studentIndex<students.size())
            for(int i=0; i< students.size(); i++){
                if (i == studentIndex) students.remove(studentIndex);
            }
        else System.out.println("Неверный индекс студента");
    }

    private void showStudentsAsc() {
        if (!students.isEmpty())
        {
            Collections.sort(students);
            for (Student student : students) {
                System.out.println(students.indexOf(student) + ". " + student);
            }
        }
        else System.out.println("В списке нет ни одного студента");
    }

    private void showStudentsDesc() {
        if (!students.isEmpty()) {
            for (int i = students.size(); i-- > 0; ) {
                System.out.println(i + ". " +students.get(i));
            }
        }
        else System.out.println("В списке нет ни одного студента");
    }

    //TODO продебажить
    private void addNewStudent() {
            System.out.println("Введите через пробел в одну строку данные нового ученика в следующем порядке: \n" +
                    "1. ФИО студента(через пробел)\n" +
                    "2. Его возраст(целое число)\n" +
                    "3. Класс\n" +
                    "4. Любимый предмет(из следующего списка: английский, математика, история, литература, астрономия, химия)");
            String[] studentData = scr.nextLine().split(" ");
            String fullName = studentData[0] + " " + studentData[1] + " " + studentData[2];
            Student newStudent = new Student(fullName, Integer.parseInt(studentData[3]),
                    studentData[4], Subject.fromString(studentData[5]));
            if(!students.contains(newStudent)) students.add(newStudent);
            else System.out.println("Ученик уже есть в базе");
    }

    public int chooseOption(){
        String input = scr.nextLine();
        int option=-1;
        if(input.length() ==1) option = Integer.parseInt(input);
        return option;

    }
}
