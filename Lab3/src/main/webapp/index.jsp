<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Анкета</title>
</head>
<body>
<h1>Форма для сбора данных о студентах</h1>
<form action="StudentServlet" method="post">
    <label for="name">Имя:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="age">Возраст:</label>
    <input type="number" id="age" name="age" required><br><br>

    <label for="group">Группа:</label>
    <input type="text" id="group" name="group" required><br><br>

    <label for="telephone_number">Номер телефона:</label>
    <input type="text" id="telephone_number" name="telephone_number" required><br><br>

    <label for="email">Email:</label>
    <input type="text" id="email" name="email" required><br><br>

    <input type="submit" value="Добавить">
</form>

<h2>Просмотреть данные студентов</h2>
<form action="StudentServlet" method="get">
    <input type="submit" value="Просмотреть">
</form>
</body>
</html>