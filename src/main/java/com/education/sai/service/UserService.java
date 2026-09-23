package com.education.sai.service;

import com.education.sai.model.User;
import com.education.sai.repo.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;


    public UserService(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }


    public List<User> findUser() {
        return userRepository.findAll();
    }

    public Page<User> getUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    @Transactional
    public void saveUsersFromExcel(MultipartFile file) {
        final int BATCH_SIZE = 100;
        try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                User user = new User();
                user.setUsername(row.getCell(0).getStringCellValue());
                user.setEmail(row.getCell(1).getStringCellValue());
                entityManager.persist(user);
                count++;
                if (count % BATCH_SIZE == 0) {
                    entityManager.flush();
                    entityManager.clear();
                }
            }
            entityManager.flush();
            entityManager.clear();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
