CREATE OR REPLACE FUNCTION buscarHU(in nom varchar,out ID bigint,out Descripcion varchar ,out nombre varchar, out Importancia varchar )
  RETURNS setof record AS
$BODY$
BEGIN
	Select "ID_HU","DESCRIPCION","NOMBRE","IMPORTANCIA" from "HISTORIA DE USUARIO" where "NOMBRE"=nom;
RETURN var;
END;
$BODY$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION estadoHU(in id integer)
  RETURNS varchar AS
$BODY$
declare var varchar;
BEGIN
	Select "DESCRIPCION" FROM "ESTADO HISTORIA DE USUARIO" WHERE "ESTADO HISTORIA DE USUARIO"."HISTORIA DE USUARIO_ID_HU"=id;
RETURN;
END;
$BODY$
  LANGUAGE plpgsql;
