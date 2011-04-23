package ru.infos.dcn.server.dao;


import ru.infos.dcn.server.dao.entity.Post;

public interface PostDao {
    public Post getPostById(Long postId);
    public void updatePost(Post post);
}
