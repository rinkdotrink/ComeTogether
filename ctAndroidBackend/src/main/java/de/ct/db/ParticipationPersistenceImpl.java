package de.ct.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.ct.shared.Participation;

public class ParticipationPersistenceImpl extends Persistence implements
		ParticipationPersistence {

	public List<Participation> getParticipationsForEventId(final long aEventId){
		List<Participation> participations = new ArrayList<Participation>();
		
		
		String selectSQL = "select participationId, userId, eventId from public.Participation where eventId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, (int) aEventId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Participation participation = mapTable2Participation(rs);
				participations.add(participation);
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
		
		return participations;
	}
	
	private Participation mapTable2Participation(ResultSet rs)
			throws NumberFormatException, SQLException {
		Participation participation = new Participation();
		participation.setParticipationId(Long.valueOf(rs.getString(1)));
		participation.setUserId(Long.valueOf(rs.getString(2)));
		participation.setEventId(Long.valueOf(rs.getString(3)));

		return participation;
	}
	
	public List<Participation> getParticipationsForUserId(final long aUserId){
		List<Participation> participations = new ArrayList<Participation>();

		String selectSQL = "select participationId, userId, eventId from public.Participation where userId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, (int) aUserId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Participation participation = mapTable2Participation(rs);
				participations.add(participation);
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
		
		return participations;
	}

	
	@Override
	public void update(final Participation aParticipation) {
		String insertTableSQL = "Insert into public.Participation"
				+ "(participationId, userId, eventId)" + "values (?,?,?)";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			mapParticipation2Table(aParticipation);
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
	public void delete(final Participation aParticipation) {
		long participationId = aParticipation.getParticipationId();
		String deleteSQL = "DELETE From public.Participation WHERE participationId = ?";
		try {
			dbConnection = getDBConnection();
			preparedStatement = dbConnection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, (int) participationId);
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

	private void mapParticipation2Table(Participation aParticipation)
			throws SQLException {
		preparedStatement.setInt(1, (int) aParticipation.getParticipationId());
		preparedStatement.setInt(2, (int) aParticipation.getUserId());
		preparedStatement.setInt(3, (int) aParticipation.getEventId());
	}
}