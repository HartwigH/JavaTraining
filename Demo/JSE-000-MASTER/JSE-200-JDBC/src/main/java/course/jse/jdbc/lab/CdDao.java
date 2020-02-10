package course.jse.jdbc.lab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import course.jse.jdbc.utils.DbUtils;

public class CdDao {

	public void saveCd(Cd newCd) {
		Connection conn = null;

		try {
			conn = DbUtils.createConnection("demo");

			Statement cmd = conn.createStatement();
			String sql = "INSERT INTO `cd` " + "( `Artist`, " + "`Company`, " + "`Price`, " + "`Title`, "
					+ "`Country`, " + "`Year`, " + "`Quantity`, " + "`Version`) " + "VALUES(" + "'" + newCd.getArtist()
					+ "', " + "'" + newCd.getCompany() + "', " + newCd.getPrice() + ", " + "'" + newCd.getTitle()
					+ "', " + "'" + newCd.getCountry() + "', " + newCd.getYear() + ", " + newCd.getQuantity() + ", "
					+ newCd.getVersion() + ") ";

			System.out.println("TEMPLATE: " + sql);

			int rowsUpdated = cmd.executeUpdate(sql);

			System.out.println("RESPONSE: Updated '" + rowsUpdated + "' row's in Cd Table");

		} catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}

	}

	public Cd findById(Long id) {
		Connection conn = null;
		Cd found = null;

		try {
			conn = DbUtils.createConnection("demo");

			Statement cmd = conn.createStatement();
			String sql = "select * from cd where id= " + id;

			System.out.println("TEMPLATE: " + sql);

			ResultSet res = cmd.executeQuery(sql);

			if (res.next()) {
				found = new Cd();
				found.setArtist(res.getString("Artist"));
				found.setCompany(res.getString("company"));
				found.setCountry(res.getString("country"));
				found.setId(res.getLong("id"));
				found.setPrice(res.getDouble("price"));
				found.setQuantity(res.getInt("quantity"));
				found.setTitle(res.getString("title"));
				found.setVersion(res.getLong("version"));
				found.setYear(res.getInt("year"));
			}

		} catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}
		return found;
	}

	public void deleteCd(Long id) {
		Connection conn = null;

		try {
			conn = DbUtils.createConnection("demo");

			Statement cmd = conn.createStatement();
			String sql = "DELETE FROM `cd` WHERE id=" + id + ";";

			System.out.println("TEMPLATE: " + sql);

			cmd.executeUpdate(sql);

			System.out.println("RESPONSE: Deleted row in Cd Table at id: " + id);

		} catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}

	}

	public void updateCd(Long id, String columnToChange, String newValue) {
		Connection conn = null;

		try {
			conn = DbUtils.createConnection("demo");
			Statement cmd = conn.createStatement();

			cmd = conn.createStatement();
			String sql = "UPDATE `cd` SET " + columnToChange + "='" + newValue + "' WHERE id=" + id + ";";
			System.out.println("TEMPLATE: " + sql);
			int rowsUpdated = cmd.executeUpdate(sql);
			System.out.println("RESPONSE: Updated " + rowsUpdated + " row in Cd Table at id: " + id);

		} catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}
	}

	public List<Cd> findByPrice(double price) {
		Connection conn = null;
		Cd found = null;
		List<Cd> cdList = new ArrayList<Cd>();

		try {

			conn = DbUtils.createConnection("demo");

			Statement cmd = conn.createStatement();
			String sql = "select * from cd where Price= " + price;

			System.out.println("TEMPLATE: " + sql);

			ResultSet res = cmd.executeQuery(sql);

			while (res.next()) {

				found = new Cd();
				found.setArtist(res.getString("Artist"));
				found.setCompany(res.getString("company"));
				found.setCountry(res.getString("country"));
				found.setId(res.getLong("id"));
				found.setPrice(res.getDouble("price"));
				found.setQuantity(res.getInt("quantity"));
				found.setTitle(res.getString("title"));
				found.setVersion(res.getLong("version"));
				found.setYear(res.getInt("year"));

				cdList.add(found);
			}

		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			DbUtils.closeConnection(conn);
		}
		return (cdList);
	}

	public long findLastRecordId() {
		Connection conn = null;
		long lastRecordId = 0;

		try {
			conn = DbUtils.createConnection("demo");

			Statement cmd = conn.createStatement();
			String sql = "SELECT * FROM cd ORDER BY Id DESC LIMIT 1";

			System.out.println("TEMPLATE: " + sql);

			ResultSet res = cmd.executeQuery(sql);

			if (res.next()) {
				lastRecordId = res.getLong("id");
			}

			System.out.println("RESPONSE: Last record id is: " + lastRecordId);

		} catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}

		return lastRecordId;
	}
}
