package modernjavaaction.com.dsl.test;

import java.util.ArrayList;
import java.util.List;

public class Post {

	private Long id;
	private String title;
	private List<PostComment> comments = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<PostComment> getComments() {
		return comments;
	}

	public void setComments(List<PostComment> comments) {
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Post addComment(PostComment comment) {
		comments.add(comment);
		comment.setPost(this);

		return this;
	}

	public Post removeComment(PostComment comment) {
		comments.remove(comment);
		comment.setPost(null);

		return this;
	}

}
