package com.bk.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bk.junit.UserService.Address;
import com.bk.junit.UserService.AddressDao;
import com.bk.junit.UserService.User;
import com.bk.junit.UserService.UserDao;

@ExtendWith(MockitoExtension.class)
public class TestUserService {

	@Nested
	class TestWithMethodInjection {
		@Test
		public void testAddNewUserAndAddress(@Mock UserDao userDao, @Mock AddressDao addressDao) {
			when(userDao.addNewUser(any())).thenCallRealMethod();
			when(addressDao.addNewAddress(any())).thenCallRealMethod();
			UserService service = new UserService(userDao, addressDao);

			service.addUserAndAddress(new User("name"), new Address("Street", "ST"));
		}

		@Test
		public void testAddUserWithoutName() {
			UserService service = new UserService(null, null);
			RuntimeException e = assertThrows(RuntimeException.class,
					() -> service.addUserAndAddress(new User(null), null));
			assertEquals("User name required!", e.getMessage());
		}

		@Test
		public void testRollbackAddUserAddressValidationError(@Mock UserDao userDao) {
			when(userDao.addNewUser(any())).thenReturn(1);
			UserService service = new UserService(userDao, null);

			RuntimeException e = assertThrows(RuntimeException.class,
					() -> service.addUserAndAddress(new User("name"), new Address(null, null)));
			assertEquals("Address street and state are required!", e.getMessage());
			verify(userDao, times(1)).rollbackAddUser(any());

		}

		@Test
		public void testRollbackAddUserErrorSavingAddress(@Mock UserDao userDao, @Mock AddressDao addressDao) {
			when(userDao.addNewUser(any())).thenCallRealMethod();
			when(addressDao.addNewAddress(any())).thenThrow(new RuntimeException("Error adding address"));
			UserService service = new UserService(userDao, addressDao);

			assertThrows(RuntimeException.class,
					() -> service.addUserAndAddress(new User("name"), new Address("street", "ST")));
			verify(userDao, times(1)).rollbackAddUser(any());
		}
	}

	@Nested
	class TestWithClassLevelMocks {
		@Mock
		UserDao userDao;
		@Mock
		AddressDao addressDao;

		@Test
		public void testAddNewUserAndAddress() {
			when(userDao.addNewUser(any())).thenCallRealMethod();
			when(addressDao.addNewAddress(any())).thenCallRealMethod();
			UserService service = new UserService(userDao, addressDao);

			service.addUserAndAddress(new User("name"), new Address("Street", "ST"));
		}

		@Test
		public void testAddUserWithoutName() {
			UserService service = new UserService(null, null);
			RuntimeException e = assertThrows(RuntimeException.class,
					() -> service.addUserAndAddress(new User(null), null));
			assertEquals("User name required!", e.getMessage());
		}

		@Test
		public void testRollbackAddUserAddressValidationError() {
			when(userDao.addNewUser(any())).thenReturn(1);
			UserService service = new UserService(userDao, null);

			RuntimeException e = assertThrows(RuntimeException.class,
					() -> service.addUserAndAddress(new User("name"), new Address(null, null)));
			assertEquals("Address street and state are required!", e.getMessage());
			verify(userDao, times(1)).rollbackAddUser(any());

		}

		@Test
		public void testRollbackAddUserErrorSavingAddress() {
			when(userDao.addNewUser(any())).thenCallRealMethod();
			when(addressDao.addNewAddress(any())).thenThrow(new RuntimeException("Error adding address"));
			UserService service = new UserService(userDao, addressDao);

			assertThrows(RuntimeException.class,
					() -> service.addUserAndAddress(new User("name"), new Address("street", "ST")));
			verify(userDao, times(1)).rollbackAddUser(any());
		}
	}
}
