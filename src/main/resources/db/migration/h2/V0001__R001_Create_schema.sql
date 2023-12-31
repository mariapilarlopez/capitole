CREATE SCHEMA IF NOT EXISTS CAPITOLE;


CREATE TABLE CAPITOLE.USUARIOS (
   ID_USUARIO NUMERIC(16,0) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
   NOMBRE VARCHAR(50) DEFAULT '',
   APELLIDO1 VARCHAR(50) DEFAULT '',
   APELLIDO2 VARCHAR(50) DEFAULT '' ,
   DIRECCION VARCHAR(100) DEFAULT '' ,
   CP VARCHAR(20)  DEFAULT '',
   POBLACION VARCHAR(100 )DEFAULT '' ,
   PAISCC2 VARCHAR(2) DEFAULT '' ,
   CONSTRAINT USUARIOS_PK PRIMARY KEY (ID_USUARIO)
);

COMMENT ON TABLE CAPITOLE.USUARIOS IS 'Usuarioas';
COMMENT ON COLUMN CAPITOLE.USUARIOS.ID_USUARIO IS 'Usuario';
COMMENT ON COLUMN CAPITOLE.USUARIOS.NOMBRE IS 'Nombre';
COMMENT ON COLUMN CAPITOLE.USUARIOS.APELLIDO1 IS 'Apellido 1';
COMMENT ON COLUMN CAPITOLE.USUARIOS.APELLIDO2 IS 'Apellido 2';
COMMENT ON COLUMN CAPITOLE.USUARIOS.DIRECCION IS 'Direccion';
COMMENT ON COLUMN CAPITOLE.USUARIOS.CP IS 'Codigo postal';
COMMENT ON COLUMN CAPITOLE.USUARIOS.POBLACION IS 'Poblacion ';
COMMENT ON COLUMN CAPITOLE.USUARIOS.PAISCC2 IS 'Pais ';

CREATE TABLE CAPITOLE.TIENDAS (
  ID_TIENDA NUMERIC(16,0) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
  NOMBRE VARCHAR(50) DEFAULT '',
  CONSTRAINT TIENDAS_PK PRIMARY KEY (ID_TIENDA)
);

COMMENT ON TABLE CAPITOLE.TIENDAS IS 'Pedidos';
COMMENT ON COLUMN CAPITOLE.TIENDAS.ID_TIENDA IS 'Tienda';
COMMENT ON COLUMN CAPITOLE.TIENDAS.NOMBRE IS 'Fecha que se realiza el pedido (UTC)';




CREATE TABLE CAPITOLE.PEDIDOS (
    ID_PEDIDO NUMERIC(16,0) GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    ID_USUARIO NUMERIC(16,0),
    ID_TIENDA NUMERIC(16,0),
    FECHA TIMESTAMP DEFAULT CURRENT_TIMESTAMP(),
    TOTAL NUMERIC(16,2) DEFAULT 0,
    SUBTOTAL NUMERIC(16,2) DEFAULT 0,
    DIRECCION VARCHAR(100) DEFAULT '',
    CP VARCHAR(20)  DEFAULT '' ,
    POBLACION VARCHAR(100) DEFAULT '' ,
    PAISCC2 VARCHAR(2) DEFAULT '' ,
    CONSTRAINT PEDIDOS_PK PRIMARY KEY (ID_PEDIDO),
    CONSTRAINT PEDIDOS_TIENDAS_FK FOREIGN KEY (ID_TIENDA) REFERENCES CAPITOLE.TIENDAS(ID_TIENDA),
    CONSTRAINT PEDIDOS_USUSARIOS_FK FOREIGN KEY (ID_USUARIO) REFERENCES CAPITOLE.USUARIOS(ID_USUARIO)
);


COMMENT ON TABLE CAPITOLE.PEDIDOS IS 'Pedidos';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.ID_PEDIDO IS 'Identificador';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.ID_USUARIO IS 'Usuario';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.ID_TIENDA IS 'Tienda';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.FECHA IS 'Fecha que se realiza el pedido (UTC)';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.TOTAL IS 'Total';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.SUBTOTAL IS 'Subtotal';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.DIRECCION IS 'Direccion';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.CP IS 'Codigo postal';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.POBLACION IS 'Poblacion ';
COMMENT ON COLUMN CAPITOLE.PEDIDOS.PAISCC2 IS 'Pais ';


