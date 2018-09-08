<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.thuss.fsa.model.*,java.util.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SearchHotelResults</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!--你自己的样式文件 -->
    <link rel="shortcut icon" href="img/search.ico">
    <link href="css/search.css" rel="stylesheet" type="text/css">

    <!-- Loading Flat UI -->
    <link href="flatui/css/flat-ui.css" rel="stylesheet">

    <link href="select2/css/select2.min.css" rel="stylesheet" />
    <script src="select2/js/select2.min.js"></script>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
    <!--[if lt IE 9]>
    <script src="flatui/js/vendor/html5shiv.js"></script>
    <script src="flatui/js/vendor/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
     	function isEmpty()
     	{
     		var keyword = document.getElementById("keyword").value;
     		if(keyword.trim().length==0)
     			return false;
     		return true;
     	}
    </script>
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
    <form action="search.do" method="get">
        <div class="row">
            <div class="col-lg-6">
                <div class="row">
                    <div class="col-lg-12">
                        <div id="img">
                            <img src="img/logo_icon.jpg" width="60" height="60" style="margin-right: 20px;">
                        </div>
                        <div class="input-group input-group-lg" style="margin-top: 14px;">
                            <input class="form-control" type="text" name="keyword" id="keyword" value="${page.keyword}">
                            <span class="input-group-btn"><button type="submit" class="btn btn-default" onclick="return isEmpty()"><span class="glyphicon glyphicon-search"></span></button></span>
                        </div>
                    </div>
                    <%--<input type="hidden" name="CpageSize" id="CpageSize" value="<%=pageSize %>" >--%>
                </div>
            </div>
            <div class="col-lg-1" style="margin-top: 16px;">
                <select name="searchType" class="form-control select select-info select-block mbl" style="min-width:90px" >
                  <c:choose>
                    <c:when test="${page.searchType eq '餐厅'}">
                      <option value="餐厅" selected="selected">Restaurants</option>
                      <option value="菜名">Dishes</option>
                    </c:when>
                    <c:otherwise>
                     <option value="餐厅">Restaurants</option>
                     <option value="菜名" selected="selected">Dishes</option>
                    </c:otherwise>
                    </c:choose>
                </select>
            </div>
        </div>
        </form>
        <div class="row">
            <table id="hotel_table" class="table table-striped table-hover">
                <tr>
                    <th>No.</th>
                    <th>Restaurant</th>
                    <th>Cuisine</th>
                    <th>Business</th>
                    <th>Number of dishes</th>
                    <th>Weekly order total</th>
                    <th>Weekly turnover</th>
                    <th></th>
                </tr>
                <c:forEach items="${page.list}" var='hotel'>
                <tr>
                    <td></td>
                    <td>${hotel.hotelName}</td>
                    <td>${hotel.caixi}</td>
                    <td>${hotel.format }</td>
                    <td>${hotel.numOfFood}</td>
                    <td>${hotel.totalOrders}</td>
                    <td>${hotel.totalMoney}</td>
                    <td>
                        <a href="hotelInfo.do?hotelId=${hotel.hotelId}" type="button" class="btn btn-default btn-primary">Details</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <div class="row">
            <div class="alert alert-success" role="alert">
				Total ${page.totalRecords} records | Total ${page.totalPages} pages | Current ${page.pageNo} page
			</div>
			<a href="search.do?searchType=${page.searchType}&keyword=${page.keyword}&pageNo=${page.topPageNo}" class="btn btn-primary">First page</a>
            <c:choose>
              <c:when test="${page.pageNo!=1}">
                  <a href="search.do?searchType=${page.searchType}&keyword=${page.keyword}&pageNo=${page.previousPageNo}">
                  	<input type="button" class="btn btn-primary" name="previousPage" value="Previous page" />
                  </a>
              </c:when>
              <c:otherwise>
                  <input type="button" class="btn btn-primary" disabled="disabled" name="previousPage" value="Previous page" />
              </c:otherwise>
            </c:choose>
            <c:choose>
              <c:when test="${page.pageNo != page.totalPages}">
                <a href="search.do?searchType=${page.searchType}&keyword=${page.keyword}&pageNo=${page.nextPageNo}">
                	<input type="button" class="btn btn-primary" name="nextPage" value="Next page" />
                </a>
              </c:when>
              <c:otherwise>
                  <input type="button" class="btn btn-primary" disabled="disabled" name="nextPage" value="Next page" />
              </c:otherwise>
            </c:choose>
			<a href="search.do?searchType=${page.searchType}&keyword=${page.keyword}&pageNo=${page.bottomPageNo}">
				<input type="button" class="btn btn-primary" name="lastPage" value="Last page">
			</a>  
        </div>
    </div>
    <div id="footer">
        <p>© Copyright 2018 &nbsp;|&nbsp; Weihang Chen. All rights reserved.</p>
    </div>
    <!-- 如果要使用Bootstrap的js插件，必须先调入jQuery -->
    <script src="js/jquery-2.1.1.js"></script>
    <!-- 包括所有bootstrap的js插件或者可以根据需要使用的js插件调用　-->
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script src="flatui/js/vendor/jquery.min.js"></script>
    <script src="flatui/js/flat-ui.min.js"></script>
    <script type="text/javascript">
        $("select").select2({dropdownCssClass: 'dropdown-inverse'});
    </script>
    <script type="text/javascript">
        $(function(){
            //$('table tr:not(:first)').remove();
            var len = $('table tr').length;
            for(var i = 1;i<len;i++){
                $('table tr:eq('+i+') td:first').text(i);
            }
        });
    </script>
    <script type="text/javascript">
        $(function () {

            //1.初始化Table
            var oTable = new TableInit();
            oTable.Init();

            //2.初始化Button的点击事件
            var oButtonInit = new ButtonInit();
            oButtonInit.Init();

        });

        var TableInit = function () {
            var oTableInit = new Object();
            //初始化Table
            oTableInit.Init = function () {
                $('#tb_departments').bootstrapTable({
                    url: '/Home/GetDepartment',         //请求后台的URL（*）
                    method: 'get',                      //请求方式（*）
                    toolbar: '#toolbar',                //工具按钮用哪个容器
                    striped: true,                      //是否显示行间隔色
                    cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                    pagination: true,                   //是否显示分页（*）
                    sortable: false,                     //是否启用排序
                    sortOrder: "asc",                   //排序方式
                    queryParams: oTableInit.queryParams,//传递参数（*）
                    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                    pageNumber:1,                       //初始化加载第一页，默认第一页
                    pageSize: 10,                       //每页的记录行数（*）
                    pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                    search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                    strictSearch: true,
                    showColumns: true,                  //是否显示所有的列
                    showRefresh: true,                  //是否显示刷新按钮
                    minimumCountColumns: 2,             //最少允许的列数
                    clickToSelect: true,                //是否启用点击选中行
                    height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                    uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                    showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
                    cardView: false,                    //是否显示详细视图
                    detailView: false,                   //是否显示父子表
                    columns: [{
                        checkbox: true
                    }, {
                        field: 'Name',
                        title: '部门名称'
                    }, {
                        field: 'ParentName',
                        title: '上级部门'
                    }, {
                        field: 'Level',
                        title: '部门级别'
                    }, {
                        field: 'Desc',
                        title: '描述'
                    }, ]
                });
            };

            //得到查询的参数
            oTableInit.queryParams = function (params) {
                var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    limit: params.limit,   //页面大小
                    offset: params.offset,  //页码
                    departmentname: $("#txt_search_departmentname").val(),
                    statu: $("#txt_search_statu").val()
                };
                return temp;
            };
            return oTableInit;
        };


        var ButtonInit = function () {
            var oInit = new Object();
            var postdata = {};

            oInit.Init = function () {
                //初始化页面上面的按钮事件
            };

            return oInit;
        };
    </script>
</body>
</html>