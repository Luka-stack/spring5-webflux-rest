package com.nisshoku.spring5webfluxrest.bootstrap;

import com.nisshoku.spring5webfluxrest.domain.Category;
import com.nisshoku.spring5webfluxrest.domain.Vendor;
import com.nisshoku.spring5webfluxrest.repositories.CategoryRepository;
import com.nisshoku.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {

         if (categoryRepository.count().block() == 0) {
             // load data
             System.out.println("#### LOADING DATA ON BOOTSTRAP ####");

             categoryRepository.save(Category.builder().description("Fruits").build()).block();
             categoryRepository.save(Category.builder().description("Nuts").build()).block();
             categoryRepository.save(Category.builder().description("Breads").build()).block();
             categoryRepository.save(Category.builder().description("Meats").build()).block();
             categoryRepository.save(Category.builder().description("Sweets").build()).block();

             System.out.println("#### Loaded Categoreis: " + categoryRepository.count().block());
         }

         if (vendorRepository.count().block() == 0) {
             // load data
             System.out.println("#### LOADING DATA ON BOOTSTRAP ####");

             vendorRepository.save(Vendor.builder().firstName("Taka").lastName("Hayami").build()).block();
             vendorRepository.save(Vendor.builder().firstName("Ryuki").lastName("Mocchi").build()).block();
             vendorRepository.save(Vendor.builder().firstName("Ayumi").lastName("Sakura").build()).block();
             vendorRepository.save(Vendor.builder().firstName("Hitomi").lastName("Uzumaki").build()).block();

             System.out.println("#### Loaded Vendors: " + vendorRepository.count().block());
         }

    }

}
