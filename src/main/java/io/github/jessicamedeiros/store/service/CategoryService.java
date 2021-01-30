package io.github.jessicamedeiros.store.service;

import io.github.jessicamedeiros.store.dto.CategoryDTO;
import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.repository.CategoryRepository;
import io.github.jessicamedeiros.store.service.exceptions.DataIntegrityException;
import io.github.jessicamedeiros.store.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;


    public Category find(Integer id){
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Category.class.getName()));
    }

    public Category create(Category obj) {
        obj.setId(null); //para garantir que será outra Category
        return  repository.save(obj);
    }

    public Category update(Category obj) {
        Category newObj = find(obj.getId());
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    public void delete(Integer id) {
        find(id);
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException ex){
            throw new DataIntegrityException("Not possible to delete a category with Products");
        }
    }


    public List<Category> findAll() {
        return repository.findAll();
    }

    public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }

    public Category fromDTO(CategoryDTO dto){
        return new Category(dto.getId(), dto.getName());
    }

    private void updateData(Category newObj, Category obj) {
        newObj.setName(obj.getName());
    }

}
