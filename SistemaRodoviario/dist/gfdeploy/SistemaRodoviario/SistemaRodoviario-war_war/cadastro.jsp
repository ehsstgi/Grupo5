<%--
    Document   : index
    Created on : 18/04/2012, 16:36:17
    Author     : Luiza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body> <div align="center">
            <table width="1000" height="115" border="1" bgcolor="#f5f5f5" >
                <tr>
                    <th width="668" height="109" scope="col">
                        <div align="left">

                            <img src=mack.jpg width="225" height="225" />
                            <h1><center>BEM VINDO!</h1></center>
                        </div>
                    </th>
                    <th width="274" scope="col">
                        <p>Acesso ao cadastro</p>

                        <p>Login:
                            <input type="text" name="textfield" id="textfield" />
                        </p>
                        <p>Senha:
                            <input type="text" name="textfield2" id="textfield2" />
                        </p>
                        <form action="cadastro.jsp">
                            <input type="submit" value="Entrar" >
                        </form>
                </tr>
            </table>

            <table width="1000" height="600" border="0">
                <tr >
                    <th width="210" scope="col">
                        MENU<br>

                        <a href="cadastro.jsp">Teste</a>
                    </th>
                    <th width="729" scope="col">
                        <div align="left">
                            <p>Nome:
                                <input type="text" name="textfield" id="textfield" />
                            </p>
                            <p>
                                CPF/CNPJ:
                                <input type="text" name="textfield2" id="textfield2" />
                            </p>
                            <p>Endereço:
                                <input type="text" name="textfield3" id="textfield3" />
                            </p>
                            <p>CEP:
                                <input type="text" name="textfield4" id="textfield4" />
                            </p>
                            <p>Complemento:
                                <input type="text" name="textfield5" id="textfield5" />
                            </p>
                            <p>Bairro:
                                <input type="text" name="textfield6" id="textfield6" />
                            </p>
                            <p>Telefone Res:
                                <input type="text" name="textfield7" id="textfield7" />
                            </p>
                            <p>Telefone Celular:
                                <input type="text" name="textfield8" id="textfield8" />
                            </p>
                        </div>
                    </th>
                </tr>
                <tr>
                    <th scope="row" height="100"></th>
                    <td></td>
                </tr>
            </table>


            <table width="1000" height="87" border="1" bgcolor="#f5f5f5">
                <tr>
                    <th scope="col"> <font size=3>Contrato de Transporte Rodoviario - Trabalhe Conosco - Vendas Corporativas - Investidores - Sala de Imprensa
                            Privacidade e Segurança - Dicas de Segurança MackTrans Fidelidade

                            © 2012 MackTrans Rodoviario S.A. Proibida reprodução total ou parcial sem autorização

                        </font>
                    </th>
                </tr>
            </table>
        </div>
    </body>
</html>
