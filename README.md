
![image](https://th.bing.com/th/id/OIP.lwDa90HV9bdav2987iyL6QHaHa?w=200&h=200&rs=1&pid=ImgDetMain)

# Encurtador de URL utilizando Java

#### Fluxo:
* O usuário faz uma requisição POST para o endpoint /shorten-url.
* O controlador do endpoint chama a função shortenURL do UrlService.
* A função começa a codificar essa URL para uma sequência de 8 caracteres:
    * Primeiro, um código hash é criado utilizando o algoritmo SHA-256.
    * O código hash gerado é então mapeado para a base 62.
    * Por fim, são selecionados os 8 primeiros dígitos desse código.
* O serviço salva a URL encurtada e a URL original em um banco de dados, mapeados como um  HashMap, onde a URL encurtada é a chave primária.
* Neste projeto, utilizei o banco de dados H2 em memória apenas para testes.
* Logo após, a URL encurtada é retornada no corpo da resposta da requisição.
* Ao fazer uma requisição GET para a URL gerada, por exemplo: localhost:8080/xxxxxxxx, o serviço busca no banco de dados a URL que possui esse código xxxxxxxx como chave primária.
* Ao ser encontrada, o endpoint faz uma verificação para saber se há ou não um protocolo estabelecido na URL original. Caso não haja, o sistema assume o protocolo mais provável e, então, faz o redirecionamento para a URL ligada ao código encurtado.


---


Algumas melhorias ainda podem ser feitas, como validação da URL a ser encurtada, um método para evitar colisões (2 URLs gerando o mesmo código), Exceptions mais específicas, um GlobalExceptionHandler mais robusto, etc. 

Foi um projeto bem simples e prático, apenas para mostrar reforçar o conhecimento e aprender um sistema novo.


No mais, é isso <3

    -Maven
    -Java 23
    -Spring Boot 3.4.1
    -H2
    -Spring Web
    -Spring JPA
    -Lombok




