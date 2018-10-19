package com.example.demo.model.mapper.handle;

import com.example.demo.enum2.SexEnum;
import com.example.demo.model.mapper.BaseEnumTypeHandle;
import org.apache.ibatis.type.MappedTypes;

/**
 * @Description: ssd
 * @Author: yankun
 * @Date: 2018-10-10 16:10
 */
@MappedTypes(SexEnum.class)
public class EnumTypeHandle<E extends  Enum<E>> extends BaseEnumTypeHandle<E> {

    public EnumTypeHandle(Class<E> type) {
        super(type);
    }
}
