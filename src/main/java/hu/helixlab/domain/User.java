package hu.helixlab.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user", schema = "public")
@NamedQuery(query = "select u From User u", name = "getAllUser")
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	private String email;

	@OneToOne
	private Note note;

	//https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Contact> contacts = new HashSet<>();

	//https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
	private Set<Group> groups = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	public Set<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	//Hogy egyesével tudjunk contactot hozzáadni
	public void addContact(Contact c){
		this.contacts.add(c);
	}

	public Set<Group> getGroups() {
		return groups;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	@Override public String toString() {
		return "User{" +
				"id=" + id +
				", email='" + email + '\'' +
				", note=" + note +
				", contacts=" + contacts +
				", groups=" + groups +
				'}';
	}
}
