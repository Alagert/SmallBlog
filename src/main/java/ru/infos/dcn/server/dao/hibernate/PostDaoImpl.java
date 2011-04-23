package ru.infos.dcn.server.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import ru.infos.dcn.server.dao.PostDao;
import ru.infos.dcn.server.dao.entity.Post;


public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

    public Post getPostById(Long postId) {
        final Session session = getSessionFactory().getCurrentSession();
        return (Post) session.createCriteria(Post.class).
                add(Restrictions.eq("postId", postId)).
                setMaxResults(1).
                uniqueResult();
    }

    public void updatePost(Post post) {
        getSessionFactory().getCurrentSession().saveOrUpdate(post);
    }
}
