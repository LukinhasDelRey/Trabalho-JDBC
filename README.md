### Equipe:

- Camile Lourival Ferreira Santos
- Lucas Nascimento
- Angelo Peluso
- Gilmar Gabriel de Moura Carvalho
- Matheus Nascimento Angelo De Souza
- Ícaro Matos Silva

### Histórias de Usuário

#### História de Usuário 1: Cadastrar Usuário

**Como** um administrador,  
**Eu quero** cadastrar um novo usuário,  
**Para que** ele possa acessar o sistema e realizar solicitações.

**Critérios de Aceitação:**
- O sistema deve permitir a entrada do nome e tipo de usuário (Solicitante/Gestor).
- O sistema deve salvar o novo usuário no banco de dados.
- O sistema deve exibir uma mensagem de sucesso ou erro após a tentativa de cadastro.

#### História de Usuário 2: Listar Usuários

**Como** um administrador,  
**Eu quero** listar todos os usuários cadastrados,  
**Para que** eu possa visualizar quem está registrado no sistema.

**Critérios de Aceitação:**
- O sistema deve exibir uma lista de todos os usuários com seus respectivos IDs, nomes e tipos.
- O sistema deve exibir uma mensagem de erro se não conseguir recuperar a lista de usuários.

#### História de Usuário 3: Cadastrar Espaço

**Como** um administrador,  
**Eu quero** cadastrar um novo espaço,  
**Para que** ele possa ser reservado pelos usuários.

**Critérios de Aceitação:**
- O sistema deve permitir a entrada do nome, descrição, capacidade e equipamentos disponíveis do espaço.
- O sistema deve salvar o novo espaço no banco de dados.
- O sistema deve exibir uma mensagem de sucesso ou erro após a tentativa de cadastro.

#### História de Usuário 4: Listar Espaços

**Como** um administrador,  
**Eu quero** listar todos os espaços cadastrados,  
**Para que** eu possa visualizar quais espaços estão disponíveis para reserva.

**Critérios de Aceitação:**
- O sistema deve exibir uma lista de todos os espaços com seus respectivos IDs, nomes e capacidades.
- O sistema deve exibir uma mensagem de erro se não conseguir recuperar a lista de espaços.

#### História de Usuário 5: Criar Solicitação

**Como** um usuário,  
**Eu quero** criar uma solicitação de reserva de espaço,  
**Para que** eu possa reservar um espaço para uso futuro.

**Critérios de Aceitação:**
- O sistema deve permitir a entrada do ID do solicitante, ID do espaço e data da reserva.
- O sistema deve salvar a nova solicitação no banco de dados com status "Pendente".
- O sistema deve exibir uma mensagem de sucesso ou erro após a tentativa de criação da solicitação.

#### História de Usuário 6: Listar Solicitações Pendentes

**Como** um administrador,  
**Eu quero** listar todas as solicitações pendentes,  
**Para que** eu possa avaliar e aprovar ou rejeitar as solicitações.

**Critérios de Aceitação:**
- O sistema deve exibir uma lista de todas as solicitações pendentes com seus respectivos IDs, IDs de usuário, IDs de espaço, datas de reserva e status.
- O sistema deve exibir uma mensagem de erro se não conseguir recuperar a lista de solicitações pendentes.

#### História de Usuário 7: Avaliar Solicitação

**Como** um administrador,  
**Eu quero** avaliar uma solicitação pendente,  
**Para que** eu possa aprovar ou rejeitar a solicitação.

**Critérios de Aceitação:**
- O sistema deve permitir a entrada do ID da solicitação, status (Aprovado/Rejeitado) e justificativa.
- O sistema deve atualizar o status da solicitação no banco de dados.
- O sistema deve exibir uma mensagem de sucesso ou erro após a tentativa de avaliação da solicitação.
