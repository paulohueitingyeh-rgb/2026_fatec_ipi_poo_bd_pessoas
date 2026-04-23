-- INSERT INTO tb_pessoa
-- (nome, fone, email, ativo)
-- VALUES
-- ('Anna', '77773333', 'anna@email.com', 1);

-- INSERT INTO tb_pessoa
-- (nome, fone, email)
-- VALUES
-- ('Cristiva', '77774444', 'cristina@email.com');

--COMO INCLUIR UMA COLUNA CHAMADA ATIVO COM VALOR INTEIRO IGUAL A 1 , DO TIPO INTEIRO
-- ALTER TABLE tb_pessoa
-- ADD COLUMN ativo INTEGER DEFAULT 1
-- CHECK (ativo IN (0, 1));



-- DELETE FROM tb_pessoa
-- --filtro
-- WHERE nome = 'maria';

-- SELECT nome, email FROM tb_pessoa --projeção
-- WHERE cod_pessoa = 2 OR cod_pessoa = 3
-- mesma coisa
-- WHERE cod_pessoa IN (2, 3);

-- UPDATE tb_pessoa SET --trocou o nome da tabela da coluna nome posição 1
-- nome = 'José da Silva'
-- WHERE cod_pessoa =1;

-- INSERT INTO tb_pessoa
-- (nome, fone, email)
-- VALUES
-- ('João', '87654321', 'joao@email.com'),
-- ('Maria', '77884433', 'maria@email.com');


-- SELECT * FROM tb_pessoa -- o * seleciona todas as colunas sem filtro

-- INSERT INTO tb_pessoa
-- (nome, fone, email)
-- VALUES
-- ('José', '12345678', 'jose@email.com');

-- CREATE TABLE tb_pessoa(
-- 	cod_pessoa SERIAL PRIMARY KEY, --SERIA SERVE PARA ALTO INCREMENTO
-- 	nome VARCHAR(255),
-- 	fone VARCHAR(255),
-- 	email VARCHAR(255)
-- );
