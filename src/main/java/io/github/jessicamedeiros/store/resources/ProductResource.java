package io.github.jessicamedeiros.store.resources;

import io.github.jessicamedeiros.store.dto.ProductDTO;
import io.github.jessicamedeiros.store.model.Category;
import io.github.jessicamedeiros.store.model.Product;
import io.github.jessicamedeiros.store.resources.utils.URL;
import io.github.jessicamedeiros.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<Product> find(@PathVariable Integer id){
        Product obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<Page<ProductDTO>> findPage(@RequestParam(value = "name", defaultValue = "") String name,
                                                     @RequestParam(value = "categories", defaultValue = "") String categories,
                                                     @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                      @RequestParam (value = "linesPerPage", defaultValue = "24") Integer linesPerPage, //24 é mais responsivo
                                                      @RequestParam (value = "orderBy", defaultValue = "name") String orderBy,
                                                      @RequestParam (value = "direction", defaultValue = "ASC") String direction){

        String nameDecoded = URL.decodeParam(name);
        List<Integer> ids = URL.decodeIntList(categories);
        Page<Product> list = service.search(nameDecoded, ids, page, linesPerPage, orderBy, direction);
        //vai percorrer a lista e fazer uma operacao para cada elemento da lista
        Page<ProductDTO> listDTO =  list.map(obj -> new ProductDTO(obj));
        return ResponseEntity.ok().body(listDTO);
    }

}
