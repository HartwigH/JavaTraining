package course.jse.jdbc.salesFinder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import course.jse.jdbc.utils.DbUtils;

public class ProductDao {
	/*
	 * readProducts - 1  
	 * readProductsVisible - 2  
	 * readProductsUnvisible - 3 
	 * readProductIdByCol - 4  
	 * readProductIdByRecent - 5  
	 * editProductVisibilityById - 6
	 * createNewProduct - 7
	 */

	// 1
	public List<Product> readProducts() {
		Connection conn = null;
		Product found = null;
		List<Product> productList = new ArrayList<Product>();

		try {

			conn = DbUtils.createConnection("Sf");

			Statement cmd = conn.createStatement();
			String sql = "select * from product";

			System.out.println("TEMPLATE: " + sql);

			ResultSet res = cmd.executeQuery(sql);

			while (res.next()) {

				found = new Product();
				found.setId(res.getInt("product_id"));
				found.setName(res.getString("product_name"));
				found.setUrl(res.getString("product_url"));
				found.setImgUrl(res.getString("product_img_url"));
				found.setDataId(res.getString("product_data_id"));
				found.setVisibility(res.getInt("product_visibility"));
				found.setStoreId(res.getInt("store_id"));

				productList.add(found);
			}

		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			DbUtils.closeConnection(conn);
		}

		return (productList);
	}

	// 2
	public List<Product> readProductsVisible() {
		Connection conn = null;
		Product found = null;
		List<Product> productList = new ArrayList<Product>();

		try {

			conn = DbUtils.createConnection("Sf");

			Statement cmd = conn.createStatement();
			String sql = "select * from product where product_visibility = 1";

			System.out.println("TEMPLATE: " + sql);

			ResultSet res = cmd.executeQuery(sql);

			while (res.next()) {

				found = new Product();
				found.setId(res.getInt("product_id"));
				found.setName(res.getString("product_name"));
				found.setUrl(res.getString("product_url"));
				found.setImgUrl(res.getString("product_img_url"));
				found.setDataId(res.getString("product_data_id"));
				found.setVisibility(res.getInt("product_visibility"));
				found.setStoreId(res.getInt("store_id"));

				productList.add(found);
			}

		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			DbUtils.closeConnection(conn);
		}

		return (productList);
	}

	// 3
	public List<Product> readProductsUnvisible() {
		Connection conn = null;
		Product found = null;
		List<Product> productList = new ArrayList<Product>();

		try {

			conn = DbUtils.createConnection("Sf");

			Statement cmd = conn.createStatement();
			String sql = "select * from product where product_visibility = 0";

			System.out.println("TEMPLATE: " + sql);

			ResultSet res = cmd.executeQuery(sql);

			while (res.next()) {

				found = new Product();
				found.setId(res.getInt("product_id"));
				found.setName(res.getString("product_name"));
				found.setUrl(res.getString("product_url"));
				found.setImgUrl(res.getString("product_img_url"));
				found.setDataId(res.getString("product_data_id"));
				found.setVisibility(res.getInt("product_visibility"));
				found.setStoreId(res.getInt("store_id"));

				productList.add(found);
			}

		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			DbUtils.closeConnection(conn);
		}

		return (productList);
	}

	// 4
	public int readProductIdByCol(String name, String dataId) {
		Connection conn = null;
		int productId = 0;

		try {

			conn = DbUtils.createConnection("Sf");
			
			PreparedStatement sql = conn.prepareStatement("select product_id from product where product_name = ? and product_data_id = ?");
            sql.setString(1, name);
            sql.setString(2, dataId);
            
			System.out.println("TEMPLATE: " + sql);

			ResultSet res = sql.executeQuery();

			if (res.next()) {
				productId = (res.getInt("product_id"));
			}

		}

		catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();

		} finally {
			DbUtils.closeConnection(conn);
		}

		return productId;
	}

	// 5
	public int readProductIdByRecent() {
		Connection conn = null;
		int productId = 0;

		try {
			conn = DbUtils.createConnection("Sf");

			Statement cmd = conn.createStatement();
			String sql = "select * from product order by product_id desc limit 1";

			System.out.println("TEMPLATE: " + sql);

			ResultSet res = cmd.executeQuery(sql);

			if (res.next()) {
				productId = res.getInt("product_id");
			}

		} catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}

		return productId;
	}

	// 6
	public void editProductVisibilityById(int productId, int option) {
		Connection conn = null;

		try {
			conn = DbUtils.createConnection("Sf");
			
			PreparedStatement sql = conn.prepareStatement("update `product` set product_visibility= ? where product_id = ?;");
            sql.setInt(1, option);
            sql.setInt(2, productId);

			sql.executeUpdate();

			System.out.println("RESPONSE: Updated, product (id: " + productId + ") visibility set to " + option);

		} catch (Exception e) {

			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}

	}

	// 7
	public void createNewProduct(Product newProduct) {
		Connection conn = null;

		try {
			conn = DbUtils.createConnection("Sf");
			
			PreparedStatement sql = conn.prepareStatement("insert into `product` (product_name, product_url, product_img_url, product_data_id, product_visibility, store_id) "
					+ "values (?,?,?,?,?,?);");
            sql.setString(1, newProduct.getName());
            sql.setString(2, newProduct.getUrl());
            sql.setString(3, newProduct.getImgUrl());
            sql.setString(4, newProduct.getDataId());
            sql.setInt(5, newProduct.getVisibility());
            sql.setInt(6, newProduct.getStoreId());

			System.out.println("TEMPLATE: " + sql);

			sql.executeUpdate();


		} catch (Exception e) {
			System.err.println("Impossible to connect to Database");
			e.printStackTrace();
		} finally {
			DbUtils.closeConnection(conn);
		}
	}

}
