-- -------------------------------------------------------------------------
-- PostgreSQL SQL create tables
-- exported at Tue Jul 19 16:49:01 BOT 2016 with easyDesigner
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
  "ESTADO HISTORIA DE USUARIO_ID_ESTADO" INTEGER NOT NULL,
  "DESCRIPCION" VARCHAR NOT NULL,
  "NOMBRE" VARCHAR NOT NULL,
  "IMPORTANCIA" INTEGER NULL,
  "RAZON RECHAZO" VARCHAR NULL,
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
-- Table: PERSONA
-- -------------------------------------------------------------------------
CREATE TABLE "PERSONA" (
  "ID_PERSONA" bigserial NOT NULL,
  "USER_ID_USS" INTEGER NOT NULL,
  "NOMBRE" VARCHAR NULL,
  "APELLIDO PATERNO" VARCHAR NULL,
  "APELLIDO MATERNO" VARCHAR NULL,
  "CORREO" VARCHAR NULL,
  "NUMERO" VARCHAR NULL,
  PRIMARY KEY ("ID_PERSONA")
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
-- Table: ASIGNAR USER_HU
-- -------------------------------------------------------------------------
CREATE TABLE "ASIGNAR USER_HU" (
  "USER_ID_USS" INTEGER NOT NULL,
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  PRIMARY KEY ("USER_ID_USS", "HISTORIA DE USUARIO_ID_HU")
);

-- -------------------------------------------------------------------------
-- Table: EQUIPO
-- -------------------------------------------------------------------------
CREATE TABLE "EQUIPO" (
  "ID_EQUIPO" bigserial NOT NULL,
  PRIMARY KEY ("ID_EQUIPO")
);

-- -------------------------------------------------------------------------
-- Table: ASGINACION PERSONA_EQUIPO
-- -------------------------------------------------------------------------
CREATE TABLE "ASGINACION PERSONA_EQUIPO" (
  "PERSONA_ID_PERSONA" INTEGER NOT NULL,
  "EQUIPO_ID_EQUIPO" INTEGER NOT NULL,
  PRIMARY KEY ("PERSONA_ID_PERSONA", "EQUIPO_ID_EQUIPO")
);

-- -------------------------------------------------------------------------
-- Table: ASIGNACION EQUIPO_HU
-- -------------------------------------------------------------------------
CREATE TABLE "ASIGNACION EQUIPO_HU" (
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  "EQUIPO_ID_EQUIPO" INTEGER NOT NULL,
  PRIMARY KEY ("HISTORIA DE USUARIO_ID_HU", "EQUIPO_ID_EQUIPO")
);

-- -------------------------------------------------------------------------
-- Table: ASIGNACION HU_TEST
-- -------------------------------------------------------------------------
CREATE TABLE "ASIGNACION HU_TEST" (
  "TEST_ID_TEST" INTEGER NOT NULL,
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  PRIMARY KEY ("TEST_ID_TEST", "HISTORIA DE USUARIO_ID_HU")
);

-- -------------------------------------------------------------------------
-- Table: PAR
-- -------------------------------------------------------------------------
CREATE TABLE "PAR" (
  "ID_PAR" bigserial NOT NULL,
  "FECHA" DATE NULL,
  PRIMARY KEY ("ID_PAR")
);

-- -------------------------------------------------------------------------
-- Table: ASIGNACION PERSONA_PAR
-- -------------------------------------------------------------------------
CREATE TABLE "ASIGNACION PERSONA_PAR" (
  "PAR_ID_PAR" INTEGER NOT NULL,
  "PERSONA_ID_PERSONA" INTEGER NOT NULL,
  PRIMARY KEY ("PAR_ID_PAR", "PERSONA_ID_PERSONA")
);

-- -------------------------------------------------------------------------
-- Table: ESTADO HISTORIA DE USUARIO
-- -------------------------------------------------------------------------
CREATE TABLE "ESTADO HISTORIA DE USUARIO" (
  "ID_ESTADO" bigserial NOT NULL,
  "DESCRIPCION" VARCHAR NULL,
  PRIMARY KEY ("ID_ESTADO")
);

-- -------------------------------------------------------------------------
-- Table: PROYECTO
-- -------------------------------------------------------------------------
CREATE TABLE "PROYECTO" (
  "ID_PROYECTO" bigserial NOT NULL,
  "DESCRIPCION" VARCHAR NULL,
  "TITULO" VARCHAR NULL,
  PRIMARY KEY ("ID_PROYECTO")
);

-- -------------------------------------------------------------------------
-- Table: ASIGNACION EQUIPO_PROYECTO
-- -------------------------------------------------------------------------
CREATE TABLE "ASIGNACION EQUIPO_PROYECTO" (
  "EQUIPO_ID_EQUIPO" INTEGER NOT NULL,
  "PROYECTO_ID_PROYECTO" INTEGER NOT NULL,
  PRIMARY KEY ("EQUIPO_ID_EQUIPO", "PROYECTO_ID_PROYECTO")
);

-- -------------------------------------------------------------------------
-- Table: ASIGNACION PROYECTO_HU
-- -------------------------------------------------------------------------
CREATE TABLE "ASIGNACION PROYECTO_HU" (
  "PROYECTO_ID_PROYECTO" INTEGER NOT NULL,
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  PRIMARY KEY ("PROYECTO_ID_PROYECTO", "HISTORIA DE USUARIO_ID_HU")
);

-- -------------------------------------------------------------------------
-- Table: TAREA
-- -------------------------------------------------------------------------
CREATE TABLE "TAREA" (
  "ID_TAREA" bigserial NOT NULL,
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  "DESCRIPCION" VARCHAR NULL,
  PRIMARY KEY ("ID_TAREA", "HISTORIA DE USUARIO_ID_HU")
);

-- -------------------------------------------------------------------------
-- Table: HISTORIA VISTA
-- -------------------------------------------------------------------------
CREATE TABLE "HISTORIA VISTA" (
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  "USER_ID_USS" INTEGER NOT NULL,
  PRIMARY KEY ("HISTORIA DE USUARIO_ID_HU", "USER_ID_USS")
);

-- -------------------------------------------------------------------------
-- Table: HISTORIA APROBADA
-- -------------------------------------------------------------------------
CREATE TABLE "HISTORIA APROBADA" (
  "HISTORIA DE USUARIO_ID_HU" INTEGER NOT NULL,
  "USER_ID_USS" INTEGER NOT NULL,
  PRIMARY KEY ("HISTORIA DE USUARIO_ID_HU", "USER_ID_USS")
);

-- -------------------------------------------------------------------------
-- Table: USS ROL
-- -------------------------------------------------------------------------
CREATE TABLE "USS ROL" (
  "USER_ID_USS" INTEGER NOT NULL,
  "ROL_ID_ROL" INTEGER NOT NULL,
  PRIMARY KEY ("USER_ID_USS", "ROL_ID_ROL")
);

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
-- Relations for table: HISTORIA DE USUARIO
-- -------------------------------------------------------------------------
ALTER TABLE "HISTORIA DE USUARIO" ADD FOREIGN KEY ("ESTADO HISTORIA DE USUARIO_ID_ESTADO") 
    REFERENCES "ESTADO HISTORIA DE USUARIO" ("ID_ESTADO")
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

-- -------------------------------------------------------------------------
-- Relations for table: ASIGNAR USER_HU
-- -------------------------------------------------------------------------
ALTER TABLE "ASIGNAR USER_HU" ADD FOREIGN KEY ("USER_ID_USS") 
    REFERENCES "USER" ("ID_USS")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ASIGNAR USER_HU" ADD FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") 
    REFERENCES "HISTORIA DE USUARIO" ("ID_HU")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: ASGINACION PERSONA_EQUIPO
-- -------------------------------------------------------------------------
ALTER TABLE "ASGINACION PERSONA_EQUIPO" ADD FOREIGN KEY ("PERSONA_ID_PERSONA") 
    REFERENCES "PERSONA" ("ID_PERSONA")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ASGINACION PERSONA_EQUIPO" ADD FOREIGN KEY ("EQUIPO_ID_EQUIPO") 
    REFERENCES "EQUIPO" ("ID_EQUIPO")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: ASIGNACION EQUIPO_HU
-- -------------------------------------------------------------------------
ALTER TABLE "ASIGNACION EQUIPO_HU" ADD FOREIGN KEY ("EQUIPO_ID_EQUIPO") 
    REFERENCES "EQUIPO" ("ID_EQUIPO")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ASIGNACION EQUIPO_HU" ADD FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") 
    REFERENCES "HISTORIA DE USUARIO" ("ID_HU")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: ASIGNACION HU_TEST
-- -------------------------------------------------------------------------
ALTER TABLE "ASIGNACION HU_TEST" ADD FOREIGN KEY ("TEST_ID_TEST") 
    REFERENCES "TEST" ("ID_TEST")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ASIGNACION HU_TEST" ADD FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") 
    REFERENCES "HISTORIA DE USUARIO" ("ID_HU")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: ASIGNACION PERSONA_PAR
-- -------------------------------------------------------------------------
ALTER TABLE "ASIGNACION PERSONA_PAR" ADD FOREIGN KEY ("PAR_ID_PAR") 
    REFERENCES "PAR" ("ID_PAR")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ASIGNACION PERSONA_PAR" ADD FOREIGN KEY ("PERSONA_ID_PERSONA") 
    REFERENCES "PERSONA" ("ID_PERSONA")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: ASIGNACION EQUIPO_PROYECTO
-- -------------------------------------------------------------------------
ALTER TABLE "ASIGNACION EQUIPO_PROYECTO" ADD FOREIGN KEY ("EQUIPO_ID_EQUIPO") 
    REFERENCES "EQUIPO" ("ID_EQUIPO")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ASIGNACION EQUIPO_PROYECTO" ADD FOREIGN KEY ("PROYECTO_ID_PROYECTO") 
    REFERENCES "PROYECTO" ("ID_PROYECTO")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: ASIGNACION PROYECTO_HU
-- -------------------------------------------------------------------------
ALTER TABLE "ASIGNACION PROYECTO_HU" ADD FOREIGN KEY ("PROYECTO_ID_PROYECTO") 
    REFERENCES "PROYECTO" ("ID_PROYECTO")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "ASIGNACION PROYECTO_HU" ADD FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") 
    REFERENCES "HISTORIA DE USUARIO" ("ID_HU")
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
-- Relations for table: HISTORIA VISTA
-- -------------------------------------------------------------------------
ALTER TABLE "HISTORIA VISTA" ADD FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") 
    REFERENCES "HISTORIA DE USUARIO" ("ID_HU")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "HISTORIA VISTA" ADD FOREIGN KEY ("USER_ID_USS") 
    REFERENCES "USER" ("ID_USS")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: HISTORIA APROBADA
-- -------------------------------------------------------------------------
ALTER TABLE "HISTORIA APROBADA" ADD FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") 
    REFERENCES "HISTORIA DE USUARIO" ("ID_HU")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "HISTORIA APROBADA" ADD FOREIGN KEY ("USER_ID_USS") 
    REFERENCES "USER" ("ID_USS")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

-- -------------------------------------------------------------------------
-- Relations for table: USS ROL
-- -------------------------------------------------------------------------
ALTER TABLE "USS ROL" ADD FOREIGN KEY ("USER_ID_USS") 
    REFERENCES "USER" ("ID_USS")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;
ALTER TABLE "USS ROL" ADD FOREIGN KEY ("ROL_ID_ROL") 
    REFERENCES "ROL" ("ID_ROL")
      ON DELETE NO ACTION
      ON UPDATE NO ACTION;

