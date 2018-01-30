package hu.helixlab;

import hu.helixlab.domain.Group;
import hu.helixlab.domain.User;
import hu.helixlab.service.GroupService;
import hu.helixlab.service.NoteService;
import hu.helixlab.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserService();
		NoteService noteService = new NoteService();
		GroupService groupService = new GroupService();

		for (int i = 0; i < 10; ++i) {
			User user = new User();
			user.setEmail("example" + i + "@gmail.com");

			Set<Group> groups = new HashSet<>();

			//TODO véletlenszerűen adja hozzá valamelyik vagy mindkettő group-ot
			Group adminGroup = new Group();
			adminGroup.setGroupName("ADMIN");
			groupService.save(adminGroup);
			groups.add(adminGroup);

			Group userGroup = new Group();
			userGroup.setGroupName("USER");
			groupService.save(userGroup);
			groups.add(userGroup);

			user.setGroups(groups);

			userService.save(user);
		}

		for (User u : userService.findAll()) {
			System.out.println(u.toString());
		}

		//		User user = userService.findById(2);
		//
		//		Note note = new Note();
		//		note.setText("megjegyzés");
		//		noteService.save(note);
		//
		//		user.setNote(note);
		//
		//		System.out.println(note.toString());
		//		System.out.println(user.toString());
	}
}
