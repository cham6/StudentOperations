import java.util.Iterator;
import java.util.Set;

public class Student {

    String name, id;
    Set<Subject> subjectSet;
    Integer totalMarks;

    public Student(String name, String id, Set<Subject> subjectSet) {
        this.name = name;
        this.id = id;
        this.subjectSet = subjectSet;
        setTotalMarks(subjectSet);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Subject> getSubject() {
        return subjectSet;
    }

    public void setSubject(Set<Subject> subject) {
        this.subjectSet = subject;
    }

    public void setTotalMarks(Set<Subject> subjectSet){
        Set<Subject> subjects = subjectSet;
        Iterator subjectsIterator = subjects.iterator();
        Integer totalMarks = 0;
        while(subjectsIterator.hasNext()){
            Subject subject  = (Subject) subjectsIterator.next();
            totalMarks = totalMarks + subject.getMarks();
        }
        this.totalMarks = totalMarks;
    }

    public Integer getTotalMarks() {
        return totalMarks;
    }


}
