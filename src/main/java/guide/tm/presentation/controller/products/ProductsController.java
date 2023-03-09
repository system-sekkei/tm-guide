package guide.tm.presentation.controller.products;

import guide.tm.application.service.product.single.ProductService;
import guide.tm.domain.model.product.summary.ProductSearchCriteria;
import guide.tm.domain.model.product.summary.ProductSummaries;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
class ProductsController {

    ProductService productService;

    ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    ProductSummaries productSummaries(
            @ModelAttribute("productSearchCriteria") ProductSearchCriteria productSearchCriteria) {

        return productService.searchBy(productSearchCriteria);
    }

    @InitBinder("productSearchCriteria")
    void bindProductSearchCriteria(WebDataBinder binder) {
        binder.setAllowedFields(
                "productName"
        );
    }
}

