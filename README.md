# Ecommerce Store

Este é um projeto simples de loja virtual com interface baseada em linha de comando (CLI), desenvolvido em Java.

## 📦 Descrição

O sistema simula um e-commerce completo com funcionalidades para gerenciamento de produtos, contas de usuário (cliente, vendedor e administrador), realização de pedidos e geração de relatórios.

Os dados são armazenados localmente no arquivo `data/data.dat` utilizando serialização.

## 🚀 Como Executar

> ⚠️ Este projeto requer **Java 23** ou superior.

### Passos:

1. Instale o JDK 23+:
   - [Baixar JDK](https://www.oracle.com/br/java/technologies/downloads/)

2. Clone o repositório:

   ```bash
   git clone <url-do-repositorio>
   cd ecommerce-cli-application
   ```

3. Compile e execute o projeto:

   ```bash
   javac -d bin/ --source-path src/ `find -type f -name *.java`
   java -cp bin/ Main
   ```

## 🧩 Funcionalidades

- Cadastro e autenticação de usuários (cliente, vendedor, administrador)
- Cadastro de produtos
- Realização e gerenciamento de pedidos
- Geração de relatórios:
  - Produtos com menor estoque
  - Pedido mais caro
  - Relatório geral
- Interface CLI estruturada em menus interativos

## 📁 Estrutura do Projeto

- `src/` – Código-fonte Java
  - `controllers/` – Lógica de controle
  - `models/` – Entidades e lógica de dados
  - `views/` – Menus e interface com o usuário
  - `application/` – Aplicações e relatórios
- `data/` – Arquivo de dados persistente
- `pdf/` – Arquivo com a especificação do trabalho
- `ToDo.txt` – Lista de tarefas a implementar
- `README.md` – Este arquivo

## ✅ Requisitos

- JDK 23+
- Terminal bash ou compatível (para uso do comando `find`)

## 🙌 Contribuições

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests.

## 📄 Licença

Este projeto é de uso acadêmico e não possui licença específica.
