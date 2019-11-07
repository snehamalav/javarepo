<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="menu.html"></jsp:include>
<form action="ProductRegister" name = "prodform" method = "post">
            <center>
                <table>
                        <tr>
                                <th>pid</th>
                                <td><input type = 'text' name = 'pid' id ='pid'></td>
                            </tr>
                    <tr>
                        <th>product name:</th>
                        <td><input type = 'text' name = 'pname' id ='pname'></td>
                    </tr>

                    <tr>
                            <th>unit price</th>
                            <td><input type = 'text' name = 'unitprice' id ='unitprice' size='10' ></td>
                    </tr>
                    
                     <tr>
                        <th>stock</th>
                        <td><input type = 'text' name = 'stock' id ='stock'></td>
                    </tr>
                    

                    <tr>
                            <th>category:</th>
                            <td><select name='category' id="category">
                                <option value='electronics'>electronics</option>
                                <option value='fashion'>fashion</option>
                               
                           
                            </select></td>
                            
                    </tr>

                    <tr>
                            <th colspan="2">
                            
                            &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
                            <input type = 'submit' value ='productregister' >
                            </th>
                    </tr>
                </table>
            </center>
        

        </form>
</body>
</html>