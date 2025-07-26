# 💱 Conversor de Moedas - Desafio ONE Alura

Este é um projeto Java desenvolvido como parte do programa Oracle Next Education - Alura, com o objetivo de praticar conceitos como requisições HTTP, tratamento de JSON com Gson, interação com o usuário via terminal e boas práticas de programação.

---

## ✨ Funcionalidades principais

- Conversão entre **8 moedas**:
  - USD – Dólar americano
  - BRL – Real brasileiro
  - ARS – Peso argentino
  - BOB – Boliviano
  - CLP – Peso chileno
  - COP – Peso colombiano
  - EUR – Euro
  - JPY – Iene japonês

- Requisição de taxas de câmbio em tempo real via [ExchangeRate API](https://www.exchangerate-api.com/)
- Menu interativo no terminal
- Conversão entre todas as combinações possíveis das moedas acima

---

## 🌟 Funcionalidades extras implementadas

Esses recursos foram implementados além do escopo proposto no desafio original:

- 📜 Histórico de conversões realizadas durante a sessão
- 🕒 Registro com data e hora de cada conversão (utilizando java.time)
- 💬 Saída formatada com clareza para facilitar a leitura no terminal
- ✚ Suporte expandido para mais moedas (Euro e Iene Japonês)

---

## 🛠 Tecnologias utilizadas

- Java 17+
- Gson (Google) para manipulação de JSON
- API ExchangeRate para taxas de câmbio
- HttpClient nativo do Java para chamadas HTTP
- java.time para registro de logs e histórico
- Terminal interativo com Scanner

---

## 💻 Exemplo de execução no terminal

```bash
======= CONVERSOR DE MOEDAS =======
Escolha a moeda de origem:
1 - USD (Dólar Americano)
2 - BRL (Real Brasileiro)
3 - ARS (Peso Argentino)
4 - BOB (Boliviano)
5 - CLP (Peso Chileno)
6 - COP (Peso Colombiano)
7 - EUR (Euro)
8 - JPY (Iene Japonês)
0 - Sair
Opção: 1

Escolha a moeda de destino:
2 - BRL (Real Brasileiro)
...

Digite o valor que deseja converter: 100

==============================
  100.00 [USD] -> 546.00 [BRL]
  Dólar Americano para Real Brasileiro
==============================

==== HISTÓRICO DE CONVERSÕES ====
[26/07/2025 15:42:11] 100.00 [USD] -> 546.00 [BRL] (Dólar Americano para Real Brasileiro)
[26/07/2025 15:44:18] 250.00 [EUR] -> 29987.00 [JPY] (Euro para Iene Japonês)

```
## ▶️ Como executar o projeto

1. Clone este repositório:
   ```bash
   git clone https://github.com/DeyvissonRobert/conversor_de_moedas-desafio

2. Navegue até a pasta do projeto e compile:
   ```bash
   javac -cp .;gson-2.10.1.jar Principal.java
  Obs: No macOS/Linux use : no lugar de ; no classpath

3. Execute o programa:
   ```bash
   java -cp .;gson-2.10.1.jar Principal


## 🙏 Agradecimentos

Agradeço à equipe da Alura e à iniciativa Oracle Next Education (ONE) pela oportunidade de aprendizado e crescimento.

Este projeto foi um grande passo na minha evolução com Java, APIs e boas práticas de desenvolvimento.  
Obrigado também a todos que dedicarem um tempo para ver, testar ou dar feedback sobre esse trabalho.

📫 Fique à vontade para contribuir, sugerir melhorias ou entrar em contato!

