package com.warning.warning_system.service;

import com.warning.warning_system.dto.LoginRequest;
import com.warning.warning_system.entity.Administrator;
import com.warning.warning_system.entity.Counsellor;
import com.warning.warning_system.entity.Student;
import com.warning.warning_system.entity.Teacher;
import com.warning.warning_system.repository.AdministratorRepository;
import com.warning.warning_system.repository.CounsellorRepository;
import com.warning.warning_system.repository.StudentRepository;
import com.warning.warning_system.repository.TeacherRepository;
import com.warning.warning_system.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    // 注入Repository
    @Autowired private StudentRepository studentRepo;
    @Autowired private TeacherRepository teacherRepo;
    @Autowired private AdministratorRepository adminRepo;
    @Autowired private CounsellorRepository counsellorRepo;
    @Autowired private JwtUtil jwtUtil;

    public Map<String, Object> login(LoginRequest request) {
        String dbPassword = null;
        String name = "";

        // 根据角色去查对应的表
        switch (request.getRole()) {
            case "student":
                Student s = studentRepo.findById(request.getUsername()).orElse(null);
                if (s != null) { dbPassword = s.getPassword(); name = s.getStudentName(); }
                break;
            case "teacher":
                Teacher t = teacherRepo.findById(request.getUsername()).orElse(null);
                if (t != null) { dbPassword = t.getPassword(); name = t.getTeacherName(); }
                break;
            case "counsellor":
                Counsellor c = counsellorRepo.findById(request.getUsername()).orElse(null);
                if (c != null) { dbPassword = c.getPassword(); name = c.getCounsellorName(); }
                break;
            case "administrator":
                Administrator a = adminRepo.findById(request.getUsername()).orElse(null);
                if (a != null) { dbPassword = a.getPassword(); name = "管理员"; }
                break;
            default:
                throw new RuntimeException("角色错误");
        }

        // 验证密码
        if (dbPassword != null && dbPassword.equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername().toString(), request.getRole());
            Map<String, Object> result = new HashMap<>();
            result.put("token", token);
            result.put("name", name);
            result.put("role", request.getRole());
            return result;
        } else {
            throw new RuntimeException("用户名或密码错误");
        }
    }
}