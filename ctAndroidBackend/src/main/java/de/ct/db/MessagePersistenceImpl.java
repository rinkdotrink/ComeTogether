package de.ct.db;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import de.ct.shared.Message;

public class MessagePersistenceImpl extends Persistence implements
		MessagePersistence {

	@Override
	public Message read(final long aMessageId) {
		Message message = null;

		String selectSQL = "select messageId, eventId, senderId, recipientId, textmessage, date from public.Message where messageId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, (int) aMessageId);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				message = mapTable2Message(rs);
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
		return message;
	}

	private Message mapTable2Message(ResultSet rs)
			throws NumberFormatException, SQLException {
		Message message = new Message();
		message.setMessageId(Long.valueOf(rs.getString(1)));
		message.setEventId(Long.valueOf(rs.getString(2)));
		message.setSenderId(Long.valueOf(rs.getString(3)));
		message.setRecipientId(Long.valueOf(rs.getString(4)));
		message.setTextmessage(rs.getString(5));
		message.setDate(sqlDate2GregorianCalendar(rs.getDate(6)));

		return message;
	}

	private void mapMessage2Table(Message aMessage) throws SQLException {
		preparedStatement.setInt(1, (int) aMessage.getMessageId());
		preparedStatement.setInt(2, (int) aMessage.getEventId());
		preparedStatement.setInt(3, (int) aMessage.getSenderId());
		preparedStatement.setInt(4, (int) aMessage.getRecipientId());
		preparedStatement.setString(5, aMessage.getTextmessage());
		preparedStatement.setDate(6, utilDate2sqlDate(aMessage.getDate()
				.getTime()));
	}

	@Override
	public void update(final Message aMessage) {
		String insertTableSQL = "Insert into public.Message"
				+ "(messageId, eventId, senderId, recipientId, textmessage, date)"
				+ "values (?,?,?,?,?,?)";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			mapMessage2Table(aMessage);
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
	public void delete(final Message aMessage) {
		long messageId = aMessage.getMessageId();
		String deleteSQL = "DELETE From public.Message WHERE messageId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, (int) messageId);
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