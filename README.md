# teste_qa
Projeto 'Teste para QA' do Woop Sicredi automação de testes UI utilizando DDT e Selenium WebDriver.

**Estratégia de teste:**

Técnica escolhida para a realização dos testes foi teste de caixa preta, validando se o sistema está operando conforme os critérios de aceitação.

**História:**

**Com o propósito de** Simular um Investimento na Poupança

**como um** Associado,

**eu gostaria de** preencher o formulário de simulação

**e ver** a tabela de resultado com Mês e Valor.

**Critério de aceitação:**
1. O associado preencher todos os campos corretamente e visualizar o formulário de simulação.
2. O associado preencher o Valor inferior a “20.00” e receber a mensagem de orientação “Valor mínimo de 20.00”.

**Tarefas: simular um investimento na Poupança como Associado**

- [POS]-Testar simulação com dados validos e validar os resultados na tabela para PF.

- [POS]-Testar simulação com dados validos e validar os resultados na tabela para PJ.

- [NEG]-Testar simulação com dados sem preencher campos obrigatórios.

- [NEG]-Testar simulação com dados com valores incorretos.

**Justificativa:**

Para os testes automatizados de UI foi utilizado a metodologia de testes dirigidos a dados DDT( Data Drive Testing) com o Selenium WebDriver.

É uma estratégia que visa impedir a duplição de scripts quando apenas os dados de entrada ou saída são diferentes.

Neste caso, os input de parâmetros de entrada e saída para a execução dos testes vem de um arquivo externo (.csv) e quanto mais linhas
conter no arquivo, mais testes são executados. Além do formato CSV, é possível trabalhar com XLS (Excel) ou mesmo JSON como DataLoader.

Para a validação dos testes, foram criados métodos de asserções, para validar se o resultado esperado está sendo apresentado corretamente na aplicação.

Em cada execução foi criado um log no qual facilita a busca e a manutenção de possíveis erros.

**Tecnologias:**
- Java 8.
- Maven.
- JUnit 4.
- Selenium WebDriver 3.6.
- Easetech 1.4 (DDT).


