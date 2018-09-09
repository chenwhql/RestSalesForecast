<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.thuss.fsa.model.*,java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Food Info</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!--你自己的样式文件 -->
    <link rel="shortcut icon" href="img/coffee.ico">
    <link href="css/info.css" rel="stylesheet" type="text/css">

    <!-- Loading Flat UI -->
    <link href="css/flat-ui.min.css" rel="stylesheet">

    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/highcharts.js"></script>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="js/vendor/html5shiv.js"></script>
    <script src="js/vendor/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-01">
                <span class="sr-only">Toggle navigation</span>
            </button>
            <a class="navbar-brand" href="home.do">Restaurant Sales Analysis and Forecasting Prototype</a>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">Dish name：${food.foodName}</h3>
                </div>
                <div class="panel-primary">
                    <ul class="nav nav-pills" role="tablist">
                        <li role="presentation"><a href="hotelInfo.do?hotelId=${hotel.hotelId}">Restaurant name&nbsp;&nbsp;<span class="label label-default">${hotel.hotelName}</span></a></li>
                        <li role="presentation"><a href="#">Category&nbsp;&nbsp;<span class="label label-default">${food.cateName}</span></a></li>
                        <li role="presentation"><a href="#">Price&nbsp;&nbsp;<span class="label label-default">${food.unitMoney}</span></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-6">
                <div id="container" style="min-width:400px;height:400px"></div>
                <script>
            	$(document).ready(function () {
               	 var colors = Highcharts.getOptions().colors;
               	 $.ajax({
                     data:{
                         foodId:${food.foodId}
                     },
                     url: "foodsales.do",
                     dataType: "json",
                     success:  function(data){
                         $('#container').highcharts({
                             title: {
                                 text: 'Historical Sales and Forecast Chart',
                                 x: -20 //center
                             },
                             chart: {
                                 type: 'line'
                             },
                             /*subtitle: {
                                 text: 'Source: WorldClimate.com',
                                 x: -20
                             },*/
                             xAxis: {
                                   //categories: dateList,
                             	  type: 'datetime',  
                             	  dateTimeLabelFormats : { 
                                       day : '%Y-%m-%d',
                                   },
                                   tickInterval: 24 * 3600 * 1000//间隔2天
                             },
                             yAxis: {
                             	  title: {
                                       text: 'Sales (Dish)'
                                   },
                                   plotLines: [{
                                       value: 0,
                                       width: 1,
                                       color: '#808080'
                                   }]
                             },
                             tooltip: {
                             	 valueSuffix: 'Dish'
                             },
                             legend: {
                             	 layout: 'vertical',
                                  align: 'right',
                                  verticalAlign: 'middle',
                                  borderWidth: 0
                             },
                             series: [{
                             	 name: data.foodName+'('+data.hotelName+')',
                                 data:data.sales,
                                 pointStart: Date.UTC(2016,5,24),
                                 pointIntervalUnit: 'day',
                                 zoneAxis: 'x',
                                 zones: [{
                                     value: Date.UTC(2016,6,1),
                                     color: colors[2]
                                 },
                                 {
                                     color: colors[5]
                                 }]
                                 }
                             ]
                         });
                     }
                 });
               	 
               	 $.ajax({
                     data:{
                         foodId:${food.foodId}
                     },
                     url: "similiarSales.do",
                     dataType: "json",
                     success:  function(data){
                    	 var series = [];
                    	 for(var i=0;i<data.length;i++)
                    	{
                    		s = {};
                    		s.name=data[i].foodName+'('+data[i].hotelName+')';
                    		s.data = data[i].sales;
               				s.pointStart=Date.UTC(2016,5,17);
                    		s.pointIntervalUnit='day';
                    		series[i] = s;
                    	}
                         var title = {
                                 text: 'Similar Food Comparison Chart',
                                 x: -20 //center
                             };
//                             subtitle: {
//                                 text: 'Source: WorldClimate.com',
//                                 x: -20
//                             },
                         var xAxis = {
                        		  type: 'datetime',  
                            	  dateTimeLabelFormats : { 
                                      day : '%Y-%m-%d',
                                  },
                                  tickInterval: 24 * 3600 * 1000//间隔2天
                             };
                         var yAxis = {
                                 title: {
                                     text: 'Sales (Dish)'
                                 },
                                 plotLines: [{
                                     value: 0,
                                     width: 1,
                                     color: '#808080'
                                 }]
                             };
                         var tooltip = {
                                 valueSuffix: 'Dish'
                             };
                         var legend = {
                                 layout: 'vertical',
                                 align: 'right',
                                 verticalAlign: 'middle',
                                 borderWidth: 0
                             };
                         var json = {};
                         json.title = title;
                         json.tooltip = tooltip;
                         json.xAxis = xAxis;
                         json.yAxis = yAxis;
                         json.series = series;
                         json.legend = legend;
                         $('#ChartCompare').highcharts(json);
                     
                     }
                 });
                });
                </script>
            </div>
            <div class="col-lg-6">
                <div id="ChartCompare" style="min-width:400px;height:400px"></div>
            </div>
        </div>
        <div class="row">
            <div class="panel panel-warning" style="text-align: center">
                <div class="panel-body">
                    Recommended pricing：${recommendPrice} Yuan！
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-success">
                    <!-- Default panel contents -->
                    <div class="panel-heading">Recommended dishes</div>

                    <!-- Table -->
                    <table class="table table-striped table-hover" id="table1">
                        <tr>
                            <th>No.</th>
                            <th>Dish Name</th>
                            <th>Price</th>
                            <th>Category</th>
                        </tr>
  						<c:forEach items="${groupFoods}" var="foodSet" varStatus="s">
                        <tr>
                            <td></td>
                            <td><a href='foodInfo.do?foodId=${foodSet.foodId}'>${foodSet.foodName}</a></td>
                            <td>${foodSet.unitMoney}</td>
                            <td>${foodSet.cateName}</td>
                        </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
         </div>
    </div>
    <div id="footer">
        <p>© Copyright 2018 &nbsp;|&nbsp; Weihang Chen. All rights reserved.</p>
    </div>
    <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
    <!--<script src="js/jquery-2.1.1.js"></script>-->
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
    <script src="js/bootstrap.min.js"></script>

    <!--<script src="flatui/js/vendor/jquery.min.js"></script>-->
    <script src="js/flat-ui.min.js"></script>
    <script type="text/javascript">
        $(function(){
            //$('table tr:not(:first)').remove();
            var len = $('table tr').length;
            for(var i = 1;i<len;i++){
                $('table tr:eq('+i+') td:first').text(i);
            }
        });
    </script>
</body>
</html>