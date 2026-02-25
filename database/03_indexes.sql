USE sales_inventory_db;
GO

CREATE INDEX idx_product_name ON products(name);
CREATE INDEX idx_sale_date ON sales(sale_date);

CREATE INDEX idx_inventory_product ON inventory_logs(product_id);
CREATE INDEX idx_sale_items_sale_id ON sale_items(sale_id);

CREATE INDEX idx_sale_items_product_id ON sale_items(product_id);
CREATE INDEX idx_products_category_id ON products(category_id);

CREATE INDEX idx_sales_created_by ON sales(created_by);