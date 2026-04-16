# Automação SauceDemo Selenium

## Sobre o projeto

Projeto de automação de testes do site SauceDemo, desenvolvido em Java com Selenium,
seguindo o padrão Page Object Model (POM), com foco em qualidade, manutenibilidade
e cobertura dos principais fluxos de e-commerce.


<p align="center"><img src="imagens/saucedemo-logo.png" width="500px"></p>

## Cenários Desenvolvidos

Mapeamento de prioridade e risco para garantir a qualidade do fluxo principal de e-commerce.

| ID           | Cenário de Teste                  | Prioridade | Risco   | Impacto do Risco                                                |
|:-------------|:----------------------------------|:-----------|:--------|:----------------------------------------------------------------|
| **CT-001**   | Login Válido                      | Alta       | Crítico | Bloqueio total de uso da plataforma por clientes legítimos.     |
| **CT-002.1** | Login Usuário Bloqueado           | Alta       | Alto    | Usuários restritos acessando o sistema e realizando compras.    |
| **CT-002.2** | Login sem Senha                   | Média      | Baixo   | Mensagem de erro ausente, mas o acesso continua restrito.       |
| **CT-002.3** | Login Usuário Inválido            | Média      | Baixo   | Tentativas de invasão (brute force) sem barreira de erro.       |
| **CT-003**   | Compra de um Item                 | Alta       | Crítico | Principal fluxo de receita. Falha impede a venda.               |
| **CT-004**   | Compra de dois Itens              | Alta       | Crítico | Erro no cálculo de múltiplos itens gera prejuízo financeiro.    |
| **CT-005.1** | Checkout sem First Name           | Média      | Médio   | Dados de entrega incompletos gerando falha logística.           |
| **CT-005.2** | Checkout sem Last Name            | Média      | Médio   | Dados de entrega incompletos gerando falha logística.           |
| **CT-005.3** | Checkout sem Postal Code          | Alta       | Alto    | Impossibilidade de calcular frete ou entregar o produto.        |
| **CT-006**   | Realizar Logout                   | Média      | Médio   | Sessões abertas em dispositivos públicos (falha de segurança).  |

## Tecnologias Utilizadas

Este projeto utiliza a stack de automação Java com as seguintes tecnologias:

    - Java 21: Linguagem base do projeto.
    - Selenium WebDriver (4.38.0): Manipulação e interação com o navegador.
    - JUnit 5: Framework de execução de testes.
    - Gradle: Gerenciador de dependências e automação de build.

## Boas práticas adotadas

- Page Object Model (POM)
- Separação de responsabilidades (pages, flows, tests, validations)
- Execução via Gradle Wrapper
- Java Toolchain (Java 21)
- Dados de teste desacoplados do código

## Como rodar o Projeto na sua Máquina

### Pré-requisitos
Você precisa ter instalado na sua máquina:

- [JDK 21](https://www.oracle.com/java/technologies/downloads/#java21)
- [IntelliJ Idea](https://www.jetbrains.com/idea/download/?section=windows) (Recomendado)

* Este projeto utiliza **Gradle Wrapper**, não é necessário instalar o Gradle na máquina!
* O projeto utiliza **Java 21**, definido via Gradle Toolchain, garantindo a mesma versão de Java em qualquer ambiente de execução.


### Clonar projeto
- Para realizar o clone do projeto, clique em clone, escolha a forma que deseja fazer a clonagem (se por SSH ou HTTPS), no seu ambiente local de trabalho, abra o terminal, cole o seguinte código e execute o comando: `git clone [cole-o-link-copiado-aqui]`

### Como executar projeto
- Após o clone do projeto, acesse o diretório recém clonado;

#### Executar via terminal
- Para rodar todos os testes e gerar relatórios, escolha abaixo e execute o comando relacionado.

| Testes | Bash                               | Powershell                         |
|--------|------------------------------------|------------------------------------|
| Todos  | `./gradlew test`                   | `.\gradlew test`                   |
| Classe | `./gradlew test --tests LoginTest` | `.\gradlew test --tests LoginTest` |

* Caso você queira rodar uma outra classe, é só alterar LoginTest pela classe de testes desejada.
* Caso você queira rodar somente um método de uma classe, use o comando `./gradlew test --tests` + `"Classe.nomeDoMetodo"`, exemplo: `./gradlew test --tests "LoginTest.deveRealizarLoginComSucesso"`

#### Executar via Gradle
- No IntelliJ (ou na sua IDE de preferência), navegue até o arquivo build.gradle e execute a run test ou clique com o botão direito no arquivo `build.gradle` e selecione **Run 'selenium-saucedemo-3.0'**

## Relatórios

Após a execução dos testes, os relatórios são gerados na pasta: `reports/`.
Os relatórios gerados são em formato HTML e podem ser abertos diretamente no navegador.

## Arquitetura do projeto

O projeto segue o padrão Page Object Model (POM) para  a legibilidade, reutilização de código e facilitar a manutenção dos testes automatizados:

- pages: Contém os Page Objects, responsáveis pelo mapeamento dos elementos e pelas ações realizadas nas páginas da aplicação.
- flows: Implementa fluxos de negócio reutilizáveis, orquestrando ações entre diferentes páginas.
- tests: Classes de teste responsáveis por executar os cenários automatizados utilizando Java e Selenium.
- validations: Centraliza as validações e asserções das telas e dos comportamentos esperados.
- models: Objetos de domínio utilizados para representar e trafegar dados nos testes.
- utils: Classes utilitárias e de suporte, como configuração de drivers, leitura de dados, datas e criação de arquivos.
- resources/config: Arquivos de configuração do ambiente de testes.
- resources/testData: Massa de dados utilizada na execução dos testes.

Projeto desenvolvido por [Amanda Kopper Hammes](https://github.com/amandahammes) em abril/2026.