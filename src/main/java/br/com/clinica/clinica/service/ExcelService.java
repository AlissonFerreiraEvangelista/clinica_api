package br.com.clinica.clinica.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.clinica.clinica.entity.ExcelEntity;
import br.com.clinica.clinica.helper.ExcelHelper;
import br.com.clinica.clinica.repository.ExcelRespository;

@Service
public class ExcelService {
    @Autowired
    ExcelRespository excelRespository;

    @Transactional
    public void save(MultipartFile file) {
        try {
          List<ExcelEntity> excel = ExcelHelper.excelToTutorials(file.getInputStream());
          excelRespository.saveAll(excel);
        } catch (IOException e) {
          throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
      }
      public List<ExcelEntity> getAllTutorials() {
        return excelRespository.findAll();
      }

      
}
