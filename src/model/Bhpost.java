package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BHPOST database table.
 * 
 */
@Entity
@NamedQuery(name="Bhpost.findAll", query="SELECT b FROM Bhpost b")
public class Bhpost implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BHPOST_POSTID_GENERATOR", sequenceName="BHPOST_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BHPOST_POSTID_GENERATOR")
	private long postid;

	private BigDecimal mood;

	@Temporal(TemporalType.DATE)
	private Date postdate;

	private String posttext;

	//bi-directional many-to-one association to Bhpost
	@ManyToOne
	@JoinColumn(name="PARENTPOSTID")
	private Bhpost bhpost;

	//bi-directional many-to-one association to Bhpost
	@OneToMany(mappedBy="bhpost")
	private List<Bhpost> bhposts;

	//bi-directional many-to-one association to Bhuser
	@ManyToOne
	@JoinColumn(name="BHUSERID")
	private Bhuser bhuser;

	public Bhpost() {
	}

	public long getPostid() {
		return this.postid;
	}

	public void setPostid(long postid) {
		this.postid = postid;
	}

	public BigDecimal getMood() {
		return this.mood;
	}

	public void setMood(BigDecimal mood) {
		this.mood = mood;
	}

	public Date getPostdate() {
		return this.postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public String getPosttext() {
		return this.posttext;
	}

	public void setPosttext(String posttext) {
		this.posttext = posttext;
	}

	public Bhpost getBhpost() {
		return this.bhpost;
	}

	public void setBhpost(Bhpost bhpost) {
		this.bhpost = bhpost;
	}

	public List<Bhpost> getBhposts() {
		return this.bhposts;
	}

	public void setBhposts(List<Bhpost> bhposts) {
		this.bhposts = bhposts;
	}

	public Bhpost addBhpost(Bhpost bhpost) {
		getBhposts().add(bhpost);
		bhpost.setBhpost(this);

		return bhpost;
	}

	public Bhpost removeBhpost(Bhpost bhpost) {
		getBhposts().remove(bhpost);
		bhpost.setBhpost(null);

		return bhpost;
	}

	public Bhuser getBhuser() {
		return this.bhuser;
	}

	public void setBhuser(Bhuser bhuser) {
		this.bhuser = bhuser;
	}

}