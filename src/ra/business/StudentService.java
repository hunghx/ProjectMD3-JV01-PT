package ra.business;

import ra.config.Contants;
import ra.config.IOFile;
import ra.model.Student;

import java.util.List;

public class StudentService implements IGenericService<Student,String>{
    private IOFile<Student> studentData;
    private List<Student> students;

    public StudentService() {
        studentData= new IOFile<>();
        students = studentData.readFromFile(Contants.STUDENT_PATH);
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean save(Student student) {
        if(findById(student.getMaSv())==null) {
            // thêm mới
            students.add(student);
        }else {
            // cạp nhật thông tin
            students.set(students.indexOf(findById(student.getMaSv())),student);
        };
        // lưu vào file
        studentData.writeToFile(students,Contants.STUDENT_PATH);
        return true;
    }

    @Override
    public boolean delete(String s) {
        students.remove(findById(s));
        // lưu vào file
        studentData.writeToFile(students,Contants.STUDENT_PATH);
        return  true;
    }

    @Override
    public Student findById(String s) {
        for (Student student: students
             ) {
            if(student.getMaSv().equals(s)){
                return student;
            }
        }
        return null;
    }
}
