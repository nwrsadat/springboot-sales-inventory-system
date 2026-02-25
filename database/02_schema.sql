-- roles --
CREATE TABLE roles (
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	name VARCHAR(50) UNIQUE NOT NULL,
	created_at DATETIME DEFAULT GETDATE()
)

-- users --
CREATE TABLE users (
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	username VARCHAR(100) UNIQUE NOT NULL,
	password VARCHAR(255) NOT NULL,
	role_id BIGINT NOT NULL FOREIGN KEY REFERENCES roles(id),
	created_at DATETIME DEFAULT GETDATE()
)

-- categories --
CREATE TABLE categories (
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	name VARCHAR(100) UNIQUE NOT NULL,
	description VARCHAR(255),
	created_at DATETIME DEFAULT GETDATE()
)

-- products --
CREATE TABLE products (
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	name VARCHAR(150) NOT NULL,
	sku VARCHAR(100) UNIQUE NOT NULL,
	category_id BIGINT NOT NULL FOREIGN KEY REFERENCES categories(id),
	price DECIMAL(15,2) NOT NULL,
	cost DECIMAL(15,2) NOT NULL,
	stock_quantity INT NOT NULL CHECK (stock_quantity >= 0),
	created_at DATETIME DEFAULT GETDATE(),
	updated_at DATETIME
)

-- sales --
CREATE TABLE sales (
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	invoice_number VARCHAR(100) UNIQUE NOT NULL,
	sale_date DATETIME NOT NULL,
	subtotal DECIMAL(15,2) NOT NULL,
	tax DECIMAL(15,2) NOT NULL CHECK (tax >= 0),
	discount DECIMAL(15,2) NOT NULL CHECK (discount >= 0),
	total_amount DECIMAL(15,2) NOT NULL CHECK (total_amount >= 0),
	created_at DATETIME DEFAULT GETDATE(),
	created_by BIGINT NOT NULL FOREIGN KEY REFERENCES users(id),
	updated_at DATETIME
)

-- sale_items --
CREATE TABLE sale_items (
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	sale_id BIGINT NOT NULL FOREIGN KEY REFERENCES sales(id) ON DELETE CASCADE,
	product_id BIGINT NOT NULL FOREIGN KEY REFERENCES products(id),
	quantity INT NOT NULL CHECK (quantity > 0),
	price DECIMAL(15,2) NOT NULL,
	total_price DECIMAL(15,2) NOT NULL
)

-- inventory_logs --
CREATE TABLE inventory_logs (
	id BIGINT PRIMARY KEY IDENTITY(1,1),
	product_id BIGINT NOT NULL FOREIGN KEY REFERENCES products(id),
	change_type VARCHAR(50) NOT NULL CHECK (change_type IN ('SALE', 'ADJUSTMENT', 'PURCHASE')),
	quantity_before INT NOT NULL,
	quantity_after INT NOT NULL,
	reference_id BIGINT NULL,
	reference_type VARCHAR(50),
	created_at DATETIME DEFAULT GETDATE()
)