-- Table: "user"

-- DROP TABLE "user";

CREATE TABLE "user"
(
  userid bigint,
  name text,
  email text,
  gender text,
  birthday date,
  password text,
  image text
)
WITH (
  OIDS=FALSE
);
ALTER TABLE "user"
  OWNER TO postgres;

-- Table: event

-- DROP TABLE event;

CREATE TABLE event
(
  eventid bigint NOT NULL,
  creatorid bigint,
  date date,
  eventname text,
  occasion text,
  location text,
  lon double precision,
  lat double precision,
  description text,
  numbermaleconfirmed int,
  numberfemaleconfirmed int
)
WITH (
  OIDS=FALSE
);
ALTER TABLE event
  OWNER TO postgres;

-- Table: message

-- DROP TABLE message;

CREATE TABLE message
(
  messageid bigint,
  eventid bigint,
  senderid bigint,
  recipientid bigint,
  textmessage text,
  date date
)
WITH (
  OIDS=FALSE
);
ALTER TABLE message
  OWNER TO postgres;

-- Table: participation

-- DROP TABLE participation;

CREATE TABLE participation
(
  participationid bigint,
  userid bigint,
  eventid bigint
)
WITH (
  OIDS=FALSE
);
ALTER TABLE participation
  OWNER TO postgres;