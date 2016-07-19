--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.2
-- Dumped by pg_dump version 9.5.1

-- Started on 2016-07-19 01:34:45

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12355)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2330 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 220 (class 1259 OID 25361)
-- Name: APROBADO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "APROBADO" (
    "ID_APROBADO" bigint NOT NULL,
    "ID_USER" bigint,
    "ID_HU" bigint
);


--
-- TOC entry 219 (class 1259 OID 25359)
-- Name: APROBADO_ID_APROBADO_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "APROBADO_ID_APROBADO_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2331 (class 0 OID 0)
-- Dependencies: 219
-- Name: APROBADO_ID_APROBADO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "APROBADO_ID_APROBADO_seq" OWNED BY "APROBADO"."ID_APROBADO";


--
-- TOC entry 203 (class 1259 OID 25136)
-- Name: ASGINACION PERSONA_EQUIPO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ASGINACION PERSONA_EQUIPO" (
    "PERSONA_ID_PERSONA" integer NOT NULL,
    "EQUIPO_ID_EQUIPO" integer NOT NULL
);


--
-- TOC entry 204 (class 1259 OID 25141)
-- Name: ASIGNACION EQUIPO_HU; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ASIGNACION EQUIPO_HU" (
    "HISTORIA DE USUARIO_ID_HU" integer NOT NULL,
    "EQUIPO_ID_EQUIPO" integer NOT NULL
);


--
-- TOC entry 213 (class 1259 OID 25186)
-- Name: ASIGNACION EQUIPO_PROYECTO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ASIGNACION EQUIPO_PROYECTO" (
    "EQUIPO_ID_EQUIPO" integer NOT NULL,
    "PROYECTO_ID_PROYECTO" integer NOT NULL
);


--
-- TOC entry 205 (class 1259 OID 25146)
-- Name: ASIGNACION HU_TEST; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ASIGNACION HU_TEST" (
    "TEST_ID_TEST" integer NOT NULL,
    "HISTORIA DE USUARIO_ID_HU" integer NOT NULL
);


--
-- TOC entry 208 (class 1259 OID 25159)
-- Name: ASIGNACION PERSONA_PAR; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ASIGNACION PERSONA_PAR" (
    "PAR_ID_PAR" integer NOT NULL,
    "PERSONA_ID_PERSONA" integer NOT NULL
);


--
-- TOC entry 214 (class 1259 OID 25191)
-- Name: ASIGNACION PROYECTO_HU; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ASIGNACION PROYECTO_HU" (
    "PROYECTO_ID_PROYECTO" integer NOT NULL,
    "HISTORIA DE USUARIO_ID_HU" integer NOT NULL
);


--
-- TOC entry 200 (class 1259 OID 25123)
-- Name: ASIGNAR USER_HU; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ASIGNAR USER_HU" (
    "USER_ID_USS" integer NOT NULL,
    "HISTORIA DE USUARIO_ID_HU" integer NOT NULL
);


--
-- TOC entry 202 (class 1259 OID 25130)
-- Name: EQUIPO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "EQUIPO" (
    "ID_EQUIPO" bigint NOT NULL
);


--
-- TOC entry 201 (class 1259 OID 25128)
-- Name: EQUIPO_ID_EQUIPO_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "EQUIPO_ID_EQUIPO_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2332 (class 0 OID 0)
-- Dependencies: 201
-- Name: EQUIPO_ID_EQUIPO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "EQUIPO_ID_EQUIPO_seq" OWNED BY "EQUIPO"."ID_EQUIPO";


--
-- TOC entry 210 (class 1259 OID 25166)
-- Name: ESTADO HISTORIA DE USUARIO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ESTADO HISTORIA DE USUARIO" (
    "ID_ESTADO" bigint NOT NULL,
    "DESCRIPCION" character varying
);


--
-- TOC entry 209 (class 1259 OID 25164)
-- Name: ESTADO HISTORIA DE USUARIO_ID_ESTADO_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "ESTADO HISTORIA DE USUARIO_ID_ESTADO_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2333 (class 0 OID 0)
-- Dependencies: 209
-- Name: ESTADO HISTORIA DE USUARIO_ID_ESTADO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "ESTADO HISTORIA DE USUARIO_ID_ESTADO_seq" OWNED BY "ESTADO HISTORIA DE USUARIO"."ID_ESTADO";


--
-- TOC entry 188 (class 1259 OID 25057)
-- Name: FUNCION; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "FUNCION" (
    "ID_FUN" bigint NOT NULL,
    "DESCRIPCION" character varying
);


--
-- TOC entry 187 (class 1259 OID 25055)
-- Name: FUNCION_ID_FUN_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "FUNCION_ID_FUN_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2334 (class 0 OID 0)
-- Dependencies: 187
-- Name: FUNCION_ID_FUN_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "FUNCION_ID_FUN_seq" OWNED BY "FUNCION"."ID_FUN";


--
-- TOC entry 189 (class 1259 OID 25066)
-- Name: FUN_VIEW; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "FUN_VIEW" (
    "FUNCION_ID_FUN" integer NOT NULL,
    "VIEW_ID_VIEW" integer NOT NULL
);


--
-- TOC entry 193 (class 1259 OID 25084)
-- Name: HISTORIA DE USUARIO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "HISTORIA DE USUARIO" (
    "ID_HU" bigint NOT NULL,
    "ESTADO HISTORIA DE USUARIO_ID_ESTADO" integer NOT NULL,
    "DESCRIPCION" character varying NOT NULL,
    "NOMBRE" character varying NOT NULL,
    "IMPORTANCIA" integer,
    "RAZON RECHAZO" text
);


--
-- TOC entry 192 (class 1259 OID 25082)
-- Name: HISTORIA DE USUARIO_ID_HU_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "HISTORIA DE USUARIO_ID_HU_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2335 (class 0 OID 0)
-- Dependencies: 192
-- Name: HISTORIA DE USUARIO_ID_HU_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "HISTORIA DE USUARIO_ID_HU_seq" OWNED BY "HISTORIA DE USUARIO"."ID_HU";


--
-- TOC entry 207 (class 1259 OID 25153)
-- Name: PAR; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "PAR" (
    "ID_PAR" bigint NOT NULL,
    "FECHA" date
);


--
-- TOC entry 206 (class 1259 OID 25151)
-- Name: PAR_ID_PAR_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "PAR_ID_PAR_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2336 (class 0 OID 0)
-- Dependencies: 206
-- Name: PAR_ID_PAR_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "PAR_ID_PAR_seq" OWNED BY "PAR"."ID_PAR";


--
-- TOC entry 197 (class 1259 OID 25106)
-- Name: PERSONA; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "PERSONA" (
    "ID_PERSONA" bigint NOT NULL,
    "USER_ID_USS" integer NOT NULL,
    "NOMBRE" character varying,
    "APELLIDO PATERNO" character varying,
    "APELLIDO MATERNO" character varying
);


--
-- TOC entry 196 (class 1259 OID 25104)
-- Name: PERSONA_ID_PERSONA_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "PERSONA_ID_PERSONA_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2337 (class 0 OID 0)
-- Dependencies: 196
-- Name: PERSONA_ID_PERSONA_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "PERSONA_ID_PERSONA_seq" OWNED BY "PERSONA"."ID_PERSONA";


--
-- TOC entry 212 (class 1259 OID 25177)
-- Name: PROYECTO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "PROYECTO" (
    "ID_PROYECTO" bigint NOT NULL,
    "DESCRIPCION" character varying,
    "TITULO" character varying
);


--
-- TOC entry 211 (class 1259 OID 25175)
-- Name: PROYECTO_ID_PROYECTO_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "PROYECTO_ID_PROYECTO_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2338 (class 0 OID 0)
-- Dependencies: 211
-- Name: PROYECTO_ID_PROYECTO_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "PROYECTO_ID_PROYECTO_seq" OWNED BY "PROYECTO"."ID_PROYECTO";


--
-- TOC entry 185 (class 1259 OID 25041)
-- Name: ROL; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ROL" (
    "ID_ROL" bigint NOT NULL,
    "DESCRIPCION" character varying
);


--
-- TOC entry 186 (class 1259 OID 25050)
-- Name: ROL_FUNCION; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "ROL_FUNCION" (
    "ROL_ID_ROL" integer NOT NULL,
    "FUNCION_ID_FUN" integer NOT NULL
);


--
-- TOC entry 184 (class 1259 OID 25039)
-- Name: ROL_ID_ROL_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "ROL_ID_ROL_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2339 (class 0 OID 0)
-- Dependencies: 184
-- Name: ROL_ID_ROL_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "ROL_ID_ROL_seq" OWNED BY "ROL"."ID_ROL";


--
-- TOC entry 199 (class 1259 OID 25117)
-- Name: SESSION; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "SESSION" (
    "ID_SESSION" bigint NOT NULL,
    "USER_ID_USS" integer NOT NULL,
    "PID" integer,
    "FECHA" date,
    "ACTIVO" boolean
);


--
-- TOC entry 198 (class 1259 OID 25115)
-- Name: SESSION_ID_SESSION_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "SESSION_ID_SESSION_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2340 (class 0 OID 0)
-- Dependencies: 198
-- Name: SESSION_ID_SESSION_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "SESSION_ID_SESSION_seq" OWNED BY "SESSION"."ID_SESSION";


--
-- TOC entry 216 (class 1259 OID 25198)
-- Name: TAREA; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "TAREA" (
    "ID_TAREA" bigint NOT NULL,
    "HISTORIA DE USUARIO_ID_HU" integer NOT NULL,
    "DESCRIPCION" character varying
);


--
-- TOC entry 215 (class 1259 OID 25196)
-- Name: TAREA_ID_TAREA_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "TAREA_ID_TAREA_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2341 (class 0 OID 0)
-- Dependencies: 215
-- Name: TAREA_ID_TAREA_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "TAREA_ID_TAREA_seq" OWNED BY "TAREA"."ID_TAREA";


--
-- TOC entry 195 (class 1259 OID 25095)
-- Name: TEST; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "TEST" (
    "ID_TEST" bigint NOT NULL,
    "NOMBRE" character varying,
    "DESCRIPCION" character varying
);


--
-- TOC entry 194 (class 1259 OID 25093)
-- Name: TEST_ID_TEST_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "TEST_ID_TEST_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2342 (class 0 OID 0)
-- Dependencies: 194
-- Name: TEST_ID_TEST_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "TEST_ID_TEST_seq" OWNED BY "TEST"."ID_TEST";


--
-- TOC entry 182 (class 1259 OID 25025)
-- Name: USER; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "USER" (
    "ID_USS" bigint NOT NULL,
    "LOGIN" character varying,
    "PASSWORD" character varying,
    "ROL_ID_ROL" bigint NOT NULL
);


--
-- TOC entry 181 (class 1259 OID 25023)
-- Name: USER_ID_USS_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "USER_ID_USS_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2343 (class 0 OID 0)
-- Dependencies: 181
-- Name: USER_ID_USS_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "USER_ID_USS_seq" OWNED BY "USER"."ID_USS";


--
-- TOC entry 183 (class 1259 OID 25034)
-- Name: USS_ROL; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "USS_ROL" (
    "USER_ID_USS" integer NOT NULL,
    "ROL_ID_ROL" integer NOT NULL
);


--
-- TOC entry 191 (class 1259 OID 25073)
-- Name: VIEW; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "VIEW" (
    "ID_VIEW" bigint NOT NULL,
    "STORAGE" character varying
);


--
-- TOC entry 190 (class 1259 OID 25071)
-- Name: VIEW_ID_VIEW_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "VIEW_ID_VIEW_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2344 (class 0 OID 0)
-- Dependencies: 190
-- Name: VIEW_ID_VIEW_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "VIEW_ID_VIEW_seq" OWNED BY "VIEW"."ID_VIEW";


--
-- TOC entry 218 (class 1259 OID 25337)
-- Name: VISTO; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE "VISTO" (
    "ID VISTO" bigint NOT NULL,
    "ID_HU" bigint,
    "ID_USER" bigint
);


--
-- TOC entry 217 (class 1259 OID 25335)
-- Name: Visto_ID SESION_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE "Visto_ID SESION_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 2345 (class 0 OID 0)
-- Dependencies: 217
-- Name: Visto_ID SESION_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE "Visto_ID SESION_seq" OWNED BY "VISTO"."ID VISTO";


--
-- TOC entry 2129 (class 2604 OID 25364)
-- Name: ID_APROBADO; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "APROBADO" ALTER COLUMN "ID_APROBADO" SET DEFAULT nextval('"APROBADO_ID_APROBADO_seq"'::regclass);


--
-- TOC entry 2123 (class 2604 OID 25133)
-- Name: ID_EQUIPO; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "EQUIPO" ALTER COLUMN "ID_EQUIPO" SET DEFAULT nextval('"EQUIPO_ID_EQUIPO_seq"'::regclass);


--
-- TOC entry 2125 (class 2604 OID 25169)
-- Name: ID_ESTADO; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ESTADO HISTORIA DE USUARIO" ALTER COLUMN "ID_ESTADO" SET DEFAULT nextval('"ESTADO HISTORIA DE USUARIO_ID_ESTADO_seq"'::regclass);


--
-- TOC entry 2117 (class 2604 OID 25060)
-- Name: ID_FUN; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "FUNCION" ALTER COLUMN "ID_FUN" SET DEFAULT nextval('"FUNCION_ID_FUN_seq"'::regclass);


--
-- TOC entry 2119 (class 2604 OID 25087)
-- Name: ID_HU; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "HISTORIA DE USUARIO" ALTER COLUMN "ID_HU" SET DEFAULT nextval('"HISTORIA DE USUARIO_ID_HU_seq"'::regclass);


--
-- TOC entry 2124 (class 2604 OID 25156)
-- Name: ID_PAR; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "PAR" ALTER COLUMN "ID_PAR" SET DEFAULT nextval('"PAR_ID_PAR_seq"'::regclass);


--
-- TOC entry 2121 (class 2604 OID 25109)
-- Name: ID_PERSONA; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "PERSONA" ALTER COLUMN "ID_PERSONA" SET DEFAULT nextval('"PERSONA_ID_PERSONA_seq"'::regclass);


--
-- TOC entry 2126 (class 2604 OID 25180)
-- Name: ID_PROYECTO; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "PROYECTO" ALTER COLUMN "ID_PROYECTO" SET DEFAULT nextval('"PROYECTO_ID_PROYECTO_seq"'::regclass);


--
-- TOC entry 2116 (class 2604 OID 25044)
-- Name: ID_ROL; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ROL" ALTER COLUMN "ID_ROL" SET DEFAULT nextval('"ROL_ID_ROL_seq"'::regclass);


--
-- TOC entry 2122 (class 2604 OID 25120)
-- Name: ID_SESSION; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "SESSION" ALTER COLUMN "ID_SESSION" SET DEFAULT nextval('"SESSION_ID_SESSION_seq"'::regclass);


--
-- TOC entry 2127 (class 2604 OID 25201)
-- Name: ID_TAREA; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "TAREA" ALTER COLUMN "ID_TAREA" SET DEFAULT nextval('"TAREA_ID_TAREA_seq"'::regclass);


--
-- TOC entry 2120 (class 2604 OID 25098)
-- Name: ID_TEST; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "TEST" ALTER COLUMN "ID_TEST" SET DEFAULT nextval('"TEST_ID_TEST_seq"'::regclass);


--
-- TOC entry 2115 (class 2604 OID 25028)
-- Name: ID_USS; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "USER" ALTER COLUMN "ID_USS" SET DEFAULT nextval('"USER_ID_USS_seq"'::regclass);


--
-- TOC entry 2118 (class 2604 OID 25076)
-- Name: ID_VIEW; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "VIEW" ALTER COLUMN "ID_VIEW" SET DEFAULT nextval('"VIEW_ID_VIEW_seq"'::regclass);


--
-- TOC entry 2128 (class 2604 OID 25340)
-- Name: ID VISTO; Type: DEFAULT; Schema: public; Owner: -
--

ALTER TABLE ONLY "VISTO" ALTER COLUMN "ID VISTO" SET DEFAULT nextval('"Visto_ID SESION_seq"'::regclass);


--
-- TOC entry 2157 (class 2606 OID 25140)
-- Name: ASGINACION PERSONA_EQUIPO_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASGINACION PERSONA_EQUIPO"
    ADD CONSTRAINT "ASGINACION PERSONA_EQUIPO_pkey" PRIMARY KEY ("PERSONA_ID_PERSONA", "EQUIPO_ID_EQUIPO");


--
-- TOC entry 2159 (class 2606 OID 25145)
-- Name: ASIGNACION EQUIPO_HU_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION EQUIPO_HU"
    ADD CONSTRAINT "ASIGNACION EQUIPO_HU_pkey" PRIMARY KEY ("HISTORIA DE USUARIO_ID_HU", "EQUIPO_ID_EQUIPO");


--
-- TOC entry 2171 (class 2606 OID 25190)
-- Name: ASIGNACION EQUIPO_PROYECTO_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION EQUIPO_PROYECTO"
    ADD CONSTRAINT "ASIGNACION EQUIPO_PROYECTO_pkey" PRIMARY KEY ("EQUIPO_ID_EQUIPO", "PROYECTO_ID_PROYECTO");


--
-- TOC entry 2161 (class 2606 OID 25150)
-- Name: ASIGNACION HU_TEST_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION HU_TEST"
    ADD CONSTRAINT "ASIGNACION HU_TEST_pkey" PRIMARY KEY ("TEST_ID_TEST", "HISTORIA DE USUARIO_ID_HU");


--
-- TOC entry 2165 (class 2606 OID 25163)
-- Name: ASIGNACION PERSONA_PAR_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION PERSONA_PAR"
    ADD CONSTRAINT "ASIGNACION PERSONA_PAR_pkey" PRIMARY KEY ("PAR_ID_PAR", "PERSONA_ID_PERSONA");


--
-- TOC entry 2173 (class 2606 OID 25195)
-- Name: ASIGNACION PROYECTO_HU_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION PROYECTO_HU"
    ADD CONSTRAINT "ASIGNACION PROYECTO_HU_pkey" PRIMARY KEY ("PROYECTO_ID_PROYECTO", "HISTORIA DE USUARIO_ID_HU");


--
-- TOC entry 2153 (class 2606 OID 25127)
-- Name: ASIGNAR USER_HU_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNAR USER_HU"
    ADD CONSTRAINT "ASIGNAR USER_HU_pkey" PRIMARY KEY ("USER_ID_USS", "HISTORIA DE USUARIO_ID_HU");


--
-- TOC entry 2155 (class 2606 OID 25135)
-- Name: EQUIPO_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "EQUIPO"
    ADD CONSTRAINT "EQUIPO_pkey" PRIMARY KEY ("ID_EQUIPO");


--
-- TOC entry 2167 (class 2606 OID 25174)
-- Name: ESTADO HISTORIA DE USUARIO_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ESTADO HISTORIA DE USUARIO"
    ADD CONSTRAINT "ESTADO HISTORIA DE USUARIO_pkey" PRIMARY KEY ("ID_ESTADO");


--
-- TOC entry 2139 (class 2606 OID 25065)
-- Name: FUNCION_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "FUNCION"
    ADD CONSTRAINT "FUNCION_pkey" PRIMARY KEY ("ID_FUN");


--
-- TOC entry 2141 (class 2606 OID 25070)
-- Name: FUN_VIEW_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "FUN_VIEW"
    ADD CONSTRAINT "FUN_VIEW_pkey" PRIMARY KEY ("FUNCION_ID_FUN", "VIEW_ID_VIEW");


--
-- TOC entry 2145 (class 2606 OID 25092)
-- Name: HISTORIA DE USUARIO_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "HISTORIA DE USUARIO"
    ADD CONSTRAINT "HISTORIA DE USUARIO_pkey" PRIMARY KEY ("ID_HU");


--
-- TOC entry 2177 (class 2606 OID 25342)
-- Name: ID; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "VISTO"
    ADD CONSTRAINT "ID" PRIMARY KEY ("ID VISTO");


--
-- TOC entry 2179 (class 2606 OID 25366)
-- Name: ID_APROBADO; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "APROBADO"
    ADD CONSTRAINT "ID_APROBADO" PRIMARY KEY ("ID_APROBADO");


--
-- TOC entry 2163 (class 2606 OID 25158)
-- Name: PAR_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "PAR"
    ADD CONSTRAINT "PAR_pkey" PRIMARY KEY ("ID_PAR");


--
-- TOC entry 2149 (class 2606 OID 25114)
-- Name: PERSONA_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "PERSONA"
    ADD CONSTRAINT "PERSONA_pkey" PRIMARY KEY ("ID_PERSONA");


--
-- TOC entry 2169 (class 2606 OID 25185)
-- Name: PROYECTO_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "PROYECTO"
    ADD CONSTRAINT "PROYECTO_pkey" PRIMARY KEY ("ID_PROYECTO");


--
-- TOC entry 2137 (class 2606 OID 25054)
-- Name: ROL_FUNCION_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ROL_FUNCION"
    ADD CONSTRAINT "ROL_FUNCION_pkey" PRIMARY KEY ("ROL_ID_ROL", "FUNCION_ID_FUN");


--
-- TOC entry 2135 (class 2606 OID 25049)
-- Name: ROL_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ROL"
    ADD CONSTRAINT "ROL_pkey" PRIMARY KEY ("ID_ROL");


--
-- TOC entry 2151 (class 2606 OID 25122)
-- Name: SESSION_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "SESSION"
    ADD CONSTRAINT "SESSION_pkey" PRIMARY KEY ("ID_SESSION", "USER_ID_USS");


--
-- TOC entry 2175 (class 2606 OID 25206)
-- Name: TAREA_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "TAREA"
    ADD CONSTRAINT "TAREA_pkey" PRIMARY KEY ("ID_TAREA", "HISTORIA DE USUARIO_ID_HU");


--
-- TOC entry 2147 (class 2606 OID 25103)
-- Name: TEST_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "TEST"
    ADD CONSTRAINT "TEST_pkey" PRIMARY KEY ("ID_TEST");


--
-- TOC entry 2131 (class 2606 OID 25033)
-- Name: USER_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "USER"
    ADD CONSTRAINT "USER_pkey" PRIMARY KEY ("ID_USS");


--
-- TOC entry 2133 (class 2606 OID 25038)
-- Name: USS_ROL_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "USS_ROL"
    ADD CONSTRAINT "USS_ROL_pkey" PRIMARY KEY ("USER_ID_USS", "ROL_ID_ROL");


--
-- TOC entry 2143 (class 2606 OID 25081)
-- Name: VIEW_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "VIEW"
    ADD CONSTRAINT "VIEW_pkey" PRIMARY KEY ("ID_VIEW");


--
-- TOC entry 2208 (class 2606 OID 25372)
-- Name: APROBADO_ID_HU_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "APROBADO"
    ADD CONSTRAINT "APROBADO_ID_HU_fkey" FOREIGN KEY ("ID_HU") REFERENCES "HISTORIA DE USUARIO"("ID_HU");


--
-- TOC entry 2207 (class 2606 OID 25367)
-- Name: APROBADO_ID_USER_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "APROBADO"
    ADD CONSTRAINT "APROBADO_ID_USER_fkey" FOREIGN KEY ("ID_USER") REFERENCES "USER"("ID_USS");


--
-- TOC entry 2193 (class 2606 OID 25267)
-- Name: ASGINACION PERSONA_EQUIPO_EQUIPO_ID_EQUIPO_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASGINACION PERSONA_EQUIPO"
    ADD CONSTRAINT "ASGINACION PERSONA_EQUIPO_EQUIPO_ID_EQUIPO_fkey" FOREIGN KEY ("EQUIPO_ID_EQUIPO") REFERENCES "EQUIPO"("ID_EQUIPO");


--
-- TOC entry 2192 (class 2606 OID 25262)
-- Name: ASGINACION PERSONA_EQUIPO_PERSONA_ID_PERSONA_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASGINACION PERSONA_EQUIPO"
    ADD CONSTRAINT "ASGINACION PERSONA_EQUIPO_PERSONA_ID_PERSONA_fkey" FOREIGN KEY ("PERSONA_ID_PERSONA") REFERENCES "PERSONA"("ID_PERSONA");


--
-- TOC entry 2194 (class 2606 OID 25272)
-- Name: ASIGNACION EQUIPO_HU_EQUIPO_ID_EQUIPO_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION EQUIPO_HU"
    ADD CONSTRAINT "ASIGNACION EQUIPO_HU_EQUIPO_ID_EQUIPO_fkey" FOREIGN KEY ("EQUIPO_ID_EQUIPO") REFERENCES "EQUIPO"("ID_EQUIPO");


--
-- TOC entry 2195 (class 2606 OID 25277)
-- Name: ASIGNACION EQUIPO_HU_HISTORIA DE USUARIO_ID_HU_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION EQUIPO_HU"
    ADD CONSTRAINT "ASIGNACION EQUIPO_HU_HISTORIA DE USUARIO_ID_HU_fkey" FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") REFERENCES "HISTORIA DE USUARIO"("ID_HU");


--
-- TOC entry 2200 (class 2606 OID 25302)
-- Name: ASIGNACION EQUIPO_PROYECTO_EQUIPO_ID_EQUIPO_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION EQUIPO_PROYECTO"
    ADD CONSTRAINT "ASIGNACION EQUIPO_PROYECTO_EQUIPO_ID_EQUIPO_fkey" FOREIGN KEY ("EQUIPO_ID_EQUIPO") REFERENCES "EQUIPO"("ID_EQUIPO");


--
-- TOC entry 2201 (class 2606 OID 25307)
-- Name: ASIGNACION EQUIPO_PROYECTO_PROYECTO_ID_PROYECTO_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION EQUIPO_PROYECTO"
    ADD CONSTRAINT "ASIGNACION EQUIPO_PROYECTO_PROYECTO_ID_PROYECTO_fkey" FOREIGN KEY ("PROYECTO_ID_PROYECTO") REFERENCES "PROYECTO"("ID_PROYECTO");


--
-- TOC entry 2197 (class 2606 OID 25287)
-- Name: ASIGNACION HU_TEST_HISTORIA DE USUARIO_ID_HU_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION HU_TEST"
    ADD CONSTRAINT "ASIGNACION HU_TEST_HISTORIA DE USUARIO_ID_HU_fkey" FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") REFERENCES "HISTORIA DE USUARIO"("ID_HU");


--
-- TOC entry 2196 (class 2606 OID 25282)
-- Name: ASIGNACION HU_TEST_TEST_ID_TEST_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION HU_TEST"
    ADD CONSTRAINT "ASIGNACION HU_TEST_TEST_ID_TEST_fkey" FOREIGN KEY ("TEST_ID_TEST") REFERENCES "TEST"("ID_TEST");


--
-- TOC entry 2198 (class 2606 OID 25292)
-- Name: ASIGNACION PERSONA_PAR_PAR_ID_PAR_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION PERSONA_PAR"
    ADD CONSTRAINT "ASIGNACION PERSONA_PAR_PAR_ID_PAR_fkey" FOREIGN KEY ("PAR_ID_PAR") REFERENCES "PAR"("ID_PAR");


--
-- TOC entry 2199 (class 2606 OID 25297)
-- Name: ASIGNACION PERSONA_PAR_PERSONA_ID_PERSONA_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION PERSONA_PAR"
    ADD CONSTRAINT "ASIGNACION PERSONA_PAR_PERSONA_ID_PERSONA_fkey" FOREIGN KEY ("PERSONA_ID_PERSONA") REFERENCES "PERSONA"("ID_PERSONA");


--
-- TOC entry 2203 (class 2606 OID 25317)
-- Name: ASIGNACION PROYECTO_HU_HISTORIA DE USUARIO_ID_HU_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION PROYECTO_HU"
    ADD CONSTRAINT "ASIGNACION PROYECTO_HU_HISTORIA DE USUARIO_ID_HU_fkey" FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") REFERENCES "HISTORIA DE USUARIO"("ID_HU");


--
-- TOC entry 2202 (class 2606 OID 25312)
-- Name: ASIGNACION PROYECTO_HU_PROYECTO_ID_PROYECTO_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNACION PROYECTO_HU"
    ADD CONSTRAINT "ASIGNACION PROYECTO_HU_PROYECTO_ID_PROYECTO_fkey" FOREIGN KEY ("PROYECTO_ID_PROYECTO") REFERENCES "PROYECTO"("ID_PROYECTO");


--
-- TOC entry 2191 (class 2606 OID 25257)
-- Name: ASIGNAR USER_HU_HISTORIA DE USUARIO_ID_HU_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNAR USER_HU"
    ADD CONSTRAINT "ASIGNAR USER_HU_HISTORIA DE USUARIO_ID_HU_fkey" FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") REFERENCES "HISTORIA DE USUARIO"("ID_HU");


--
-- TOC entry 2190 (class 2606 OID 25252)
-- Name: ASIGNAR USER_HU_USER_ID_USS_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ASIGNAR USER_HU"
    ADD CONSTRAINT "ASIGNAR USER_HU_USER_ID_USS_fkey" FOREIGN KEY ("USER_ID_USS") REFERENCES "USER"("ID_USS");


--
-- TOC entry 2185 (class 2606 OID 25227)
-- Name: FUN_VIEW_FUNCION_ID_FUN_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "FUN_VIEW"
    ADD CONSTRAINT "FUN_VIEW_FUNCION_ID_FUN_fkey" FOREIGN KEY ("FUNCION_ID_FUN") REFERENCES "FUNCION"("ID_FUN");


--
-- TOC entry 2186 (class 2606 OID 25232)
-- Name: FUN_VIEW_VIEW_ID_VIEW_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "FUN_VIEW"
    ADD CONSTRAINT "FUN_VIEW_VIEW_ID_VIEW_fkey" FOREIGN KEY ("VIEW_ID_VIEW") REFERENCES "VIEW"("ID_VIEW");


--
-- TOC entry 2187 (class 2606 OID 25237)
-- Name: HISTORIA DE USUARIO_ESTADO HISTORIA DE USUARIO_ID_ESTADO_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "HISTORIA DE USUARIO"
    ADD CONSTRAINT "HISTORIA DE USUARIO_ESTADO HISTORIA DE USUARIO_ID_ESTADO_fkey" FOREIGN KEY ("ESTADO HISTORIA DE USUARIO_ID_ESTADO") REFERENCES "ESTADO HISTORIA DE USUARIO"("ID_ESTADO");


--
-- TOC entry 2188 (class 2606 OID 25242)
-- Name: PERSONA_USER_ID_USS_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "PERSONA"
    ADD CONSTRAINT "PERSONA_USER_ID_USS_fkey" FOREIGN KEY ("USER_ID_USS") REFERENCES "USER"("ID_USS");


--
-- TOC entry 2184 (class 2606 OID 25222)
-- Name: ROL_FUNCION_FUNCION_ID_FUN_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ROL_FUNCION"
    ADD CONSTRAINT "ROL_FUNCION_FUNCION_ID_FUN_fkey" FOREIGN KEY ("FUNCION_ID_FUN") REFERENCES "FUNCION"("ID_FUN");


--
-- TOC entry 2183 (class 2606 OID 25217)
-- Name: ROL_FUNCION_ROL_ID_ROL_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "ROL_FUNCION"
    ADD CONSTRAINT "ROL_FUNCION_ROL_ID_ROL_fkey" FOREIGN KEY ("ROL_ID_ROL") REFERENCES "ROL"("ID_ROL");


--
-- TOC entry 2189 (class 2606 OID 25247)
-- Name: SESSION_USER_ID_USS_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "SESSION"
    ADD CONSTRAINT "SESSION_USER_ID_USS_fkey" FOREIGN KEY ("USER_ID_USS") REFERENCES "USER"("ID_USS");


--
-- TOC entry 2204 (class 2606 OID 25322)
-- Name: TAREA_HISTORIA DE USUARIO_ID_HU_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "TAREA"
    ADD CONSTRAINT "TAREA_HISTORIA DE USUARIO_ID_HU_fkey" FOREIGN KEY ("HISTORIA DE USUARIO_ID_HU") REFERENCES "HISTORIA DE USUARIO"("ID_HU");


--
-- TOC entry 2180 (class 2606 OID 25330)
-- Name: USER_ROL_ID_ROL_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "USER"
    ADD CONSTRAINT "USER_ROL_ID_ROL_fkey" FOREIGN KEY ("ROL_ID_ROL") REFERENCES "ROL"("ID_ROL");


--
-- TOC entry 2182 (class 2606 OID 25212)
-- Name: USS_ROL_ROL_ID_ROL_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "USS_ROL"
    ADD CONSTRAINT "USS_ROL_ROL_ID_ROL_fkey" FOREIGN KEY ("ROL_ID_ROL") REFERENCES "ROL"("ID_ROL");


--
-- TOC entry 2181 (class 2606 OID 25207)
-- Name: USS_ROL_USER_ID_USS_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "USS_ROL"
    ADD CONSTRAINT "USS_ROL_USER_ID_USS_fkey" FOREIGN KEY ("USER_ID_USS") REFERENCES "USER"("ID_USS");


--
-- TOC entry 2205 (class 2606 OID 25343)
-- Name: VISTO_ID_HU_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "VISTO"
    ADD CONSTRAINT "VISTO_ID_HU_fkey" FOREIGN KEY ("ID_HU") REFERENCES "HISTORIA DE USUARIO"("ID_HU");


--
-- TOC entry 2206 (class 2606 OID 25348)
-- Name: VISTO_ID_USER_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY "VISTO"
    ADD CONSTRAINT "VISTO_ID_USER_fkey" FOREIGN KEY ("ID_USER") REFERENCES "USER"("ID_USS");


--
-- TOC entry 2329 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: -
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-07-19 01:34:46

--
-- PostgreSQL database dump complete
--

