package com.shiro.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:application.xml"})
public class TestMapperTest {
	@Resource
	private TestMapper dao;

	/**
	 * 所以字段必须都要插入
	 */
	@Test
	public void insert() {
		com.shiro.bean.Test test=new com.shiro.bean.Test();
		test.setAge(12);
		test.setName("刘飞");
		test.setId(1);
		System.out.println(dao.insert(test));
	}

	/**
	 * 可以只插入需要的字段
	 */
	@Test
	public void insertSelective(){
		com.shiro.bean.Test test=new com.shiro.bean.Test();
		test.setAge(15);
		test.setName("李飞");
		test.setId(2);
		System.out.println(dao.insertSelective(test));
	}

	/**
	 * 根据id删除信息
	 */
	@Test
	public void deleteByPrimaryKey(){
		System.out.println(dao.deleteByPrimaryKey(1));
	}

	/**
	 * 根据id查询信息
	 */
	@Test
	public void selectByPrimaryKey(){
		com.shiro.bean.Test test=dao.selectByPrimaryKey(1);
		System.out.println(test);
	}

	/**
	 * 修改信息要修改的字段可以任意
	 */
	@Test
	public void updateByPrimaryKeySelective(){
		com.shiro.bean.Test test=new com.shiro.bean.Test();
		test.setId(1);
		test.setAge(16);
		System.out.println(dao.updateByPrimaryKeySelective(test));
	}
	/**
	* @Author liufei
	* @Description 修改信息所以字段必须都要填写
	* @Date 11:38 2018/11/30
	* @Param []
	* @return void
	**/
	@Test
	public void updateByPrimaryKey(){
		com.shiro.bean.Test test=new com.shiro.bean.Test();
		test.setId(2);
		test.setAge(25);
		test.setName("李腾飞");
		System.out.println(dao.updateByPrimaryKey(test));
	}

}