package module01.hashmap;

import java.util.Set;

import org.junit.Test;

import ch.fhnw.oop2.module01.Person;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * @author Dieter Holz
 */
public class FamilyTest {

	@Test
	public void testNumberOfMembers() throws Exception {
		//given
		Family family  = new Family();
		Person personA = new Person(30, 50, 1.70);
		Person personB = new Person(35, 45, 1.60);
		Person personC = new Person(35, 40, 1.80);
		family.add(personA);
		family.add(personB);
		family.add(personC);

		//when
		int count20 = family.numberOfMembers(20);
		int count35 = family.numberOfMembers(35);
		int count30 = family.numberOfMembers(30);

		//then
		assertSame(0, count20);
		assertSame(2, count35);
		assertSame(1, count30);
	}

	@Test
	public void testAllAges() {
		//given
		Family family  = new Family();
		Person personA = new Person(30, 50, 1.70);
		Person personB = new Person(35, 45, 1.60);
		Person personC = new Person(35, 40, 1.80);
		family.add(personA);
		family.add(personB);
		family.add(personC);

		//when
		Set<Integer> ages = family.allAges();

		//then
		assertTrue(ages.size() == 2);
		ages.contains(30);
		ages.contains(35);
	}
}