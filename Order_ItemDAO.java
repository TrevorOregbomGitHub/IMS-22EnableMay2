package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order_Item;
import com.qa.ims.utils.DBUtils;

public class Order_ItemDAO implements Dao<Order_Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Order_Item modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("Order Id");
		Long itemId = resultSet.getLong("Item Id");
		Long orderItemId = resultSet.getLong("Order Item Id");
		
		return new Order_Item(orderId, itemId, orderItemId); 
	}
	
	/**
	 * Reads all from the database
	 * 
	 * @return A list
	 */
	@Override
	public List<Order_Item> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Order_Item> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order_Item readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM order_item and ORDER BY id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Order_Item read(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order_Item create(Order_Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order_Item update(Order_Item t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
