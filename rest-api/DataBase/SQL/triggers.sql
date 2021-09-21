DELIMITER $$

CREATE OR REPLACE TRIGGER check_maximum_discount_insert BEFORE INSERT ON productxcountry
  FOR EACH ROW 
  BEGIN
  		declare error_message varchar(1024) default '';
      IF NEW.discount_percentage <= (SELECT maximum_discount_percentage FROM country WHERE id = NEW.country_id) THEN
			SET NEW.price_after_discount := NEW.price*NEW.discount_percentage;
		ELSE
			set error_message = concat( error_message, 'Attempted to insert a higher discount than allowed' );
			signal SQLSTATE '23000' set message_text = error_message;
		END IF;       
 END
$$

DELIMITER ;

DELIMITER $$

CREATE OR REPLACE TRIGGER check_maximum_discount_update BEFORE UPDATE ON productxcountry
  FOR EACH ROW 
  BEGIN
  		declare error_message varchar(1024) default '';
      IF NEW.discount_percentage <= (SELECT maximum_discount_percentage FROM country WHERE id = NEW.country_id) THEN
			SET NEW.price_after_discount := NEW.price*NEW.discount_percentage;
		ELSE
			set error_message = concat( error_message, 'Attempted to insert a higher discount than allowed' );
			signal SQLSTATE '23000' set message_text = error_message;
		END IF;       
 END
$$

DELIMITER ;