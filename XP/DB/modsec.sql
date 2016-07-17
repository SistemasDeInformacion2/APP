CREATE OR REPLACE FUNCTION buscarUsuario(in idp integer)
  RETURNS integer AS
$BODY$
declare var integer;
BEGIN
	Select "USER_ID_USS" into var from "SESSION" where "PID"=idp;
RETURN var;
END;
$BODY$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION logout()
  RETURNS void AS
$BODY$
BEGIN
	Update "SESSION" Set "ACTIVO"=FALSE Where "PID"=pg_backend_pid();
RETURN;
END;
$BODY$
  LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION buscarIDUser(in idp varchar, out Uno bigint,out Dos varchar)
  RETURNS setof record AS
$BODY$
BEGIN
	return query Select "ID_USS","LOGIN" from "USER" where "LOGIN"=idp;
END;
$BODY$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION obtenerUsuario(in id integer)
  RETURNS varchar AS
$BODY$
declare var varchar;
BEGIN
	Select "LOGIN" into var from "USER" where "ID_USS"=id;
RETURN var;
END;
$BODY$
  LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION nuevasession(id integer)
  RETURNS void AS
$BODY$
BEGIN
	INSERT INTO "SESSION"("USER_ID_USS","FECHA","ACTIVO","PID") VALUES(id,current_date,true,null);
RETURN;
END;
$BODY$
  LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION asignarpid()
  RETURNS trigger AS
$BODY$
	BEGIN
		NEW."PID":=pg_backend_pid();
	RETURN NEW;
	END;
$BODY$
  LANGUAGE plpgsql;
CREATE TRIGGER asignarpid
  BEFORE INSERT
  ON "SESSION"
  FOR EACH ROW
  EXECUTE PROCEDURE asignarpid();

