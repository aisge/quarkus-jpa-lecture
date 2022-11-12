package at.htl.boundary;

import at.htl.model.Article;
import at.htl.model.Comment;
import at.htl.repository.ArticleRepository;
import at.htl.repository.CommentRepository;
import at.htl.repository.UserRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URL;
import java.util.List;

@Path("/api/article")
@Produces(MediaType.APPLICATION_JSON)
public class ArticleResource {

    @Inject
    ArticleRepository articleRepository;

    @Inject
    UserRepository userRepository;
    
    @Inject
    CommentRepository commentRepository;

    @GET
    @Path("{id}")
    public Article getArticleById(@PathParam("id") long articleId) {
        return articleRepository.getById(articleId);
    }

    @GET
    @Path("list/{userid}")
    public List<Article> getListByAuthorId(@PathParam("userid") long userId) {
        return articleRepository.getListByUserId(userId);
    }


    @GET
    @Path("comment/{commentid}")
    public Comment getComment(@PathParam("commentid") long id) {
        return commentRepository.getById(id);
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("comment")
    public Response saveComment(Comment comment, @Context UriInfo context) {
        comment.setArticle(articleRepository.getById(comment.getArticle().getId()));
        comment.setUser(userRepository.getById(comment.getUser().getUserid()));
        commentRepository.saveComment(comment);

        URI uri = context.getAbsolutePathBuilder().path(Long.toString(comment.getId())).build();
        return Response.created(uri).build();
    }
}
