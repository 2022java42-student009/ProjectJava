<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>exhibitedit</title>
</head>
<body>
出品情報編集画面
<form action="" method="post">
ISBN番号<input type="text" name="number"><br>
値段<input type="text" name="price"><br>
<%--状態もプルダウンの方がいいのか（新品、未使用、使用済み等）--%>
状態<input type="text" name="condition"><br>
備考<input type="text" name="remarks"><br>
<input type="submit" value="確認">
<button onclick="location.href=''">戻る</button>
</form>
</body>
</html>