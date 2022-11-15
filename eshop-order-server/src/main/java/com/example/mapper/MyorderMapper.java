package com.example.mapper;

import com.example.entity.Myorder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author baomidou
 * @since 2022-10-15
 */
public interface MyorderMapper extends BaseMapper<Myorder> {
    int saveOrder(Myorder myOrder);
    Myorder getByOrdId(int orderId);
}
