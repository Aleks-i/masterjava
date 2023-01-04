<jsp:useBean id="user" scope="request" type="ru.javaops.masterjava.xml.schema.User"/>
<jsp:useBean id="users" scope="request" type="java.util.Set"/>
<!doctype html>
<html lang="">
<head>
    <meta charset="UTF-8"/>
    <title>User List</title>
    <link th:href="@{/resources/css/table.css}" rel="stylesheet" />
</head>
<body>

<h1>User list</h1>

<table>
    <thead>
    <tr>
        <th>NAME</th>
        <th>EMAIL</th>
        <th>FLAG</th>
    </tr>
    </thead>
    <tbody th:remove="all-but-first">
    <tr th:each="user : ${users}">
        <td th:text="${user.value}"></td>
        <td th:text="${user.email}"></td>
        <td th:text="${user.flag}"></td>
    </tr>
</table>
</body>
</html>