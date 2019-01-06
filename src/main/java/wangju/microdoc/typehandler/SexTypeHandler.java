package wangju.microdoc.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import wangju.microdoc.enumeration.SexEnum;

import java.sql.*;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    // 设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());

    }

    // 通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        return this.getSexById(sex);
    }

    // 通过下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        return this.getSexById(sex);
    }

    // 根据存储过程获取性别
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        return this.getSexById(sex);
    }

    // 通过id 获取sex枚举类型
    private SexEnum getSexById(int sex){
        if (sex!= 1 && sex != 2){
            return null;
        }
        return SexEnum.getEnumById(sex);
    }
}
