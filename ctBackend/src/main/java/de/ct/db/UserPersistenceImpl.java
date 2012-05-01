package de.ct.db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import de.ct.shared.User;

public class UserPersistenceImpl extends Persistence implements UserPersistence {

	@Override
	public User read(final long aUserId) {
		User user = null;
		String selectSQL = "select userId, name, email, gender, password, birthday, image from public.User where userId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, (int) aUserId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				user = mapTable2User(rs);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return user;
	}

	@Override
	public void update(final User aUser) {
		String insertTableSQL = "Insert into public.User"
				+ "(userId, name, email, gender, birthday, password, image)"
				+ "values (?,?,?,?,?,?,?)";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			mapUser2Table(aUser);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(final User aUser) {
		long userId = aUser.getUserId();
		String deleteSQL = "DELETE From public.User WHERE userId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, (int) userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (dbConnection != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private User mapTable2User(ResultSet rs)
			throws NumberFormatException, SQLException {
		User user = new User();
		user.setUserId(Long.valueOf(rs.getString(1)));
		user.setName(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setGender(rs.getString(4));
		user.setPassword(rs.getString(5));
		user.setBirthday(sqlDate2GregorianCalendar(rs.getDate(6)));
		user.setImage(rs.getString(7));
		return user;
	}

	private void mapUser2Table(User aUser) throws SQLException {
		preparedStatement.setInt(1, (int) aUser.getUserId());
		preparedStatement.setString(2, aUser.getName());
		preparedStatement.setString(3, aUser.getEmail());
		preparedStatement.setString(4, aUser.getGender());
		preparedStatement.setDate(5, utilDate2sqlDate(aUser.getBirthday().getTime()));
		preparedStatement.setString(6, aUser.getPassword());
		preparedStatement.setString(7, aUser.getImage().toString());
	}

	private GregorianCalendar sqlDate2GregorianCalendar(Date date) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(date);
		return gc;
	}

	private java.sql.Date utilDate2sqlDate(java.util.Date date) {
		long utilDateAsLong = date.getTime();
		java.sql.Date sqlDate = new java.sql.Date(utilDateAsLong);
		return sqlDate;
	}

}