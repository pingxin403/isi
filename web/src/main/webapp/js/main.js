function water(data) {
    var chart = {
        type: 'bar'
    };
    var title = {
        text: '晴天、阴天、雨天的日平均用水量'
    };
    var categories = [];
    for (var i = 0; i < data.length; i++) {

        categories.push(data[i].weather);
    }

    var xAxis = {
        categories: categories,
        crosshair: true
    };
    var yAxis = {
        min: 150,
        title: {
            text: 'Water consumption (ton)'
        }
    };
    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
            + '<td style="padding:0"><b>{point.y:.2f} 吨</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        },
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var we = {};
    we.name = '用水量';
    we.data = [];
    for (i = 0; i < data.length; i++) {
        we.data.push(data[i].water);
    }
    series.push(we);


    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_water').highcharts(json);
}

function electric(data) {
    var chart = {
        type: 'bar'
    };
    var title = {
        text: '晴天、阴天、雨天的日平均用电量'
    };

    var categories = [];
    for (var i = 0; i < data.length; i++) {

        categories.push(data[i].weather);
    }

    var xAxis = {
        categories: categories,
        crosshair: true
    };
    var yAxis = {
        min: 350,
        title: {
            text: 'Electricity consumption (kw·h)'
        }
    };
    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
            + '<td style="padding:0"><b>{point.y:.2f} kw·h</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        },
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    };

    var credits = {
        enabled: false
    };


    var series = [];
    var we = {};
    we.name = '用电量';
    we.data = [];
    for (i = 0; i < data.length; i++) {
        we.data.push(data[i].electricity);
    }
    series.push(we);


    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_electric').highcharts(json);
}

function CO2(data) {
    var chart = {
        type: 'bar'
    };
    var title = {
        text: '晴天、阴天、雨天的平均CO2含量'
    };
    var categories = [];
    for (var i = 0; i < data.length; i++) {

        categories.push(data[i].weather);
    }

    var xAxis = {
        categories: categories,
        crosshair: true
    };
    var yAxis = {
        min: 200,
        title: {
            text: ' Average CO2 content  (ppm)'
        }
    };
    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
            + '<td style="padding:0"><b>{point.y:.2f} ppm</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        },
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var we = {};
    we.name = '二氧化碳含量';
    we.data = [];
    for (i = 0; i < data.length; i++) {
        we.data.push(data[i].co2);
    }
    series.push(we);


    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_CO2').highcharts(json);
}

function VOC(data) {
    var chart = {
        type: 'bar'
    };
    var title = {
        text: '晴天、阴天、雨天的平均VOC含量'
    };
    var categories = [];
    for (var i = 0; i < data.length; i++) {

        categories.push(data[i].weather);
    }

    var xAxis = {
        categories: categories,
        crosshair: true
    };
    var yAxis = {
        min: 100,
        title: {
            text: ' Average VOC content  (ppm)'
        }
    };
    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
            + '<td style="padding:0"><b>{point.y:.2f} ppm</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        },
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var we = {};
    we.name = 'VOC含量';
    we.data = [];
    for (i = 0; i < data.length; i++) {
        we.data.push(data[i].voc);
    }
    series.push(we);


    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_VOC').highcharts(json);
}

function PM25(data) {
    var chart = {
        type: 'bar'
    };
    var title = {
        text: '晴天、阴天、雨天的平均PM 2.5 含量'
    };
    var categories = [];
    for (var i = 0; i < data.length; i++) {

        categories.push(data[i].weather);
    }

    var xAxis = {
        categories: categories,
        crosshair: true
    };
    var yAxis = {
        min: 0,
        title: {
            text: ' Average PM 2.5 content  (ug/m^3)'
        }
    };
    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
            + '<td style="padding:0"><b>{point.y:.2f} ug/m^3</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        },
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var we = {};
    we.name = 'PM 2.5 含量';
    we.data = [];
    for (i = 0; i < data.length; i++) {
        we.data.push(data[i].pm25);
    }
    series.push(we);


    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_PM25').highcharts(json);
}


function PM10(data) {
    var chart = {
        type: 'bar'
    };
    var title = {
        text: '晴天、阴天、雨天的平均PM 10 含量'
    };
    var categories = [];
    for (var i = 0; i < data.length; i++) {

        categories.push(data[i].weather);
    }

    var xAxis = {
        categories: categories,
        crosshair: true
    };
    var yAxis = {
        min: 0,
        title: {
            text: ' Average PM 10 content  (ug/m^3)'
        }
    };
    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
            + '<td style="padding:0"><b>{point.y:.2f} ug/m^3</b></td></tr>',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        column: {
            pointPadding: 0.2,
            borderWidth: 0
        },
        bar: {
            dataLabels: {
                enabled: true,
                allowOverlap: true // 允许数据标签重叠
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var we = {};
    we.name = 'PM 10 含量';
    we.data = [];
    for (i = 0; i < data.length; i++) {
        we.data.push(data[i].pm10);
    }
    series.push(we);


    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.xAxis = xAxis;
    json.yAxis = yAxis;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_PM10').highcharts(json);
}


function getdestination(data) {
    var chart = {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    };
    var title = {
        text: '不同目的地的出差次数'
    };

    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<br/>出差次数: {point.y:.f} 次',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        pie: {
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.y:.f} 次',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var se = {
        name: 'times',
        colorByPoint: true,
        data: []
    };
    series.push(se);

    for (i = 0; i < data.length; i++) {
        var we = {
            name: data[i].destination,
            y: data[i].count
        };

        series[0].data.push(we);
    }

    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_destination').highcharts(json);
}

function getstaff(data) {
    var chart = {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    };
    var title = {
        text: '不同员工的出差次数'
    };

    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<br/>出差次数: {point.y:.f} 次',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        pie: {
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.y:.f} 次',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var se = {
        name: 'times',
        colorByPoint: true,
        data: []
    };
    series.push(se);

    for (i = 0; i < data.length; i++) {
        var we = {
            name: data[i].name,
            y: data[i].count
        };

        series[0].data.push(we);
    }

    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_staff').highcharts(json);
}

function getweather(data) {
    var chart = {
        plotBackgroundColor: null,
        plotBorderWidth: null,
        plotShadow: false,
        type: 'pie'
    };
    var title = {
        text: '不同天气的出差次数'
    };

    var tooltip = {
        headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
        pointFormat: '<br/>出差次数: {point.y:.f} 次',
        footerFormat: '</table>',
        shared: true,
        useHTML: true
    };
    var plotOptions = {
        pie: {
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.y:.f} 次',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            }
        }
    };
    var credits = {
        enabled: false
    };

    var series = [];
    var se = {
        name: 'times',
        colorByPoint: true,
        data: []
    };
    series.push(se);

    for (i = 0; i < data.length; i++) {
        var we = {
            name: data[i].weather,
            y: data[i].count
        };

        series[0].data.push(we);
    }

    var json = {};
    json.chart = chart;
    json.title = title;
    json.tooltip = tooltip;
    json.series = series;
    json.plotOptions = plotOptions;
    json.credits = credits;
    $('#container_weather').highcharts(json);
}

function setTime() {
    //非空校验
    var time = $("#time").val();
    //表单元素的value取值不会为null，取值是空字符串
    if (time === "") {
        alert("时间间隔不能为空，请输入")
    }
    //使用AJAX提交数据
    var loadingIndex = null;
    $.ajax({
        type: "POST",
        url: "http://localhost:8090/device/set?uptime=" + time,
        beforeSend: function (XHR) {
            layer.load(2);
        },
        complete: function () {
            setTimeout(function () {
                layer.closeAll('loading');
            }, 100);
        },
        success: function (result) {
            layer.msg("设置成功", {time: 700})
        },
        error: function () {
            layer.msg("设置失败", {time: 1000})
        }
    });
}


function addOption(dev) {
    var oSelect = document.getElementById("devices");
    var i = 0;
    for (; i < dev.length; i++) {
        var newoption = document.createElement("option");
        if (i === 1) {
            newoption.selected = true;
        }
        newoption.text = dev[i].name;
        newoption.value = dev[i].id;
        oSelect.add(newoption, null);
    }
    $("#devices").change(function () {
        console.log("改变");
        change = [1, 1, 1, 1];
    });
}

function terco2() {
    var serie = [];
    var cate = [];
    var i;
    var mdata;
    var dev;
    update();

    var json = Highcharts.chart('container_ter_co2', {
        chart: {
            type: 'spline',
            marginRight: 10
        },
        title: {
            text: '二氧化碳空气含量'
        },
        xAxis: {
            tickPixelInterval: 150,
            categories: ['co2', 'co2', 'co2', 'co2', 'co2', 'co2', 'co2', 'co2', 'co2', 'co2']
        },
        yAxis: {
            title: {
                text: '单位      ppm'
            },
            minTickInterval: 10,
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                return '<b>'
                    + this.series.name
                    + '</b><br/>'
                    + this.x
                    + '<br/>' + Highcharts.numberFormat(this.y, 2);
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                }
            }
        }, credits: {
            enabled: false
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: "",
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }]
    });

    function update() {
        dev = $('#devices option:selected');

        console.info(dev.val());
        if (dev.val() !== '0') {
            serie = [];
            cate = [];

            $.ajax({
                type: "post",
                url: "http://localhost:8090/device/data/co2?did=" + dev.val() + "&from=0&to=10",
                async: false,
                success: function (d) { //参数data为后台获取的数据
                    var da = (eval('(' + d + ')').data);

                    var j;
                    for (j = 0; j < da.length; j++) {
                        serie.push(da[j].co2);
                        cate.push(da[j].date)
                    }
                    cate.reverse();
                    serie.reverse();
                },
                error: function () {
                    console.log("实时信息，请求失败");
                    clearTimeout(2000);
                }
            });

        }

    }


    setInterval(function () {


        update();

        var ncate = arr_dive(json.xAxis[0].categories, cate);
        if (change[0] === 1) {
            ncate = cate;
            change[0] = 0;
        }
        var j = 0;
        for (; j < ncate.length; j++) {
            json.xAxis[0].categories.push(ncate[j]);
            json.series[0].addPoint(serie[serie.length - j - 1], true, true);
        }


    }, 1000);
}

function tervoc() {
    var serie = [];
    var cate = [];
    var i;
    var mdata;
    var dev;
    update();

    var json = Highcharts.chart('container_ter_voc', {
        chart: {
            type: 'line',
            marginRight: 10
        },
        title: {
            text: 'VOC 空气含量'
        },
        xAxis: {
            tickPixelInterval: 150,
            categories: ['voc', 'voc', 'voc', 'voc', 'voc', 'voc', 'voc', 'voc', 'voc', 'voc']
        },
        yAxis: {
            title: {
                text: '单位      ppm'
            },
            minTickInterval: 10,
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                return '<b>'
                    + this.series.name
                    + '</b><br/>'
                    + this.x
                    + '<br/>' + Highcharts.numberFormat(this.y, 2);
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                }
            }
        }, credits: {
            enabled: false
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: "",
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }]
    });

    function update() {
        dev = $('#devices option:selected');
        console.info(dev.val());
        if (dev.val() !== '0') {
            serie = [];
            cate = [];

            $.ajax({
                type: "post",
                url: "http://localhost:8090/device/data/voc?did=" + dev.val() + "&from=0&to=10",
                async: false,
                success: function (d) { //参数data为后台获取的数据
                    var da = (eval('(' + d + ')').data);

                    var j;
                    for (j = 0; j < da.length; j++) {
                        serie.push(da[j].voc);
                        cate.push(da[j].date)
                    }
                    cate.reverse();
                    serie.reverse();
                },
                error: function () {
                    console.log("实时信息，请求失败");
                    clearTimeout(2000);
                }
            });

        }

    }


    setInterval(function () {


        update();


        var ncate = arr_dive(json.xAxis[0].categories, cate);
        if (change[1] === 1) {
            ncate = cate;
            change[1] = 0;
        }
        var j = 0;
        for (; j < ncate.length; j++) {
            json.xAxis[0].categories.push(ncate[j]);
            json.series[0].addPoint(serie[serie.length - j - 1], true, true);
        }


    }, 1000);
}


function terpm10(dev) {
    var serie = [];
    var cate = [];
    var i;
    var mdata;
    update();

    var json = Highcharts.chart('container_ter_pm10', {
        chart: {
            type: 'line',
            marginRight: 10
        },
        title: {
            text: 'pm 10 空气含量'
        },
        xAxis: {
            tickPixelInterval: 150,
            categories: ['pm10', 'pm10', 'pm10', 'pm10', 'pm10', 'pm10', 'pm10', 'pm10', 'pm10', 'pm10']
        },
        yAxis: {
            title: {
                text: '单位      ug/m^3'
            },
            minTickInterval: 10,
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                return '<b>'
                    + this.series.name
                    + '</b><br/>'
                    + this.x
                    + '<br/>' + Highcharts.numberFormat(this.y, 2);
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                }
            }
        }, credits: {
            enabled: false
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: "",
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }]
    });

    function update() {
        var dev = $('#devices option:selected');
        console.info(dev.val());
        if (dev.val() !== '0') {
            serie = [];
            cate = [];

            $.ajax({
                type: "post",
                url: "http://localhost:8090/device/data/pm10?did=" + dev.val() + "&from=0&to=10",
                async: false,
                success: function (d) { //参数data为后台获取的数据
                    var da = (eval('(' + d + ')').data);

                    var j;
                    for (j = 0; j < da.length; j++) {
                        serie.push(da[j].pm10);
                        cate.push(da[j].date)
                    }
                    cate.reverse();
                    serie.reverse();
                },
                error: function () {
                    console.log("实时信息，请求失败");
                    clearTimeout(2000);
                }
            });

        }

    }


    setInterval(function () {


        update();


        var ncate = arr_dive(json.xAxis[0].categories, cate);
        if (change[2] === 1) {
            ncate = cate;
            change[2] = 0;
        }
        var j = 0;
        for (; j < ncate.length; j++) {
            json.xAxis[0].categories.push(ncate[j]);
            json.series[0].addPoint(serie[serie.length - j - 1], true, true);
        }


    }, 1000);
}

function terpm25() {
    var serie = [];
    var cate = [];
    var i;
    var mdata;
    var dev;
    update();

    var json = Highcharts.chart('container_ter_pm25', {
        chart: {
            type: 'line',
            marginRight: 10
        },
        title: {
            text: 'pm 2.5 空气含量'
        },
        xAxis: {
            tickPixelInterval: 150,
            categories: ['pm2.5', 'pm2.5', 'pm2.5', 'pm2.5', 'pm2.5', 'pm2.5', 'pm2.5', 'pm2.5', 'pm2.5', 'pm2.5']
        },
        yAxis: {
            title: {
                text: '单位      ug/m^3'
            },
            minTickInterval: 10,
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        tooltip: {
            formatter: function () {
                return '<b>'
                    + this.series.name
                    + '</b><br/>'
                    + this.x
                    + '<br/>' + Highcharts.numberFormat(this.y, 2);
            }
        },
        plotOptions: {
            line: {
                dataLabels: {
                    enabled: true
                }
            }
        }, credits: {
            enabled: false
        },
        legend: {
            enabled: false
        },
        exporting: {
            enabled: false
        },
        series: [{
            name: "",
            data: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
        }]
    });

    function update() {
        dev = $('#devices option:selected');
        console.info(dev.val());
        if (dev.val() !== '0') {
            serie = [];
            cate = [];

            $.ajax({
                type: "post",
                url: "http://localhost:8090/device/data/pm25?did=" + dev.val() + "&from=0&to=10",
                async: false,
                success: function (d) { //参数data为后台获取的数据
                    var da = (eval('(' + d + ')').data);

                    var j;
                    for (j = 0; j < da.length; j++) {
                        serie.push(da[j].pm25);
                        cate.push(da[j].date)
                    }
                    cate.reverse();
                    serie.reverse();
                },
                error: function () {
                    console.log("实时信息，请求失败");
                    clearTimeout(2000);
                }
            });

        }

    }


    setInterval(function () {


        update();

        var ncate = arr_dive(json.xAxis[0].categories, cate);
        if (change[3] === 1) {
            ncate = cate;
            change[3] = 0;
        }
        var j = 0;
        for (; j < ncate.length; j++) {
            json.xAxis[0].categories.push(ncate[j]);
            json.series[0].addPoint(serie[serie.length - j - 1], true, true);
        }


    }, 1000);
}


function arr_dive(aArr, bArr) { //第一个数组减去第二个数组
    if (bArr.length === 0) {
        return [];
    }
    if (aArr.length === 0) {
        return bArr;
    }
    var diff = [];
    var i = bArr.length - 1;
    var j = aArr.length - 1;
    for (; i >= 0; i--) {

        for (j = aArr.length - 1; j >= 0; j--) {
            if (bArr[i] === aArr[j]) {
                break;
            }
        }
        if (j > 0) {
            break;
        } else {
            diff.push(bArr[i]);
            console.info("push:" + bArr[i]);

        }
    }

    return diff.reverse();
}