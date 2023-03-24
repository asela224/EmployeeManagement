package lk.gov.nw.cs.EmployeeManagement.configuration;

import lk.gov.nw.cs.EmployeeManagement.dto.request.EmployeeSaveRequestDTO;
import lk.gov.nw.cs.EmployeeManagement.entity.EmployeePersonal;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class ModelMapperConfig {

        @Bean
        public ModelMapper modelMapper(){
            ModelMapper modelMapper=new ModelMapper();

          //  modelMapper.getConfiguration().setFullTypeMatchingRequired(true);
            return  modelMapper;
        }

    }

