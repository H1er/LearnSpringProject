DROP TABLE IF EXISTS "animal";
DROP TABLE IF EXISTS "owner";

CREATE TABLE "owner"
(
    "id"      INTEGER PRIMARY KEY,
    "name"    VARCHAR(100),
    "age"     INTEGER,
    "address" VARCHAR(500)
);

CREATE TABLE "animal"(
    "id"   INTEGER PRIMARY KEY,
    "age"  INTEGER,
    "name" VARCHAR(50),
    "race" VARCHAR(50),
    "owner_id" VARCHAR(100),
    CONSTRAINT "owner_id_fk" FOREIGN KEY (owner_id) REFERENCES owner(id)
);