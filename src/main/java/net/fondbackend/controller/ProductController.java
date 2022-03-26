package net.fondbackend.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import net.fondbackend.dto.ProductResponse;
import net.fondbackend.service.products.ProductMainPageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductMainPageService productMainPageService;

    @GetMapping("main-page/product-line")
    public ResponseEntity<List<ProductResponse>> getProject() {
        return new ResponseEntity<>(productMainPageService.getProductsInfoForMainPage(), HttpStatus.OK);
    }

}
