package com.bk.junit;

public class UserService {
	private UserDao userDao;
	private AddressDao addressDao;

	public UserService(UserDao userDao, AddressDao addressDao) {
		this.userDao = userDao;
		this.addressDao = addressDao;
	}

	public void addUserAndAddress(User user, Address address) {
		if (user.name == null || user.name.isEmpty()) {
			throw new RuntimeException("User name required!");
		}
		userDao.addNewUser(user);

		try {
			if ((address.street == null || address.street.isEmpty())
					|| (address.state == null || address.state.isEmpty())) {
				throw new RuntimeException("Address street and state are required!");
			}
			addressDao.addNewAddress(address);
		} catch (Exception e) {
			userDao.rollbackAddUser(user);
			throw e;
		}
	}

	static class User {
		private String name;

		public User(String name) {
			this.name = name;
		}
	}

	static class Address {
		private String street;
		private String state;

		public Address(String street, String state) {
			this.street = street;
			this.state = state;
		}

	}

	class UserDao {
		public int addNewUser(User user) {
			// returns id if user doesn't exist
			return 1;
		}

		public void rollbackAddUser(User user) {

		}
	}

	class AddressDao {
		public int addNewAddress(Address address) {
			// returns id if address doesn't exist
			return 1;
		}
	}
}