-------------------------------------------- CAPITOLE.USUARIOS ------------------------------------------------------------
INSERT INTO CAPITOLE.USUARIOS (NOMBRE, APELLIDO1, APELLIDO2, DIRECCION, CP, POBLACION, PAISCC2) VALUES
  ('M PILAR','LOPEZ','GRACIA','LOREM IPSUM', '54','ZUERA','ES');

-------------------------------------------- CAPITOLE.TIENDAS ------------------------------------------------------------
INSERT INTO CAPITOLE.TIENDAS (NOMBRE) VALUES
  ('TIENDA001');

-------------------------------------------- CAPITOLE.PEDIDOS ------------------------------------------------------------
INSERT INTO CAPITOLE.PEDIDOS (ID_USUARIO, ID_TIENDA, FECHA, TOTAL, SUBTOTAL,  DIRECCION, CP, POBLACION, PAISCC2) VALUES
  (1,1,'2023-07-08 08:00:00.0', 15.0, 17.5,'LOREM IPSUM', '54','ZUERA','ES' );
