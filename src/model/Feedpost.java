package model;

public class Feedpost {
	private Bhpost post;
	private String gravatar;
	
	
	public Feedpost(){
	}
	public Bhpost getPost() {
		return post;
	}
	public void setPost(Bhpost post) {
		this.post = post;
	}
	public String getGravatar() {
		return gravatar;
	}
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}
}
