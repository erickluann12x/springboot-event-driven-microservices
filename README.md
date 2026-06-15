# Spring Boot Event Driven Microservices

Projeto desenvolvido para aprofundar conhecimentos em arquitetura de microserviços, comunicação assíncrona e serviços AWS, simulando um fluxo real de processamento de pedidos.

## Arquitetura do Projeto

A aplicação é composta por três microserviços independentes:

* Order Service
* Payment Service
* Notification Service

A comunicação entre eles é realizada de forma assíncrona utilizando AWS SNS e AWS SQS.

## Fluxo da aplicação

```text
Cliente

↓

Order Service

↓

AWS SNS (Order Created)

↓

AWS SQS

↓

Payment Service

↓

AWS SNS (Payment Approved)

↓

AWS SQS

↓

Notification Service
```

## Microserviços

### Order Service

Responsável por:

* Criar pedidos
* Persistir dados no PostgreSQL
* Publicar eventos de criação de pedidos no SNS

### Payment Service

Responsável por:

* Consumir eventos enviados pelo Order Service
* Criar pagamentos automaticamente
* Persistir dados no PostgreSQL
* Publicar eventos de pagamento aprovado

### Notification Service

Responsável por:

* Consumir eventos de pagamento aprovado
* Simular envio de notificações ao cliente

---

## Tecnologias utilizadas

### Backend

* Java 21
* Spring Boot 3
* Spring Data JPA
* Maven

### Banco de dados

* PostgreSQL

### Mensageria

* AWS SNS
* AWS SQS

### Infraestrutura

* Docker
* Docker Compose

### Ferramentas

* Insomnia
* Git
* GitHub

---

## Estrutura do projeto

```text
springboot-event-driven-microservices

├── order-service

├── payment-service

├── notification-service

├── docker-compose.yml

├── .env.example

├── .gitignore

└── README.md
```

---

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone <url-do-repositorio>
```

```bash
cd springboot-event-driven-microservices
```

---

### 2. Configurar as variáveis de ambiente

Criar um arquivo `.env` na raiz do projeto.

Exemplo:

```env
AWS_ACCESS_KEY_ID=

AWS_SECRET_ACCESS_KEY=

AWS_REGION=

AWS_ORDER_TOPIC=

AWS_PAYMENT_TOPIC=

AWS_ORDER_QUEUE=

AWS_PAYMENT_QUEUE=

ORDER_DB_USER=

ORDER_DB_PASSWORD=

PAYMENT_DB_USER=

PAYMENT_DB_PASSWORD=
```

---

### 3. Executar os containers

```bash
docker compose up --build
```

---

## Endpoints principais

### Criar pedido

```http
POST /orders
```

### Buscar pedidos

```http
GET /orders
```

### Buscar pagamentos

```http
GET /payments
```

---

## Conceitos aplicados

* Arquitetura de Microserviços
* Event Driven Architecture (EDA)
* Comunicação assíncrona
* Desacoplamento entre serviços
* Persistência isolada por serviço
* Containerização
* Integração com serviços AWS

---

## Próximas melhorias

* [ ] Deploy na AWS EC2
* [ ] API Gateway
* [ ] Observabilidade com Prometheus e Grafana
* [ ] CI/CD com GitHub Actions
* [ ] Logs centralizados

---

## Autor

Desenvolvido por Erick Luan.
