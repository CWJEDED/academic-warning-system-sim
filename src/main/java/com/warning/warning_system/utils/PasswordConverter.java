package com.warning.warning_system.utils;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
// 如果你是 Spring Boot 2.x，请用 import javax.persistence.*;

@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        // 存入数据库时：加密
        return EncryptionUtil.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        // 从数据库读取时：解密
        return EncryptionUtil.decrypt(dbData);
    }
}