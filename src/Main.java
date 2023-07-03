import ra.business.StudentService;
import ra.config.InputMethods;
import ra.model.Student;

public class Main {
    private static StudentService studentService = new StudentService();
    public static void main(String[] args) {
        while (true) {
            System.out.println("-------------STUDENT-MANAGER-------------");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Xemm danh sách học sinh");
            System.out.println("3. Sửa học sinh");
            System.out.println("4. Xóa học sinh");
            System.out.println("5. Thoát");
            System.out.println("------------------------------------------");
            System.out.println("Nhập vào lựa chọn của bạn");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    // thêm mới
                    createNewStudent();
                    break;
                case 2:
                    // hiển thị tất cả danh sách
                    displayAllStudent();
                    break;
                case 3:
                    // cập nhạt thông tin
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập sai, vui lòng nhập lại");
            }
        }
    }
    public static void createNewStudent(){
        System.out.println(" Nhập số lượng sinh viên cần thêm mới");
        int soLuong = InputMethods.getInteger();
        for (int i = 0; i < soLuong; i++) {
            Student student =  new Student();
            System.out.println("----------------------------------------------");
            System.out.println("nhập thông tin cho sinh viên thứ "+(i+1));
            System.out.println("Nhập mã sinh viên");
            student.setMaSv(InputMethods.getString());
            System.out.println("Nhập tên sinh viên");
            student.setTenSv(InputMethods.getString());
            System.out.println("Nhập tuổi sinh viên");
            student.setAge(InputMethods.getInteger());
            System.out.println("Nhập địa chỉ của sinh viên");
            student.setAddress(InputMethods.getString());
            System.out.println("Nhập giới tính của sinh viên");
            student.setSex(InputMethods.getBoolean());
            studentService.save(student);
            System.out.println("Thêm mới thành công");
        }
    }
    public  static  void displayAllStudent(){
        if(studentService.findAll().isEmpty()){
            System.err.println(" danh sách trống");
            return;
        }
        for ( Student s: studentService.findAll()) {
            System.out.println("---------------------------------------");
            System.out.println(s);
        }
    }
    public  static void updateStudent(){
        System.out.println("Nhập vào mã của sinh vien cần sửa");
        String maSv = InputMethods.getString();
        Student stu = studentService.findById(maSv);
        if(stu ==null){
            System.err.println("Không có sinh viên nào phù hợp với mã bạn nhập");
        }else {
            // cho phép sửa
            System.out.println("Nhập tên sinh viên mới");
            stu.setTenSv(InputMethods.getString());
            System.out.println("Nhập tuổi sinh viên mới");
            stu.setAge(InputMethods.getInteger());
            System.out.println("Nhập địa chỉ của sinh viên mới");
            stu.setAddress(InputMethods.getString());
            System.out.println("Nhập giới tính của sinh viên mới");
            stu.setSex(InputMethods.getBoolean());
            studentService.save(stu);
            System.out.println("Cập nhật thành công");
        }
    }
    public  static void deleteStudent(){
        System.out.println("Nhập vào mã của sinh vien cần xóa");
        String maSv = InputMethods.getString();
        if(studentService.findById(maSv) ==null){
            System.err.println("Không có sinh viên nào phù hợp với mã bạn nhập");
        }else {
        studentService.delete(maSv);
            System.out.println("Xóa thành công");
        }
    }
}