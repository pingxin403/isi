<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>出差信息</title>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/font-awesome/5.8.2/css/fontawesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/main.css">

    <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/layer/2.3/layer.js"></script>
    <script src="http://cdn.highcharts.com.cn/highcharts/highcharts.js"></script>
    <script src="https://cdn.bootcss.com/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <script src="js/main.js" type="text/javascript"></script>

</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

    <div>
        <a class="navbar-brand" style="font-size: 32px;" href="main">信息集成系统</a>
    </div>

</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <ul stylle="padding-left: 0px;" class="list-group">
                    <li class="list-group-item tree-closed"><a href="hydropower"><i
                            class="glyphicon glyphicon-dashboard"></i> 用水用电量</a></li>
                    <li class="list-group-item tree-closed"><a
                            href="environmental"><i
                            class="glyphicon glyphicon glyphicon-tasks"></i> 环境参数</a></li>
                    <li class="list-group-item tree-closed"><a href="evection"><i
                            class="glyphicon glyphicon-ok"></i> 出差信息</a></li>
                    <li class="list-group-item tree-closed"><a href="terminal"><i
                            class="glyphicon glyphicon-th-large"></i> 环境终端</a></li>
                    <li class="list-group-item tree-closed"><a href="time"><i
                            class="glyphicon glyphicon-lock"></i> 设置</a></li>
                </ul>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header" style="text-align: center">出差信息</h1>
            <div></div>

            <div id="container_destination"
                 style="width: 550px; height: 400px; margin: 0 auto"></div>
            <div id="container_staff"
                 style="width: 550px; height: 400px; margin: 0 auto"></div>
            <div id="container_weather"
                 style="width: 550px; height: 400px; margin: 0 auto"></div>

        </div>
    </div>
</div>

<script type="text/javascript">

    $(function () {
        $.ajax({
            type: "post",
            url: "http://localhost:8090/count/destination",
            async: true,
            success: function (d, textStatus) {

                var count = eval('(' + d + ')').data[0].count ? 5 : (eval('(' + d + ')').data[0].count);
                $.ajax({
                    type: "post",
                    url: "http://localhost:8090/travel/destination?from=0&to=" + count,
                    async: true,
                    success: function (da, textStatus) {
                        getdestination(eval('(' + da + ')').data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("error");
                    }

                });

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("error");
            }

        });


        $.ajax({
            type: "post",
            url: "http://localhost:8090/count/staff",
            async: true,
            success: function (d, textStatus) {

                var count = eval('(' + d + ')').data[0].count ? 5 : (eval('(' + d + ')').data[0].count);
                $.ajax({
                    type: "post",
                    url: "http://localhost:8090/travel/staff?from=0&to=" + count,
                    async: true,
                    success: function (da, textStatus) {
                        getstaff(eval('(' + da + ')').data);
                    },
                    error: function (XMLHttpRequest, textStatus, errorThrown) {
                        alert("error");
                    }

                });

            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("error");
            }

        });


        $.ajax({
            type: "post",
            url: "http://localhost:8090/travel/weather",
            async: true,
            success: function (d, textStatus) {
                getweather(eval('(' + d + ')').data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                alert("error");
            }

        });

    });


</script>
</body>
</html>

