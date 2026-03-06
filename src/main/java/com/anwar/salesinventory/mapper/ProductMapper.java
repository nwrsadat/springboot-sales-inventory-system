package com.anwar.salesinventory.mapper;

import com.anwar.salesinventory.model.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Select("""
        SELECT * FROM products
        WHERE (#{search} = '' OR LOWER(name) LIKE #{search})
        ORDER BY id
        OFFSET #{offset} ROWS
        FETCH NEXT #{size} ROWS ONLY
    """)
    List<Product> findAll(int offset, int size, String search);

    @Select("""
        SELECT COUNT(*) FROM products
        WHERE (#{search} = '' OR LOWER(name) LIKE #{search})
    """)
    int count(String search);
}
