package com.darwing.Assessment.domain.repositories;

import com.darwing.Assessment.domain.entities.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class AddProductsDb {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            List<Product> products = List.of(
                    new Product(null, "Laptop", "High performance laptop with 16GB RAM and 512GB SSD.", 1200.0),
                    new Product(null, "Smartphone", "Latest model smartphone with 128GB storage and high-resolution camera.", 800.0),
                    new Product(null, "Headphones", "Noise-cancelling over-ear headphones with superior sound quality.", 200.0),
                    new Product(null, "Smartwatch", "Feature-rich smartwatch with heart rate monitor and GPS.", 250.0),
                    new Product(null, "Tablet", "10-inch tablet with high-resolution display and 64GB storage.", 300.0),
                    new Product(null, "Camera", "Professional DSLR camera with 24MP sensor and 4K video recording.", 1500.0),
                    new Product(null, "Printer", "All-in-one wireless printer with high-quality printing and scanning.", 150.0),
                    new Product(null, "Monitor", "27-inch 4K UHD monitor with HDR support and ultra-thin bezel.", 400.0),
                    new Product(null, "Keyboard", "Mechanical keyboard with customizable RGB lighting.", 100.0),
                    new Product(null, "Mouse", "Wireless ergonomic mouse with adjustable DPI and long battery life.", 50.0)
            );
            repository.saveAll(products);
        };
    }
}

