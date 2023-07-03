package ra.model;

import java.io.Serializable;

public class Student implements Serializable {
    private String maSv;
    private String tenSv;
    private int age;
    private String address ;
    private boolean sex;

    public Student() {
    }

    public Student(String maSv, String tenSv, int age, String address, boolean sex) {
        this.maSv = maSv;
        this.tenSv = tenSv;
        this.age = age;
        this.address = address;
        this.sex = sex;
    }

    public String getMaSv() {
        return maSv;
    }

    public void setMaSv(String maSv) {
        this.maSv = maSv;
    }

    public String getTenSv() {
        return tenSv;
    }

    public void setTenSv(String tenSv) {
        this.tenSv = tenSv;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Mã Sv : "+maSv + " | Tên SV : "+tenSv + " | Tuổi : "+age
                +"\n Địa chỉ : " + address + " |Giới tính : "+(sex?"Nam":"Nữ");
    }
}
