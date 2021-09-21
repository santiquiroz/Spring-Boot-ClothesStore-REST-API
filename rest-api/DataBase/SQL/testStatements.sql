INSERT INTO product (p_description,images) 
VALUES(
    'es una pera para comer',
    Json_Array('https://www.herbazest.com/imgs/d/8/7/551784/pera.jpg')
);
UPDATE product SET images = JSON_ARRAY_APPEND(images,'$','https://i.ytimg.com/vi/aIge_QmV_zw/maxresdefault.jpg') WHERE id = '1';


