USE sales_inventory_db;
GO

-- roles --
INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('STAFF');

-- users --
INSERT INTO users (username, password, role_id)
VALUES
('admin', '$2a$10$examplehashedpassword', 1),
('staff1', '$2a$10$examplehashedpassword', 2);

-- categories --
INSERT INTO categories (name, description)
VALUES
('Electronics', 'Electronic devices and gadgets'),
('Accessories', 'Computer and device accessories');

-- products --
INSERT INTO products (name, sku, category_id, price, cost, stock_quantity)
VALUES
('Laptop Pro 14', 'LTP-001', 1, 1500.00, 1200.00, 10),
('Wireless Mouse', 'MSE-001', 2, 25.00, 10.00, 50),
('Mechanical Keyboard', 'KEY-001', 2, 80.00, 50.00, 30);

-- sales --
INSERT INTO sales 
(invoice_number, sale_date, subtotal, tax, discount, total_amount, created_by)
VALUES 
('INV-2026-001', GETDATE(), 1550.00, 155.00, 0.00, 1705.00, 2);

-- sales items --
INSERT INTO sale_items (sale_id, product_id, quantity, price, total_price)
VALUES
(1, 1, 1, 1500.00, 1500.00),
(1, 2, 2, 25.00, 50.00);

-- inventory logs --
INSERT INTO inventory_logs 
(product_id, change_type, quantity_before, quantity_after, reference_id, reference_type)
VALUES
(1, 'SALE', 10, 9, 1, 'SALE'),
(2, 'SALE', 50, 48, 1, 'SALE');