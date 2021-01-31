package io.github.jessicamedeiros.store.service;

import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.Product;
import io.github.jessicamedeiros.store.repository.CategoryRepository;
import io.github.jessicamedeiros.store.repository.ProductRepository;
import io.github.jessicamedeiros.store.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository repoCategory;

    public Product find(Integer id){
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Client não encontrado! Id: " + id + ", Tipo: " + Product.class.getName()));

    }

    public Page<Product> search( String name, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        List<Category> categories = repoCategory.findAllById(ids);
        return repository.findDistinctByNameContainingAndCategoriesIn(name, categories, pageRequest);
    }
}
