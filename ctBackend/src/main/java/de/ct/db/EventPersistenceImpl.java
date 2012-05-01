package de.ct.db;

import java.sql.Array;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import de.ct.shared.Event;

public class EventPersistenceImpl extends Persistence implements
		EventPersistence {

	private Event mapTable2Event(ResultSet rs) throws NumberFormatException,
			SQLException {
		Event event = new Event();
		event.setEventId(Long.valueOf(rs.getString(1)));
		event.setCreatorId(Long.valueOf(rs.getString(2)));
		event.setDate(sqlDate2GregorianCalendar(rs.getDate(3)));
		event.setEventname(rs.getString(4));
		event.setOccasion(rs.getString(5));
		event.setLocation(rs.getString(6));
		Array array = rs.getArray(7);
		ResultSet resultSet = array.getResultSet();
		List<String> obj = new ArrayList<String>();
		if (resultSet.next()) {
			String a = resultSet.getString(1);
			obj.add(a);
			event.setGps(obj);
		}

		event.setDescription(rs.getString(8));

		event.setNumberMaleConfirmed(rs.getInt(9));
		event.setNumberFemaleConfirmed(rs.getInt(10));

		return event;
	}

	@Override
	public Event read(final long aEventId) {
		Event event = null;
		String selectSQL = "select eventId, creatorId, date, eventname, occasion, location, gps, description, numberMaleConfirmed, numberFemaleConfirmed from public.Event where eventId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, (int) aEventId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				event = mapTable2Event(rs);
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
		return event;
	}

	private void mapEvent2Table(Event aEvent) throws SQLException {
		preparedStatement.setInt(1, (int) aEvent.getEventId());
		preparedStatement.setInt(2, (int) aEvent.getCreatorId());
		preparedStatement.setDate(3, utilDate2sqlDate(aEvent.getDate()
				.getTime()));
		preparedStatement.setString(4, aEvent.getEventname());
		preparedStatement.setString(5, aEvent.getOccasion());
		preparedStatement.setString(6, aEvent.getLocation());

		List<String> yourList = aEvent.getGps();
		String[] data = yourList.toArray(new String[yourList.size()]);
		Array array = dbConnection.createArrayOf("varchar", data);

		preparedStatement.setArray(7, array);

		preparedStatement.setString(8, aEvent.getDescription());
		preparedStatement.setInt(9, aEvent.getNumberMaleConfirmed());
		preparedStatement.setInt(10, aEvent.getNumberFemaleConfirmed());
	}

	@Override
	public void update(final Event aEvent) {
		String insertTableSQL = "Insert into public.Event"
				+ "(eventId, creatorId, date, eventname, occasion, location, gps, description, numberMaleConfirmed, numberFemaleConfirmed)"
				+ "values (?,?,?,?,?,?,?,?,?,?)";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			mapEvent2Table(aEvent);
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
	public void delete(final Event aEvent) {
		long eventId = aEvent.getEventId();
		String deleteSQL = "DELETE From public.Event WHERE eventId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, (int) eventId);
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