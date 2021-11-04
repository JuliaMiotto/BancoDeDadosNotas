CREATE TABLE NotasAlunos (
    Nome_Aluno    VARCHAR PRIMARY KEY
                          UNIQUE
                          NOT NULL,
    Trabalho1     NUMERIC,
    Prova1        NUMERIC,
    Trabalho2     NUMERIC,
    Prova2        NUMERIC,
    MediaBimestre NUMERIC
);