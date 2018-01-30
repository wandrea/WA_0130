package hu.helixlab.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "note", schema = "public")
public class Note implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Note{" +
				"id=" + id +
				", text='" + text + '\'' +
				'}';
	}
}
