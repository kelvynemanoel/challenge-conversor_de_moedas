# Conversor de Moedas em Java

## Descrição do Projeto

Este projeto é um **Conversor de Moedas** desenvolvido em **Java**, que interage com o usuário via console. Ele permite converter valores entre diferentes moedas utilizando taxas de câmbio **em tempo real** fornecidas pela **API ExchangeRate**.

O programa oferece **6 opções de conversão** e realiza as seguintes etapas:

1. Mostra um menu de opções de moedas para o usuário escolher.
2. Solicita o valor a ser convertido.
3. Faz uma **requisição HTTP** para a API ExchangeRate para obter a taxa de câmbio atual.
4. Desserializa a resposta JSON usando a biblioteca **Gson**.
5. Calcula o valor convertido e exibe o resultado no console.

---

## Funcionalidades

* Conversão entre as seguintes moedas:

  1. Dólar (USD) → Real (BRL)
  2. Real (BRL) → Dólar (USD)
  3. Euro (EUR) → Real (BRL)
  4. Real (BRL) → Euro (EUR)
  5. Dólar (USD) → Euro (EUR)
  6. Euro (EUR) → Dólar (USD)

* Busca de taxas de câmbio **dinâmicas e atualizadas em tempo real**.

* Desserialização do JSON da API para manipulação no código Java.

* Interação simples e direta com o usuário via console.

* Tratamento básico de erros, caso a API não retorne os dados corretamente.

---

## Tecnologias Utilizadas

* **Java 8 ou superior**
* **Gson** (biblioteca para desserialização JSON)
* **ExchangeRate API** ([https://www.exchangerate-api.com/](https://www.exchangerate-api.com/))

---

## Estrutura do Código

O projeto contém uma única classe principal `ConversorMoedas` com os seguintes componentes:

1. **Constantes**:

   * `API_KEY`: chave de acesso à API ExchangeRate.
   * `BASE_URL`: URL base da API.

2. **Método `getTaxa(String from, String to)`**:

   * Faz a requisição HTTP para o endpoint `/pair/{from}/{to}`.
   * Recebe a resposta JSON.
   * Desserializa usando Gson.
   * Retorna a taxa de conversão (`conversion_rate`).

3. **Método `main`**:

   * Exibe o menu de opções no console.
   * Recebe a opção do usuário e o valor a ser convertido.
   * Chama o método `getTaxa` para obter a taxa.
   * Calcula o valor convertido e exibe o resultado.

---

## Como Rodar o Projeto

1. **Clonar o repositório**:

```bash
git clone <URL_DO_REPOSITORIO>
cd <NOME_DO_REPOSITORIO>
```

2. **Adicionar a dependência do Gson**:

Se estiver usando Maven, adicione no `pom.xml`:

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```

3. **Executar a aplicação**:

* Pelo IntelliJ: clique em **Run** na classe `ConversorMoedas`.
* Pelo terminal:

```bash
javac ConversorMoedas.java
java ConversorMoedas
```

4. **Interagir com o programa**:

* Escolha a opção de conversão digitando o número correspondente.
* Informe o valor a ser convertido.
* O programa exibirá o valor convertido com base na taxa atual da API.

---

## Exemplo de Uso

```
=== Conversor de Moedas ===
Escolha uma opção:
1 - Dólar (USD) -> Real (BRL)
2 - Real (BRL) -> Dólar (USD)
3 - Euro (EUR) -> Real (BRL)
4 - Real (BRL) -> Euro (EUR)
5 - Dólar (USD) -> Euro (EUR)
6 - Euro (EUR) -> Dólar (USD)
Opção: 1
Digite o valor a ser convertido: 100
100.00 USD = 486.65 BRL
```

---

## Observações

* A taxa de câmbio é obtida **em tempo real**, portanto os valores podem variar a cada execução.
* Caso a API esteja fora do ar ou a chave seja inválida, o programa exibirá a mensagem:

```
Erro ao acessar a API: <mensagem de erro>
Não foi possível realizar a conversão.
```

* Para adicionar mais opções de conversão, basta incluir novas opções no **menu** e atualizar o **switch-case** no `main`.

---

## Próximos Passos / Melhorias

* Adicionar histórico de conversões enquanto o programa estiver rodando.
* Permitir múltiplas conversões em uma única execução.
* Criar uma interface gráfica (GUI) para tornar o programa mais amigável.
* Adicionar tratamento de exceções mais detalhado, incluindo validação de entrada do usuário.
