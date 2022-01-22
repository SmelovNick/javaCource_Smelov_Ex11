import java.util.*;

public class Main {
    static HashSet<Student> students = new HashSet<>();
    static Scanner scr = new Scanner(System.in);
    public static void main(String[] args) {
        boolean flag = true;
        while(flag){
            System.out.println("1. Ввести ученика" +
                    "2. Вывести всех учеников по возрастанию" +
                    "3. Вывести всех учеников по убыванию" +
                    "4. Удалить ученика по индексу" +
                    "5. Выйти из программы");
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

    private static void deleteStudentByIndex() {
        System.out.println();
    }

    private static void showStudentsAsc() {
        for (Student student : students){
            System.out.println(student);
        }
    }

    private static void showStudentsDesc() {
        List<Student>listStudents = new ArrayList<>(students);
        ListIterator<Student> studentsIter = listStudents.listIterator();
        while (studentsIter.hasPrevious()){
            System.out.println(studentsIter.previous());
        }
    }

    private static void addNewStudent() {
        boolean flag = true;
        while (flag){
            System.out.println("Введите через пробел данные нового ученика в следующем порядке: " +
                    "1. ФИО студента" +
                    "2. Его возраст" +
                    "3. Класс" +
                    "4. Любимый предмет");
            String[] studentData = scr.next().split(" ");
            Student newStudent = new Student(studentData[0], Integer.parseInt(studentData[1]),
                    studentData[2], Subject.valueOf(studentData[3]));
            if(!students.contains(newStudent)) students.add(newStudent);
            else System.out.println("Ученик уже есть в базе");
        }
    }

    public static int chooseOption(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int option=-1;
        if(input.length() ==1) option = Integer.parseInt(input);
        return option;
    }
}
