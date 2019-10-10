# AcademiaGinastica
# Sistema Academia de Ginástica 
### TCC Engenharia de Software - PÓS PUCMINAS

### Sobre:
O propósito geral do sistema é gerenciar as atividades de uma academia de ginástica.


 O sistema deve permitir o cadastro de clientes. São informações de cada cliente que precisam ser registradas: nome, identidade, CPF, endereço. Tal funcionalidade é realizada pelo Recepcionista.
 O sistema deve permitir o cadastro de instrutores. Para cada instrutor, devem ser informados: nome, CPF, identidade, tipos de atividades (aulas em grupo ou musculação) que o professor está autorizado a lecionar. Tal funcionalidade é realizado pelo Recepcionista.
 O sistema deve permitir o cadastro de aulas em grupo. Para cada aula em grupo, devem ser informados: o nome da aula, o horário de início e fim, o nome do instrutor alocado, os dias de semana em que a aula ocorre e a sala onde a aula acontece. Tal funcionalidade é realizada pelo Recepcionista. As salas não precisam ser cadastradas pelo sistema.
 O sistema deve permitir o registro de informações de pagamento dos clientes. A academia trabalha com dois planos: mensal ou anual. O sistema deve registrar a data de pagamento realizado e informar a data do próximo pagamento de acordo com o plano do cliente. Tal funcionalidade é realizada pelo Recepcionista;
 O sistema deve poder informar se o cliente está adimplente ou inadimplente (se não houve pagamento na data prevista de acordo com seu plano);
 Para os planos anuais, o cliente tem o direito de tirar 30 dias corridos de férias. Neste caso, podem ser registrados até 3 períodos de férias não consecutivos desde que a soma total dos dias seja inferior ou igual a 30 dias. Ao se registrar um período de férias de X dias, o sistema deve deslocar a data prevista para o próximo pagamento em X dias. Tal ação pode ser realizada pelo Recepcionista.
 O sistema deve permitir o registro de uma avaliação física pelo fisioterapeuta. A avaliação física deve ter informações sobre anamnese do paciente, exame de dobras cutâneas e exame ergométrico.
 O sistema deve poder ser acessível por meio de um dispositivo touchscreen em cada sala de aula (musculação ou aula coletiva) pelos alunos. Cada aluno deverá poder ter acesso a:
o Registrar presença em uma aula. As presenças devem ser registradas por meio de identificação biométrica. O sistema deve reconhecer a digital do aluno em até 3 segundos. Caso esta falhe, o aluno pode informar seu número de matrícula e marcar a presença na aula (só podem ser escolhidas aulas realizadas no mesmo dia);
o Visualizar seu histórico de presenças (somente permitido por meio de identificação biométrica);
o O sistema deve exibir ao aluno a informação de que ele deve realizar avaliação física caso a última avaliação tenha sido realizada há mais de 6 meses;
 O Gerente deve ter acesso aos seguintes relatórios:
o Relatório que exibe os dados dos alunos matriculados (deve poder ser
ordenado alfabeticamente ou por data prevista para o próximo
pagamento);
o Relatório que exibe os dados dos alunos inadimplentes (informando a
data prevista para o pagamento);

### Tecnologias:
Plataforma Java EE.

- JavaSE 1.8
- Eclipse
- Tomcat 8.0
- Maven 3.3
- JSF 2.2.14
- Primefaces 6.1
- primefaces themes bootstrap 1.0.10
- omnifaces 2.1
- JPA 2.0 com Hibernate 4.2.3.Final
- CDI com Weld 2.4.1.Final
- Drive JDBC MySQL 5.1.38 (usei esse banco, mas pode subir em outro por utilizar JPA)
- Logging slf4j 1.7.12
- Logging log4j 1.2.17
- Commons Fileupload 1.3.1
- Commons Lang (utilidades) 3.4
- hibernate validator 5.3.3.Final
- jasperreports 6.1.1
- jasperreports fonts 6.0.0
- JUnit 4.11

### @author:
Andrei Toledo andreiltoledo@hotmail.com
Analista e Desenvolvedor de Sistemas
