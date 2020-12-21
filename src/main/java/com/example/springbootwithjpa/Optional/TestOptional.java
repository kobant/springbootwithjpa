package com.example.springbootwithjpa.Optional;

import com.example.springbootwithjpa.entity.User;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/12 10:04
 */
public class TestOptional {

	@Test(expected = NoSuchElementException.class)
	public void whenCreateEmptyOptional_thenNull(){
		Optional<User> user= Optional.empty();
		user.get();
	}


	//你可以使用  of() 和 ofNullable() 方法创建包含值的 Optional。两个方法的不同之处在于如果你把 null 值作为参数传递进去，of() 方法会抛出 NullPointerException：

	@Test(expected = NullPointerException.class)
	public void whenCreateOfEmptyOptional_thenNullPointerException() {
		User user = new User();
		//Optional<User> opt = Optional.of(user);

		Optional<User> opt = Optional.ofNullable(user);
	}

	@Test
	public void whenCreateOfNullableOptional_thenOk() {
		String name = "John";
		Optional<String> opt = Optional.ofNullable(name);

		assertEquals("John", opt.get());
	}

	/*@Test
	public void whenCheckIfPresent_thenOk() {
		User user = new User("john@gmail.com", "1234");
		Optional<User> opt = Optional.ofNullable(user);
		assertTrue(opt.isPresent());

		assertEquals(user.getEmail(), opt.get().getEmail());
	}*/


}
