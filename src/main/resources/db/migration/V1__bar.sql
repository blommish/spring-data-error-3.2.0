CREATE TABLE bar
(
    id UUID PRIMARY KEY
);

CREATE TABLE bar_external
(
    bar_external_id     BIGSERIAL PRIMARY KEY,
    bar_id UUID NOT NULL REFERENCES bar (id)
);

