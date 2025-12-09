package com.example.DoAnThucTapTest;

import com.example.DoAnThucTapTest.dao.AppDAO;
import com.example.DoAnThucTapTest.entity.Category;
import com.example.DoAnThucTapTest.entity.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoAnThucTapTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoAnThucTapTestApplication.class, args);
	}
//    @Bean
//    public CommandLineRunner cammandLineRunner(AppDAO appDAO){
//        return runner->{
//            createCategoryWithProduct(appDAO);
//        };
//    }
//
//    private void createCategoryWithProduct(AppDAO appDAO) {
//        Category tempCategory = new Category("SanPhamMoi","abc.png",1);
//        Product tempProduct = new Product("abc","abc.png","bac","abc",123,tempCategory,1);
//        tempCategory.add(tempProduct);
//        appDAO.save(tempCategory);
//        System.out.println("Da xong");
//    }

}
