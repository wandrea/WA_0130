package hu.helixlab.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact", schema = "public")
public class Contact implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String contactDescription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContactDescription() {
		return contactDescription;
	}

	public void setContactDescription(String contactDescription) {
		this.contactDescription = contactDescription;
	}

	@Override public String toString() {
		return "Contact{" +
				"id=" + id +
				", contactDescription='" + contactDescription + '\'' +
				'}';
	}
}
