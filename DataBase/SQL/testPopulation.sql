INSERT INTO product(id,p_description,number_of_searches,images) VALUES('blanca','blanco mas blando que la nieve blanca. Ideal para bodas.',10,'[images/products/d.gif,images/products/b1.png,images/products/b2.png,images/products/b3.png,images/products/b4.png]');
INSERT INTO productxcategory(product_id,category_id) VALUES('blanca','mujer');
INSERT INTO productxcategory(product_id,category_id) VALUES('blanca','oferta');
INSERT INTO productxcountry(product_id,country_id,price,discount_percentage) VALUES ('blanca','Colombia',100000,0.5);
INSERT INTO productxcountry(product_id,country_id,price,discount_percentage,price_after_discount) VALUES ('blanca','Mexico',500,0.4,10220);

INSERT INTO product(id,p_description,number_of_searches,images) VALUES('negra','negro mas negro que la el futuro de la humanidad. Ideal para velorios.',150,'[images/products/n1.png,images/products/n2.png,images/products/n3.png,images/products/n4.png]');
INSERT INTO productxcategory(product_id,category_id) VALUES('negra','mujer');
INSERT INTO productxcountry(product_id,country_id,price,discount_percentage) VALUES ('negra','Colombia',200050,0.5);
INSERT INTO productxcountry(product_id,country_id,price,discount_percentage,price_after_discount) VALUES ('negra','Mexico',600,0.4,10220);
INSERT INTO productxcountry(product_id,country_id,price,discount_percentage) VALUES ('negra','Chile',80.6,0.1);

INSERT INTO product(id,p_description,number_of_searches,images) VALUES('gorra','ideal para ocultarte de la policia.',5,'[images/products/g1.gif]');
INSERT INTO productxcategory(product_id,category_id) VALUES('gorra','accesorios');
INSERT INTO productxcategory(product_id,category_id) VALUES('gorra','ninos');
INSERT INTO productxcountry(product_id,country_id,price,discount_percentage) VALUES ('gorra','Colombia',20005,0.5);

INSERT INTO product(id,p_description,number_of_searches,images) VALUES('regalo','regalo para nuestros clientes',0,'[]');