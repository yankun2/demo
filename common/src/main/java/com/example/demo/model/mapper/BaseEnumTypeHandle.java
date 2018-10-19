package com.example.demo.model.mapper;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description: 基础枚举类转换typeHandle
 * @Author: yankun
 * @Date: 2018-10-10 11:17
 */
public class BaseEnumTypeHandle<E extends Enum<E>> extends BaseTypeHandler<E> {

    private Class<E> type;

    public BaseEnumTypeHandle(Class<E> type) {
        this.type = type;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if(jdbcType == null){
            ps.setString(i,parameter.toString());
        }else{
            ps.setObject(i,parameter.toString(),jdbcType.TYPE_CODE);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return get(rs.getString(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return get(rs.getString(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return get(cs.getString(columnIndex));
    }

    private E get(String v) {
        if (v == null){
            return null;
        }
        if (StringUtils.isNumeric(v)) {
            return get(this.type, Integer.parseInt(v));
        } else {
            return Enum.valueOf(this.type, v);
        }
    }

    private <E extends Enum<E>> E get(Class<E> type, int v) {
        Method method = null;
        E result = null;
        try {
            method = type.getMethod("get", int.class);
            result = (E)method.invoke(type, v);
        } catch (NoSuchMethodException e) {
            result = Enum.valueOf(type, String.valueOf(v));
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return result;
    }

}
