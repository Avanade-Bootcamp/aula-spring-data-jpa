# Spring Framework Fundamentos

- O que e o Spring Frameword
- Spring Vesus Java EE
- Conveito de Inversao de Controle (IOC)
- Injecao de dependencias
- Beans \ Autowired \ Scopes

## Spring Framework

Framework open source desenvolvido na plataforma Java **baseado nos padroes de projetos inversao de controle e injecao de dependencia.**

**Estrutara baseada em modulos** para reduzir a complexidade no desenvolvimento de aplicacoes simples ou corporativas

<blockquote style="background-color: #f7f7f7; border-left: 5px solid #333; padding: 10px; font-style: italic; color: #333;">
Queremos trabalhar com dados? teremos um modulo especifco, queremos trabalhar com seguranca? tambem teremos um modulo especifico
</blockquote>

![[Pasted image 20250212004419.png]]


# Primeiros passos com Springboot

Para gerar um projeto com springboot, sera necessario acessar o [Spring Initializr](https://start.spring.io).

Configuracao utilizada para gerar meu projeto:


| Campos               | Valor                           |
| -------------------- | ------------------------------- |
| Project              | [x] Maven                       |
| Language             | [x] Java                        |
| Spring boot          | [x] 3.4.2                       |
| **Project Metadata** |                                 |
| Group                | dio                             |
| Article              | primeiros-passos                |
| Name                 | primeiros-passos                |
| Description          | Primeiros passos com springboot |
| Package name         | dio.springboot                  |
| Packaging            | [x] Jar                         |
| Java                 | [x] 17                          |
| Dependencies         | No dependency selected          |


## IoC ( Inversao de Controle )

Sem IoC, voce crie e gerencia o ciclo de vida de objetos que foram instaciados pelo `new`. Com IoC, esse controle eh delegado para a um container(como o spring), que cuida da criacao, configuracao e ciclo de vida dos objetos.

No contexto do Spring, o **container** é o próprio **Spring Framework**, que gerencia a criação, injeção e ciclo de vida dos objetos da aplicação.

Esse container é chamado de **ApplicationContext**, e ele é responsável por:  
✅ Criar instâncias de classes (beans) automaticamente.  
✅ Resolver dependências e injetá-las onde necessário.  
✅ Controlar o ciclo de vida dos objetos.  
✅ Aplicar configurações automáticas com base no contexto da aplicação.


## Beans

Objeto que e instanciado(criado), montado e gerenciado por um container atraves do principio da inversao de controle

## Scopes

- Standalone
	- [[Singleton]]
	- [[Prototype]]
- HTTP
	- [[Requests]]
	- [[Session]]
	- [[Global]]
## Autowired

Uma anotacao onde devera ocorrer uma injecao automatica de dependencia


```prompt
eu nao entendi a questao de baixo acoplamento. me explique o pq seria complicado sem IoC e me explique porque seria menos complicado com IoC me traga exemplos claros de codigo
```

# Java Persistence API (JPA)

# Conceitos

- ORM: Aproxima o paradigma da orientacoes a objetos ao banco de dados relacional![[Pasted image 20250213234840.png]]
- JPA: Especificacao baseada em interfaces, que atraves de um framework realiza operacoes de persistencia de objetos em Java - Framework comumente utilizado e o Hibernate![[Pasted image 20250213235118.png]]
- Mapeamentos: Aspectos das anotacoes de mapeamento do JPA(o que nossas classes tem que ter)
	- Identificacao
	- Definicao
	- Relacionamento
	- Heranca
	- Persistencia
	![[Pasted image 20250213235417.png]]
- EntityManager: ![[Pasted image 20250213235623.png]]

# Conexao com Postgres

Nessa parte da aula, nao foi ensinado a realizar a configuracao do postgres, entao decidi fazer por docker. Basta seguir os passos abaixo.

1. Realizar download do docker na propria plataforma deles.
2. Apos a instalacao, voce deve executar este comando no seu terminal
```bash
docker run --name some-postgres -e POSTGRES_PASSWORD=mysecretpassword -p 5432:5432 -d postgres
```
3. Com isso, teremos essa configuracao:
	- **Host:** `localhost`
	- **Porta:** `5432`
	- **Database:** `postgres`
	- **Username:** `postgres`
	- **Password:** `mysecretpassword`

Realizando todas essas instrucoes, estamos aptos para seguir com as aulas.

Para nos conectarmos atraves do codigo, temos que cofigura-lo atraves do `application.propeties`.

Apos isso, temos que adicionara indencia no nosso `pom.xml` tambem.

basta adicionar este trecho de codigo:

```xml
<dependency
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
```

Com isso, podemos iniciar o nosso codigo, onde o mesmo ja fara todas as implementacoes e inserir o usuario que esta no codigo. 
Toda a execucao foi um sucesso, e ja foi possivel gerar o usuario:![[Pasted image 20250214004420.png]]
