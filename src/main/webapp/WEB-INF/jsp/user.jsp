<%--
  Created by IntelliJ IDEA.
  User: zhengxin
  Date: 2019/4/24
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>SpringWeb</title>
</head>
<body>
    <h1>example1</h1>
    <li>id:${empty id ? user.id : id}</li>
    <li>name:${empty name ? user.name : name}</li>
    <li>age:${empty age ? user.age : age}</li>
    <hr/>

    <h1>example2</h1>
    <li>id:${empty id ? user.id : id}</li>
    <li>name:${empty name ? user.name : name}</li>
    <li>age:${empty age ? user.age : age}</li>
    <hr/>

    <h1>example3</h1>
    <li>id:${empty id ? user.id : id}</li>
    <li>name:${empty name ? user.name : name}</li>
    <li>age:${empty age ? user.age : age}</li>
    <hr/>

    <h1>example4</h1>
    <li>id:${empty id ? user.id : id}</li>
    <li>name:${empty name ? user.name : name}</li>
    <li>age:${empty age ? user.age : age}</li>
    <hr/>

    <h1>example5</h1>
    <li>pathName:${empty pathName ? pathName : pathName}</li>
    <hr/>

    <h1>example6</h1>
    <li>pathName:${empty pathName ? pathName : pathName}</li>
    <li>pathName2:${empty pathName2 ? pathName2 : pathName2}</li>
    <hr/>

    <h1>example7</h1>
    <li>pathName:${empty pathName ? pathName : pathName}</li>
    <li>q:${empty q ? q : q}</li>
    <li>r:${empty r ? r : r}</li>
    <hr/>

    <h1>example8</h1>
    <li>q1:${empty q1 ? q1 : q1}</li>
    <li>q2:${empty q2 ? q2 : q2}</li>
    <hr/>

    <h1>example9</h1>
    <li>q:${empty q ? q : q}</li>
    <hr/>
</body>
</html>
