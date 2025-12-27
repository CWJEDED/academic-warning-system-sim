package com.warning.warning_system.entity;

import com.warning.warning_system.utils.PasswordConverter;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {
    /**
     * 教师工号（账号）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Integer teacherId;

    /**
     * 姓名
     */
    @Column(name = "teacher_name", nullable = false)
    private String teacherName;

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
     * 手机
     */
    // === 新增部分开始 ===
    /**
     * 学院名称 (非数据库字段，仅用于前端展示)
     */
    @Transient // 告诉JPA这不是数据库字段
    private String collegeName;

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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
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

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}