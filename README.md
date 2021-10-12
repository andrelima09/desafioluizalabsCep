<h1>Api Endereço</h1>
<h5>Está API tem a finalidade de retornar o endereço (rua, bairro, cidade e estado) ao usuário de acordo com o CEP informado.</h5>


<h1>Tecnologia</h1>
<ul>
<li>Java 11</li>
<li>Spring Boot 2.5.5</li>
<li>Mongodb</li>
<li>Docker</li>
<li>Maven</li>
<li>Mongodb Compass</li>
</ul>


<h1>Tarefas</h1>
<ul>
<li>Deve retornar o endereço caso o CEP informado seja válido</li>
<li>Ao informar um CEP válido que não exista na base, será substituídos os números por zero, da direta para a esquerda, até que retorne um endereço ou todos os números tenham sido substituídos.</li>
<li>Ao informar um CEP inválido, deve retornar uma mensagem de erro para o usuário (CEP inválido).</li>
</ul>

<h1>Instruções</h1>
<ul>
<li><b>Mongodb</b></li>
 <p>
 - Deve ser configurado o mongodb no ambiente da aplicação. 
 <br>- Para configurá-lo no docker com as credenciais utilizadas no arquivo application.properties da aplicação utilize o seguinte comando via terminal: <b>"docker run --name mongodb -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=luizalabs -e MONGO_INITDB_ROOT_PASSWORD=luizalabs mongo"</b>
 <br>- Utilizando as credencias (usuário:luizalabs, senha:luizalabs) no Mongodb Compass, crie um banco de dados com o nome <b>"desafio"</b> e dentro dele uma collection com o nome <b>"endereco"</b>.
 <br>- Na collection criada, importe o arquivo <b>"endereco_cep.json"</b> que se encontra no diretório <b>"doc"</b> dentro da raiz do projeto para ter massa de dados para fazer os testes.
 <br>- Foi inserido um index de valor único no campo "cep" para que n seja cadastrado CEP duplicado. Se for inserir novos dados, recomenda-se que crie o mesmo index.
 </p>
 <li><b>Api</b></li>
 <p>
 - Certifique-se que o Java instalado no ambiente seja a versão 11 ou >.
 </br> - Certifique-se que tenha o maven instalado no ambiente.
 </br> - Faça o clone do projeto e, ainda com o banco de dados rodando, execute o seguinte comando na raiz do projeto via terminal: <b>"mvn spring-boot:run"</b>
 </p>
 <li><b>Testando a aplicação</b></li>
 <p>
 - Para testar a aplicação o serviço pode ser chamado pelo navegador ou por um cliente rest. Nos casos de teste de desenvolvimento foi usado o "Chrome" e o "Advanced Rest Cliente".
 <br>- Siga o exemplo de requisição local para chamar o serviço: <b>"http://localhost:8080/desafioEnderecoCep/endereco/37502256"</b> onde <b>"37502256"</b> é o número do CEP a ser consultado.
 <br>- Também é possível ter informações de requisição através do swagger: <b>"http://localhost:8080/desafioEnderecoCep/swagger-ui.html"</b>
 <br>- Exemplo de retorno:
 <br>
 <blockquote>
 <br>{
<br>   "status": "OK",
<br>   "endereco": {
<br>   "codigo": "6165ee2d105d7c348b8e4622",
<br>   "cep": "12605590",
<br>   "rua": "Rodovia Osvaldo Junqueira Ortiz Monteiro",
<br>   "bairro": "Parque das Rodovias",
<br>   "cidade": "Lorena",
<br>   "estado": "São Paulo"
<br>   },
<br>   "erro": null
<br>}
</blockquote>
</p>
</ul>
<h1>Considerações</h1>
<p>
O desenvolvimento foi focado em cumprir todos os requisitos de negócio solicitado. Foi feito mapeamento da model para conexão com o mongodb rodando em docker.
<br> Código desenvolvido de maneira limpa e organizada onde as classes foram separadas nos pacotes de acordo com suas funções.
<br> Feito testes unitários com JUnit 5 das classes de controle e de serviço.
</p>


