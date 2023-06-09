package rikkei.academy.service;

import rikkei.academy.model.Product;

import java.util.List;

public interface IProductService extends IGenericService<Product>{
    List<Product> searchProductsByName(String name);
}
