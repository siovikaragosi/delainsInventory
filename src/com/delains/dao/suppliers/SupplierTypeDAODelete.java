package com.delains.dao.suppliers;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.delains.dao.utils.DBUtils;

public class SupplierTypeDAODelete {

	public static void deleteSupplierType(BigDecimal id) {
		PreparedStatement preparedStatement = null;
		Connection connection = DBUtils.connect();

		try {

			preparedStatement = connection
					.prepareStatement(DBUtils.getDeleteCommandString("supplier_type", "WHERE id=?"));

			preparedStatement.setBigDecimal(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeConnections(connection, preparedStatement, null);
		}
	}

}
