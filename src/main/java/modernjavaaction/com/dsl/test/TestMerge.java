package modernjavaaction.com.dsl.test;

import java.util.ArrayList;
import java.util.List;

public class TestMerge {

	public static void main(String[] args) {
		Post post = new Post();
		post.setId(1l);
		post.setTitle("Post");

		PostComment postComment1 = new PostComment();
		postComment1.setId(1l);
		postComment1.setReview("JDBC section is a must read!");
		post.addComment(postComment1);

		PostComment postComment2 = new PostComment();
		postComment2.setId(2l);
		postComment2.setReview("The book size is larger than usual.");
		post.addComment(postComment2);

		PostComment postComment3 = new PostComment();
		postComment3.setId(3l);
		postComment3.setReview("Just half-way through.");
		post.addComment(postComment3);

		PostComment postComment4 = new PostComment();
		postComment4.setId(4l);
		postComment4.setReview("The book has over 450 pages.");
		post.addComment(postComment4);

		System.out.println(post.getComments().size());

		List<PostComment> requestComments = new ArrayList<>();
		PostComment postNewComment1 = new PostComment();
		postNewComment1.setId(1l);
		postNewComment1.setReview("JDBC section is a must read!");
		requestComments.add(postNewComment1);
		PostComment postNewComment5 = new PostComment();
		postNewComment5.setId(5l);
		postNewComment5.setReview("The book has over 450 pages.");
		requestComments.add(postNewComment5);

		// Test merge
		List<PostComment> removedComments = new ArrayList<>(post.getComments());
		removedComments.removeAll(requestComments);

		for (PostComment removedComment : removedComments) {
			post.removeComment(removedComment);
		}

		List<PostComment> newComments = new ArrayList<>(requestComments);
		newComments.removeAll(post.getComments());

		requestComments.removeAll(newComments);

		for (PostComment existingComment : requestComments) {
			existingComment.setPost(post);

			PostComment mergedComment = null;// entityManager.merge(existingComment);

			post.getComments().set(post.getComments().indexOf(mergedComment), mergedComment);
		}

		for (PostComment newComment : newComments) {
			post.addComment(newComment);
		}

	}

}
