package lk.ise.pos.dao;

import lk.ise.pos.DB.DBConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

public class CURD_util {

    public static <T> T execute(String sql, Object...params) throws SQLException, ClassNotFoundException {

        PreparedStatement pstm = DBConnection.getInstance().getConnection().prepareStatement(sql);

        for (int i=0;i<params.length;i++) {
            pstm.setObject((i+1),params[i]);
        }
        if (sql.startsWith("SELECT")) {
            return (T) pstm.executeQuery();
        }
        return (T)(Boolean)(pstm.executeUpdate()>0);
    }

}
