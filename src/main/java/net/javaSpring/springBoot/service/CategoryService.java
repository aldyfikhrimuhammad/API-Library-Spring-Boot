package net.javaSpring.springBoot.service;

import net.javaSpring.springBoot.model.dto.request.BookDto;
import net.javaSpring.springBoot.model.dto.response.ResponseData;

public interface CategoryService {
    ResponseData<Object> addCategory(BookDto request);

    ResponseData<Object> getCategory(Boolean status);
  
    ResponseData<Object> getCategoryById(long id);
  
    ResponseData<Object> updateCategory(long id, BookDto request);
  
    ResponseData<Object> deleteCategory(long id);
}