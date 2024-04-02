package cn.itbaizhan.shop.categorysecond.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itbaizhan.shop.categorysecond.dao.CategorySecondDao;
import cn.itbaizhan.shop.categorysecond.vo.CategorySecond;
import cn.itbaizhan.shop.utils.PageBean;

/**
 * 二级分类的业务层代码
 */
@Transactional
public class CategorySecondService {
	// 注入Dao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	// 二级分类带有分页的查询操作:
	public PageBean<CategorySecond> findByPage(Integer page) {
		PageBean<CategorySecond> pageBean = new PageBean<CategorySecond>();

		// 设置参数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置页面显示数据的集合:
		int begin = (page - 1) * limit;
		List<CategorySecond> list = categorySecondDao.findByPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层的保存二级分类的操作
	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	// 业务层的删除二级分类的操作
	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	// 业务层根据id查询二级分类
	public CategorySecond findByCsid(Integer csid) {
		return categorySecondDao.findByCsid(csid);
	}

	// 业务层修改二级分类的方法
	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	// 业务层查询所有二级分类(不带分页)
	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
