package com.warning.warning_system.entity;

import com.warning.warning_system.utils.PasswordConverter;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student")
public class Student {
    /**
     * 学号（账号）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer studentId;

    /**
     * 姓名
     */
    @Column(name = "student_name", nullable = false)
    private String studentName;

    /**
     * 性别
     */
    @Column(name = "gender")
    private String gender;

    /**
     * 所属学院ID (关联college表)
     */
    @Column(name = "college_id")
    private Integer collegeId;

    /**
     * 所属班级
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 所属年级
     */
    @Column(name = "grade")
    private String grade;

    /**
     * 手机
     */
    @Column(name = "phone")
    private String phone;

    /**
     * 邮箱
     */
    @Column(name = "email")
    private String email;

    /**
     * 密码 (默认 123456)
     */

    @Column(name = "password", nullable = false)
    @Convert(converter = PasswordConverter.class)
    private String password;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}