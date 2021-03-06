DROP TABLE IF EXISTS books;
  
CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  book_name VARCHAR(250) NOT NULL,
  author VARCHAR(250) NOT NULL,
  barcode BIGINT NOT NULL,
  quantity INT NULL,
  price DOUBLE NULL,
  year INT NULL,
  sc_index INT NULL
);