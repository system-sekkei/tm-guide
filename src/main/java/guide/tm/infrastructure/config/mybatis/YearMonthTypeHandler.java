package guide.tm.infrastructure.config.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.YearMonth;

@MappedTypes(YearMonth.class)
public class YearMonthTypeHandler implements TypeHandler<YearMonth> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int index, YearMonth parameter, JdbcType jdbcType) throws SQLException {
        preparedStatement.setObject(index, parameter, Types.OTHER);
    }

    @Override
    public YearMonth getResult(ResultSet resultSet, String columnName) throws SQLException {
        return toYearMonth(resultSet.getString(columnName));
    }

    @Override
    public YearMonth getResult(ResultSet resultSet, int columnIndex) throws SQLException {
        return toYearMonth(resultSet.getString(columnIndex));
    }

    @Override
    public YearMonth getResult(CallableStatement callableStatement, int columnIndex) throws SQLException {
        return toYearMonth(callableStatement.getString(columnIndex));
    }

    private static YearMonth toYearMonth(String value) {
        return YearMonth.parse(value.substring(0, 7));
    }

}