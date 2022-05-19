<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bookmanagement</title>
</head>
<body>
	<h1>教科書更新画面</h1>
	<form action="" method="post">
		ISBN
		<input type="number" name="number">
		<br> 分類
			<select name="example">
				<option value="選択肢1">選択肢1</option>
				<option value="選択肢2">選択肢2</option>
				<option value="選択肢3">選択肢3</option>
			</select>
			<br>タイトル
		<input type="text" name="title">
			<br> 著者名
			<input type="text" name="author">
			<br> 金額
			<input type="number" name="price">
			<br> 備考
			<input type="text" name="remarks">
			<br>
			<button onclick="location.href=''">削除</button>
			<input type="submit" value="確認">
			<button onclick="location.href=''">キャンセル</button>
	</form>
</body>
</html>