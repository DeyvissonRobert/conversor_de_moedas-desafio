# 💱 Conversor de Moedas - Desafio ONE Alura

Este é um projeto Java desenvolvido como parte do programa Oracle Next Education - Alura, com o objetivo de praticar conceitos como requisições HTTP, tratamento de JSON com Gson, interação com o usuário via terminal e boas práticas de programação.

---

## ✨ Funcionalidades

- Conversão entre **6 moedas diferentes**:
  - USD (Dólar americano)
  - BRL (Real brasileiro)
  - ARS (Peso argentino)
  - CLP (Peso chileno)
  - COP (Peso colombiano)
  - BOB (Boliviano boliviano)

- Requisição de dados em tempo real utilizando a API [ExchangeRate API](https://www.exchangerate-api.com/)
- Interface de linha de comando com menu interativo
- Conversão entre **todas as combinações possíveis das moedas acima**
- Formatação amigável dos resultados no terminal

---

## 🛠 Tecnologias utilizadas

- Java 17+
- Biblioteca `Gson` (Google) para tratar JSON
- `HttpClient` nativo para chamadas à API
- API de câmbio: [https://www.exchangerate-api.com](https://www.exchangerate-api.com)

---

## 💻 Exemplo no terminal

```bash
===== CONVERSOR DE MOEDAS =====

Escolha a moeda de origem:
1 - USD
2 - BRL
3 - ARS
4 - CLP
5 - COP
6 - BOB
0 - Sair
-------------------------------
Digite a opção: 1

Agora escolha a moeda de destino:
1 - USD
2 - BRL
3 - ARS
4 - CLP
5 - COP
6 - BOB
-------------------------------
Digite a opção: 2

Digite o valor que deseja converter: 100

==============================
  100.00 [USD] -> 546.00 [BRL]
  Dólar americano para Real brasileiro
==============================

```
## ▶️ Como executar o projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/DeyvissonRobert/conversor_de_moedas-desafio
