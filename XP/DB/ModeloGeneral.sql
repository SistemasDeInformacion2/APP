-- -------------------------------------------------------------------------
-- PostgreSQL SQL create tables
-- exported at Sun Jul 17 14:27:22 BOT 2016 with easyDesigner
-- -------------------------------------------------------------------------

-- -------------------------------------------------------------------------
-- Table: USER
-- -------------------------------------------------------------------------
CREATE TABLE "USER" (
  "ID_USS" bigserial NOT NULL,
  "LOGIN" VARCHAR NULL,
  "PASSWORD" VARCHAR NULL,
  PRIMARY KEY ("ID_USS")
);

-- -------------------------------------------------------------------------
-- Table: USS_ROL
-- -------------------------------------------------------------------------
CREATE TABLE "USS_ROL" (
  "USER_ID_USS" INTEGER NOT NULL,
  "ROL_ID_ROL" INTEGER NOT NULL,
  PRIMARY KEY ("USER_ID_USS", "ROL_ID_ROL")
);

-- -------------------------------------------------------------------------
-- Table: ROL
-- -------------------------------------------------------------------------
CREATE TABLE "ROL" (
  "ID_ROL" bigserial NOT NULL,
  "DESCRIPCION" VARCHAR NULL,
  PRIMARY KEY ("ID_ROL")
);

-- -------------------------------------------------------------------------
-- Table: ROL_FUNCION
-- -------------------------------------------------------------------------
CREATE TABLE "ROL_FUNCION" (
  "ROL_ID_ROL" INTEGER NOT NULL,
  "FUNCION_ID_FUN" INTEGER NOT NULL,
  PRIMARY KEY ("ROL_ID_ROL", "FUNCION_ID_FUN")
);

-- -------------------------------------------------------------------------
-- Table: FUNCION
-- -------------------------------------------------------------------------
CREATE TABLE "FUNCION" (
  "ID_FUN" bigserial NOT NULL,
  "DESCRIPCION" VARCHAR NULL,
  PRIMARY KEY ("ID_FUN")
);

-- -------------------------------------------------------------------------
-- Table: FUN_VIEW
-- -------------------------------------------------------------------------
CREATE TABLE "FUN_VIEW" (
  "FUNCION_ID_FUN" INTEGER NOT NULL,
  "VIEW_ID_VIEW" INTEGER NOT NULL,
  PRIMARY KEY ("FUNCION_ID_FUN", "VIEW_ID_VIEW")
);

-- -------------------------------------------------------------------------
-- Table: VIEW
-- -------------------------------------------------------------------------
CREATE TABLE "VIEW" (
  "ID_VIEW" bigserial NOT NULL,
  "STORAGE" VARCHAR NULL,
  PRIMARY KEY ("ID_VIEW")
);

-- -------------------------------------------------------------------------
-- Table: HISTORIA DE USUARIO
-- -------------------------------------------------------------------------
CREATE TABLE "HISTORIA DE USUARIO" (
  "ID_HU" bigserial NOT NULL,
  "DESCRIPCION" VARCHAR NOT NULL,
  "NOMBRE" VARCHAR NOT NULL,
  "IMPORTANCIA" INTEGER NULL,
  PRIMARY KEY ("ID_HU")
);

-- -------------------------------------------------------------------------
-- Table: TEST
-- -------------------------------------------------------------------------
CREATE TABLE "TEST" (
  "ID_TEST" bigserial NOT NULL,
  "NOMBRE" VARCHAR NULL,
  "DESCRIPCION" VARCHAR NULL,
  PRIMARY KEY ("ID_TEST")
);

-- -------------------------------------------------------------------------
-- Table: TAREA
-- -------------------------------------------------------------------------
CREATE TABLE "TAREA" (
  "ID_TAREA" bigserial NOT NULL,
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  "NOMBRE" VARCHAR NULL,
  "DESCRIPCION" VARCHAR NULL,
  "IMPORTANCIA" VARCHAR NULL,
  PRIMARY KEY ("ID_TAREA", "HISTORIA DE USUARIO_ID_HU")
);

-- -------------------------------------------------------------------------
-- Table: PERSONA
-- -------------------------------------------------------------------------
CREATE TABLE "PERSONA" (
  "ID_PERSONA" bigserial NOT NULL,
  "USER_ID_USS" INTEGER NOT NULL,
  "NOMBRE" VARCHAR NULL,
  "APELLIDO PATERNO" VARCHAR NULL,
  "APELLIDO MATERNO" VARCHAR NULL,
  PRIMARY KEY ("ID_PERSONA", "USER_ID_USS")
);

-- -------------------------------------------------------------------------
-- Table: SESSION
-- -------------------------------------------------------------------------
CREATE TABLE "SESSION" (
  "ID_SESSION" bigserial NOT NULL,
  "USER_ID_USS" INTEGER NOT NULL,
  "PID" INTEGER NULL,
  "FECHA" DATE NULL,
  "ACTIVO" BOOL NULL,
  PRIMARY KEY ("ID_SESSION", "USER_ID_USS")
);

-- -------------------------------------------------------------------------
-- Relations for table: USS_ROL
-- -------------------------------------------------------------------------
ALTER TABLE "USS_ROL" ADD FOREIGN KEY ("USER_ID_USS") 
    REFERENCES "USER" ("ID_USS")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "USS_ROL" ADD FOREIGN KEY ("ROL_ID_ROL") 
    REFERENCES "ROL" ("ID_ROL")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: ROL_FUNCION
-- -------------------------------------------------------------------------
ALTER TABLE "ROL_FUNCION" ADD FOREIGN KEY ("ROL_ID_ROL") 
    REFERENCES "ROL" ("ID_ROL")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ROL_FUNCION" ADD FOREIGN KEY ("FUNCION_ID_FUN") 
    REFERENCES "FUNCION" ("ID_FUN")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: FUN_VIEW
-- -------------------------------------------------------------------------
ALTER TABLE "FUN_VIEW" ADD FOREIGN KEY ("FUNCION_ID_FUN") 
    REFERENCES "FUNCION" ("ID_FUN")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "FUN_VIEW" ADD FOREIGN KEY ("VIEW_ID_VIEW") 
    REFERENCES "VIEW" ("ID_VIEW")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: TAREA
-- -------------------------------------------------------------------------
ALTER TABLE "TAREA" ADD FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") 
    REFERENCES "HISTORIA DE USUARIO" ("ID_HU")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: PERSONA
-- -------------------------------------------------------------------------
ALTER TABLE "PERSONA" ADD FOREIGN KEY ("USER_ID_USS") 
    REFERENCES "USER" ("ID_USS")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: SESSION
-- -------------------------------------------------------------------------
ALTER TABLE "SESSION" ADD FOREIGN KEY ("USER_ID_USS") 
    REFERENCES "USER" ("ID_USS")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

