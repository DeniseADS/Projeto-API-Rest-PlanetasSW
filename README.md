# Projeto-API-Rest-PlanetasSW
API REST em Java (Eclipse JEE 2018-12) para desafio da B2W

O Projeto: Criar API rest para armazenar dados (nome,clima,terreno)de planetas dos filmes da Franquia Star Wars Retornando também as aparições em filmes registradas na API pública Star Wars :https://swapi.co/

Funcionalidades:
.Adicionar planetas(nome,clima,terreno)
.Listar planetas
.Buscar por nome
.Buscar por ID 
.Remover planetas

Ferramentas e Tecnologias:
.Java 8 em Eclipse JEE versão 2018-12 
convertido para Maven (dependências) com API Jersey para Rest em Java
.Banco de dados local MySql 5.7.25 (user "root", password "d1972e") - localhost: 3306 
.Testado no Postman com requisições Get,Post e Delete em json 

Obs.:
Casos de erros no pom.xml fazer Update Maven (project)
project> maven>update project > marcar force update
