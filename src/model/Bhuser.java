package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the BHUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Bhuser.findAll", query="SELECT b FROM Bhuser b")
public class Bhuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BHUSER_BHUSERID_GENERATOR", sequenceName="BHUSER_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BHUSER_BHUSERID_GENERATOR")
	private long bhuserid;

	@Temporal(TemporalType.DATE)
	private Date joindate;

	private String motto;

	private String useremail;

	private String username;

	private String userpassword;

	//bi-directional many-to-one association to Bhpost
	@OneToMany(mappedBy="bhuser")
	private List<Bhpost> bhposts;

	//bi-directional many-to-many association to Bhuser
	@ManyToMany
	@JoinTable(
		name="BHFOLLOW"
		, joinColumns={
			@JoinColumn(name="FOLLOWER")
			}
		, inverseJoinColumns={
			@JoinColumn(name="FOLLOWING")
			}
		)
	private List<Bhuser> bhusers1;

	//bi-directional many-to-many association to Bhuser
	@ManyToMany(mappedBy="bhusers1")
	private List<Bhuser> bhusers2;

	public Bhuser() {
	}

	public long getBhuserid() {
		return this.bhuserid;
	}

	public void setBhuserid(long bhuserid) {
		this.bhuserid = bhuserid;
	}

	public Date getJoindate() {
		return this.joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public String getMotto() {
		return this.motto;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public List<Bhpost> getBhposts() {
		return this.bhposts;
	}

	public void setBhposts(List<Bhpost> bhposts) {
		this.bhposts = bhposts;
	}

	public Bhpost addBhpost(Bhpost bhpost) {
		getBhposts().add(bhpost);
		bhpost.setBhuser(this);

		return bhpost;
	}

	public Bhpost removeBhpost(Bhpost bhpost) {
		getBhposts().remove(bhpost);
		bhpost.setBhuser(null);

		return bhpost;
	}

	public List<Bhuser> getBhusers1() {
		return this.bhusers1;
	}

	public void setBhusers1(List<Bhuser> bhusers1) {
		this.bhusers1 = bhusers1;
	}

	public List<Bhuser> getBhusers2() {
		return this.bhusers2;
	}

	public void setBhusers2(List<Bhuser> bhusers2) {
		this.bhusers2 = bhusers2;
	}

}