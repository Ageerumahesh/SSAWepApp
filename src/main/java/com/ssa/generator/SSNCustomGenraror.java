package com.ssa.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import com.ssa.res.AppConstants;

public class SSNCustomGenraror implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection conn = null;
		String sql = null;
		ResultSet rs = null;
		Statement stmnt = null;
		Long ssnVaue = 0L;
		conn = session.connection();
		try {
			 stmnt = conn.createStatement();
			 rs = stmnt.executeQuery(AppConstants.CREATE_SEQ_SQL);
			 if(rs.next()) {
				 ssnVaue = rs.getLong(1);
			 }
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ssnVaue;
	}

}
