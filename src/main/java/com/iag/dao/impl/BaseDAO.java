package com.iag.dao.impl;

import com.iag.dao.IDAO;
import com.iag.exception.ex.DataBaseException;
import com.iag.util.Conditions;
import com.iag.util.DataPage;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Repository(value = "baseDAO")
public class BaseDAO<T> implements IDAO<T> {
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public Integer save(T bean) throws DataBaseException {
        return (Integer) hibernateTemplate.save(bean);
    }

    public void delete(T bean) throws DataBaseException {
        hibernateTemplate.delete(bean);
    }

    public void update(T bean) throws DataBaseException {
        hibernateTemplate.update(bean);
    }

    public List<T> queryAll(Class<T> clazz) throws DataBaseException{
        String hql = "from " + clazz.getName();
        return (List<T>) hibernateTemplate.find(hql);
    }

    public Object queryByName(Class<T> clazz, String queryName, String value) throws DataBaseException{
        Object obj = null;

        String hql = "from " + clazz.getName() + " bean where bean." + queryName
                + " = '" + value + "'";

        List<T> list = (List<T>) hibernateTemplate.find(hql);

        if (list != null && list.size() > 0) {
            obj = list.get(0);
        }
        return obj;
    }

    public void saveAll(List<Object> list) throws DataBaseException {

		/*if (list != null) {
			hibernateTemplate.saveOrUpdateAll(list);
		} else {
			throw new Exception("saveAll list 不能为空");
		}*/
    }

    public void saveOrUpdate(T bean) throws DataBaseException {
        hibernateTemplate.saveOrUpdate(bean);
    }

    public Object queryById(Class<T> clazz, Serializable id) throws DataBaseException {
        return hibernateTemplate.get(clazz, id);
    }

    /**
     * 分页查询
     *
     * @param page
     * @return 0 查询正常 -1 超出查询范围
     */
    public int page(final DataPage<T> page, Class<T> clazz, Conditions conditions) throws DataBaseException {

        Conditions.WhereAndValues wv = conditions.createWhereAndValues();


        final String hql = "from " + clazz.getName() + wv.getWhere() + conditions.createOrderByString();

        final Object[] values = wv.getValues();

        List<T> result = (List<T>) hibernateTemplate.execute(new HibernateCallback<List<T>>(
        ) {
            public List<T> doInHibernate(Session session)
                    throws HibernateException{
                Query query = session.createQuery(hql);
                query.setFirstResult(page.start());
                query.setMaxResults(page.getLimit());
                int index = 0;
                for (Object obj : values) {
                    query.setParameter(index++, obj);
                }

                return query.list();
            }
        });

        // 设置总行数
        page.setRows(this.countRows(clazz, conditions));
        page.setData(result);

        return 1;
    }

    public int countRows(Class<T> clazz) throws DataBaseException {
        Conditions conditions = new Conditions();
        return countRows(clazz, conditions);
    }

    public int countRows(Class<T> clazz, Conditions conditions) throws DataBaseException {
        List<T> list = this.queryByConditions(clazz, conditions);
        if(list != null){
            return list.size();
        }else{
            return 0;
        }
    }

    public List<T> queryByConditions(Class<T> clazz, Conditions conditions) throws DataBaseException {
        Conditions.WhereAndValues wv = conditions.createWhereAndValues();

        final String hql = "from " + clazz.getName() + wv.getWhere() + conditions.createOrderByString();

        System.out.println("hql = " + hql);

        final Object[] values = wv.getValues();

        @SuppressWarnings({"deprecation", "unchecked"})
        List<T> result = (List<T>) hibernateTemplate.execute(new HibernateCallback<List<T>>() {
            public List<T> doInHibernate(Session session) throws HibernateException{
                Query query = session.createQuery(hql).setCacheable(true);
                int index = 0;
                for (Object obj : values) {
                    query.setParameter(index++, obj);
                }
                return query.list();
            }
        });
        return result;
    }

    public HibernateTemplate getHibernateTemplate() throws DataBaseException {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) throws DataBaseException {
        this.hibernateTemplate = hibernateTemplate;
    }

    public void evit(T bean) throws DataBaseException {
        hibernateTemplate.evict(bean);
    }
}
