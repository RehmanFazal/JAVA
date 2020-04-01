package com.CRUDExample.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MainDao {
	private String jdbcUrl;
	private String jdbcUserName;
	private String jdbcPassword;
	private Connection jdbcConnection;

	public MainDao(String jdbcUrl, String jdbcUserName, String jdbcPassword) {
		this.jdbcUrl = jdbcUrl;
		this.jdbcUserName = jdbcUserName;
		this.jdbcPassword = jdbcPassword;
	}

	protected void Connect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcUrl, jdbcUserName, jdbcPassword);
		}
	}

	protected void Disconnect() throws SQLException {
		if (jdbcConnection == null || jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}

	public List<Main> listAllBooks() throws SQLException {
		List<Main> listBook = new ArrayList<Main>();

		String sql = "SELECT * FROM book";

		Connect();

		Statement statement = jdbcConnection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		System.out.println("SSSS");
		System.out.println(resultSet);
		while (resultSet.next()) {
			Main book = new Main();

			book.setId(resultSet.getInt("book_id"));
			book.setTitle(resultSet.getString("title"));
			book.setAuthor(resultSet.getString("author"));
			book.setPrice(resultSet.getFloat("price"));

			listBook.add(book);
		}

		resultSet.close();
		statement.close();

		Disconnect();

		return listBook;
	}

	public void AddBook(int id, String title, String author, float price) {
		try {
			Connect();
			String sql = "";
			PreparedStatement ps;
			if(id > 0) {
				sql = "UPDATE book SET title = ?, author = ?, price = ? WHERE book_id = ?";
				/*
				 * ps = jdbcConnection.prepareStatement(sql); ps.setInt(1, id); ps.setString(2, title);
				 * ps.setString(3, author); ps.setFloat(4, price);
				 */
			} else {
				sql = "INSERT INTO book (title, author, price) VALUES (?, ?, ?)";
			}
			ps = jdbcConnection.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setFloat(3, price);
			if(id > 0) {
				ps.setInt(4, id);
			}
			boolean rowInserted = ps.executeUpdate() > 0;
			if (rowInserted) {
				System.out.println("rowInserted");
				System.out.println(rowInserted);
			}
			ps.close();
			Disconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Main getBook(int id) {
		Main book = null;
		String sql = "SELECT * FROM book WHERE book_id = ?";
		try {
			Connect();
			PreparedStatement statement = jdbcConnection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String title = resultSet.getString("title");
				String author = resultSet.getString("author");
				float price = resultSet.getFloat("price");
				book = new Main(id, title, author, price);
			}
			resultSet.close();
			statement.close();
			Disconnect();
		//} catch (SQLException e) {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Exception Message = "+e.getMessage());
			if(e instanceof SQLException) {
				SQLException se = (SQLException) e;
				System.out.println("Error Code : "+se.getErrorCode());
				System.out.println("SQL State : "+se.getSQLState());
				System.out.println("printStackTrace");
				e.printStackTrace();
			}
		}
		return book;
	}

	public void DeleteBook(int id) {
		String sql = "DELETE FROM book WHERE book_id = ?";
		try {
			Connect();
			PreparedStatement ps = jdbcConnection.prepareStatement(sql);
			ps.setInt(1, id);
			boolean rowDeleted = ps.executeUpdate() > 0;
			if (rowDeleted) {
				System.out.println("rowDeleted");
				System.out.println(rowDeleted);
			}
			ps.close();
			Disconnect();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
