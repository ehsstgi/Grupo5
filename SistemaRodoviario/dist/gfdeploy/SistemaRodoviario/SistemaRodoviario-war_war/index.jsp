<%-- 
    Document   : index
    Created on : 14/04/2012, 21:36:17
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
                        </div>
                    </th>
                    <th width="274" scope="col">
                        <p>Acesso ao cadastro</p>
                        <form action="./ClientServlet" method="post" action="">

                            <p>Login:
                                <input type="text" name="nome" id="textfield" />
                            </p>
                            <p>Senha:
                                <input type="password" name="senha" id="textfield2" />
                            </p>
                            <input type="submit" name="cadastra" value="Entrar" >
                        </form>
                </tr>
            </table>

            <table width="1000" height="200" border="0">
                <tr >
                    <th width="210" scope="col">
                        MENU<br>

                        <a href="cadastro.jsp">Cadastrar</a><br>
                        <a href="cadastro.jsp">Teste</a>
                    </th>
                    <th width="729" scope="col"><div align="left">
                            <p>

                                <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_0" />
                                Ida e Volta
                                <br />

                                <input type="radio" name="RadioGroup1" value="radio" id="RadioGroup1_1" />
                                Ida
                                <br />
                            </p>
                        </div>
                        <p align="left">
                            Origem:
                            <select name="jumpMenu" id="jumpMenu" onchange="MM_jumpMenu('parent',this,0)">
                                <option>Sao Paulo</option>
                                <option>Ribeirão Preto</option>
                                <option>Araçatuba</option>
                                <option>Campinas</option>
                                <option>Santos</option>
                                <option>Sorocaba</option>
                                <option>Atibaia</option>
                            </select>
                        </p>
                        <p align="left">Destino:
                            <select name="jumpMenu2" id="jumpMenu2" onchange="MM_jumpMenu('parent',this,0)">
                                <option>Sao Paulo</option>
                                <option>Ribeirão Preto</option>
                                <option>Araçatuba</option>
                                <option>Campinas</option>
                                <option>Santos</option>
                                <option>Sorocaba</option>
                                <option>Atibaia</option>
                            </select>
                        </p>
                        <p align="left">Data Ida:
                            <input name="textfield" type="text" id="textfield" maxlength="10" />
                        </p>
                        <p align="left">Data Volta:
                            <input type="text" name="textfield2" id="textfield2" />
                        </p>


                        <p align="left"
                    <form id="form1" name="form1" method="post" action="">
                        <input type="submit" name="button" id="button" value="Buscar" />
                    </form>
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
