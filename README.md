# 🚀 Event Driven Microservices with Java & AWS

Projeto desenvolvido com o objetivo de simular desafios próximos de um ambiente real utilizando uma arquitetura de microsserviços orientada a eventos.

A aplicação foi construída utilizando Java, Spring Boot e serviços da AWS para promover desacoplamento entre os serviços e comunicação assíncrona.

---

## 🎯 Objetivo do projeto

O objetivo deste projeto foi ir além de um CRUD tradicional e construir uma solução distribuída, escalável e desacoplada, aplicando conceitos utilizados em ambientes corporativos.

Durante o desenvolvimento, foram implementados desafios reais como:

- Comunicação assíncrona entre microsserviços
- Mensageria utilizando AWS SNS e AWS SQS
- Containerização com Docker
- Orquestração com Docker Compose
- Deploy em uma instância EC2
- Persistência de dados com PostgreSQL
- Gerenciamento de infraestrutura Linux

---

# 🏗️ Arquitetura

A arquitetura é composta por 3 microsserviços independentes:

### 📦 Order Service

Responsável por:

- Receber a requisição de criação de pedidos
- Persistir os dados do pedido
- Publicar eventos para a mensageria

### 💳 Payment Service

Responsável por:

- Consumir os eventos recebidos
- Processar os pagamentos
- Publicar novos eventos após a conclusão do pagamento

### 📧 Notification Service

Responsável por:

- Consumir eventos do sistema
- Simular o envio de notificações ao cliente

---

# 🔄 Fluxo da aplicação

```text
Cliente

↓

Order Service

↓

AWS SNS (order-created-topic)

↓

AWS SQS (payment-queue)

↓

Payment Service

↓

AWS SNS (payment-approved-topic)

↓

AWS SQS (notification-queue)

↓

Notification Service


🛠️ Tecnologias utilizadas
Backend
Java 21
Spring Boot
Spring Data JPA
Maven
Banco de dados
PostgreSQL
Cloud
AWS EC2
AWS SNS
AWS SQS
Infraestrutura
Docker
Docker Compose
Ubuntu Linux
DevOps
GitHub
GitHub Actions
Docker Hub
📂 Estrutura do projeto
microservices-project/

├── order-service
│
├── payment-service
│
├── notification-service
│
├── docker-compose.yml
│
└── README.md
🧠 Conceitos aplicados
Microsserviços
Event Driven Architecture
Comunicação assíncrona
Desacoplamento entre serviços
Containerização
Persistência de dados
DTO Pattern
Mapper Pattern
Exception Handling
Boas práticas REST
Deploy em nuvem
Integração entre múltiplos serviços
🚀 Executando localmente
Pré-requisitos
Docker
Docker Compose
Java 21
Conta AWS configurada
PostgreSQL
Clonar o projeto
git clone https://github.com/seuusuario/seu-repositorio.git

cd seu-repositorio
Subir os containers
docker compose up -d
Verificar containers
docker ps
🌐 Endpoints
Criar pedido
POST /orders

Exemplo:

{
  "name": "Notebook",
  "customerEmail": "cliente@email.com",
  "totalAmount": 3700,
  "method": "BOLETO"
}
💡 Desafios enfrentados

Durante o desenvolvimento alguns desafios foram essenciais para meu aprendizado:

Migrar uma comunicação síncrona para uma arquitetura orientada a eventos.
Configurar corretamente SNS e SQS.
Containerizar múltiplos microsserviços.
Configurar e executar toda a infraestrutura dentro de uma instância EC2.
Gerenciar recursos da máquina virtual devido ao consumo de memória dos containers.
Organizar a comunicação entre diversos componentes desacoplados.
📚 Principais aprendizados

Este projeto me permitiu aprofundar conhecimentos em:

Arquitetura de microsserviços
Mensageria na AWS
Event Driven Architecture
Deploy em Cloud
Dockerização de aplicações Java
Infraestrutura Linux
Integração entre múltiplos serviços

👨‍💻 Autor

Erick Luan

Backend Developer | Java | Spring Boot | AWS | Docker | PostgreSQL | Microservices