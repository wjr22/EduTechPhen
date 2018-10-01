package cn.nnu.jyjs.etpweb.service.ServiceImpl;

import cn.nnu.jyjs.etpweb.mapper.CategoryMapper;
import cn.nnu.jyjs.etpweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Project :   etpweb
 * @Time :   9/20/2018 22:19
 * @Auther :   wangj
 * @Description:
 */
@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired(required = false)
    private CategoryMapper categoryMapper;

    @Override
    public int insertCategory(String category) {
        return 0;
    }

    @Override
    public int getId(String category) {
        return categoryMapper.selectByName(category).getCategoryId();
    }
}
