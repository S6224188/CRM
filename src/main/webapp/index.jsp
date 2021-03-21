<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<script src="lib/jquery-1.8.3.min.js"></script>
<script>
    $(function () {
        $("#btn").click(function () {
            $.ajax({
                url: "one",
                data: {

                },
                //dataType：期望从服务器响应的数据类型
                dataType: "json",
                success: function (resp) {
                    alert(resp.name)
                }
            })
        })
    })

</script>
<input type="button" id="btn">
<a href="insert">增</a>
<a href="delete">删</a>
<a href="update">改</a>
<a href="select">查</a>
</body>
</html>
