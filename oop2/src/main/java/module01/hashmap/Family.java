package module01.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import module01.Person;

public class Family {

	private Set<Person> members;

	
	public Family() {
		members = new HashSet<>();
		
	}

	public int size() {
		return members.size();
	}

	public void add(Person person) {
		members.add(person);
	}

	public Person getOldest() {
		Person oldest = null;
		for (Person p : members) {
			if (oldest == null || p.getAge() > oldest.getAge()) {
				oldest = p;
			}
		}
		return oldest;
	}

	public boolean isMember(Person person) {
		return members.contains(person);
	}



}
