package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.pojo.Category;
import java.util.List;

/**
 * @author arbonkeep
 * @date 2020/5/13 - 15:54
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId, String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
