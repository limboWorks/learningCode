package module01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Dieter Holz
 */
public class PersonTest {

	@Test
	public void testInit() {
		//given
		Person p = new Person(42, 90, 1.85);

		//when
		int age = p.getAge();

		//then
		assertEquals(42, age);
	}

	@Test
	public void testBMI(){
		//given
		Person p = new Person(42, 90, 1.85);

		//when
		double bmi = p.getBMI();

		//then
		assertEquals(26.3, bmi, 0.01);
	}
}
