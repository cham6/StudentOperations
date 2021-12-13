import java.util.*;

public class StudentOperations {

    public static void main(String[] args) {

        int top = 3;
        Set<Student> students = new HashSet<Student>();
        Set<Subject> subjects = new HashSet<Subject>();
        Subject sub1 = new Subject(40, "Physics");
        Subject sub2 = new Subject(50, "Chemistry");
        Subject sub3 = new Subject(70, "English");
        Subject sub4 = new Subject(80, "Hindi");

        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);
        subjects.add(sub4);

        Student std1 = new Student("Student1", "id1",subjects );
        students.add(std1);

        Set<Subject> student2Subjects = createSubjects("Physics", 20, "Chemistry", 30, "English", 40, "Hindi", 40);

        Student std2 = new Student("Student2", "id2",student2Subjects );
        students.add(std2);

        Set<Subject> student3Subjects = createSubjects("Physics", 50, "Chemistry", 40, "English", 50, "Hindi", 90);

        Student std3 = new Student("Student3", "id3",student3Subjects );
        students.add(std3);

        Set<Subject> student4Subjects = createSubjects("Physics", 100, "Chemistry", 100, "English", 100, "Hindi", 100);

        Student std4 = new Student("Student4", "id4",student3Subjects );
        students.add(std4);

        Set<Subject> student5Subjects = createSubjects("Physics", 0, "Chemistry", 0, "English", 0, "Hindi", 0);

        Student std5 = new Student("Student5", "id5",student3Subjects );
        students.add(std4);

        getTopRankers(3, students);
        System.out.println("");
        getStudentDetails("Student1", students);
    }

    public static void getTopRankers(int top, Set<Student> students) {
        Iterator studentIterator = students.iterator();
        Map<String, Student> studentMarks = new HashMap<String, Student>();
        while(studentIterator.hasNext()){
            Student student = (Student) studentIterator.next();
            //Integer marks = getTotalMarks(student);
            studentMarks.put(student.getName(), student);
        }


        List<Student> studentName = new ArrayList<Student>(studentMarks.values());

        Collections.sort(studentName, Comparator.comparing(Student::getTotalMarks));


        for (Student p : studentName) {
            System.out.println("Student names and Ranks are as follows: ");
            HashMap<String, Integer> rankStudents = new HashMap<String, Integer> ();
            if (top == 0){
                break;
            }
            rankStudents.put(p.getName(), top);
            System.out.println(p.getName().toString() + " Rank : " + top);
            top--;
        }



    }


    public static void getStudentDetails(String name, Set<Student> students) {

        Iterator studentIterator = students.iterator();
        while(studentIterator.hasNext()) {
            Student student = (Student) studentIterator.next();
            if(student.name.equalsIgnoreCase(name)) {
                System.out.println("Student " + student.getName() + " subjects and marks are as below:");
                Iterator<Subject> subIterator = student.getSubject().iterator();
                while (subIterator.hasNext()){
                    Subject sub = subIterator.next();
                    System.out.println(" Subject: " + sub.getName() + " Marks: " + sub.getMarks());
                }
            }
        }

    }


    public Integer getTotalMarks(Student student){
        Set<Subject> subjects = student.subjectSet;
        Iterator subjectsIterator = subjects.iterator();
        Integer totalMarks = 0;
        while(subjectsIterator.hasNext()){
            Subject subject  = (Subject) subjectsIterator.next();
            totalMarks = totalMarks + subject.getMarks();
        }
        return totalMarks;
    }

    public static  Set<Subject> createSubjects(String sub1Name, Integer sub1Marks,String sub2Name, Integer sub2Marks,String sub3Name, Integer sub3Marks,String sub4Name, Integer sub4Marks) {
        Subject sub1 = new Subject(sub1Marks, sub1Name);
        Subject sub2 = new Subject(sub2Marks, sub2Name);
        Subject sub3 = new Subject(sub3Marks, sub3Name);
        Subject sub4 = new Subject(sub4Marks, sub4Name);

        Set<Subject> subjects = new HashSet<Subject>();

        subjects.add(sub1);
        subjects.add(sub2);
        subjects.add(sub3);
        subjects.add(sub4);
        return subjects;

    }

}
