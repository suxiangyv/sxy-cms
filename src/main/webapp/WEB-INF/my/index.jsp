<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--1. 视窗 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!--2.  引入bootstrap.css -->
<link rel="stylesheet" type="text/css" href="/resource/css/bootstrap.css" />
<!--3. 引入 jquery.js 一定要在bootstrap.min.js之前引入-->
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>
<!--4. 引入bootstrap.min.js -->
<script type="text/javascript" src="/resource/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div  class="container-fluid">
       <div class="row">
       		   <div class="col-md-12 bg-dark pt-1" style="height: 40px">
       		  		<img class="rounded-circle" style="height: 30px" alt="" src="/resource/imges/1.jpg">
       		  		<font color="white">个人中心</font>
       		   </div>
       </div>
       <div class="row">
          	 <div class="col-md-2 bg-light pt-1" style="height: 550px">
	          	 <div class="list-group text-center">
					  <a href="#" url="/my/article.do" class="list-group-item list-group-item-action active">我的文章</a>
					  <a href="#" url="/my/publish.do"  class="list-group-item list-group-item-action">发布文章</a>
					  <a href="#" class="list-group-item list-group-item-action">热点</a>
					  <a href="#" class="list-group-item list-group-item-action">娱乐</a>
					  <a href="#" class="list-group-item list-group-item-action">科技</a>
					  <a href="#" class="list-group-item list-group-item-action">体育</a>
					  <a href="#" class="list-group-item list-group-item-action disabled" tabindex="-1" aria-disabled="true">个人设置</a>
				</div>
          	 </div>	 
          	 <div class="col-md-10" id="content">
          	    <div  class="row pt-2">
          	        <div class="pt-2" style="display:none">
          	           <jsp:include page="publish.jsp"></jsp:include>
          	        </div>
          	    </div>
          	 </div>	 
       </div>
    </div>
</body>
<script type="text/javascript">

	$("a").click(function(){
		//请求的地址
		var url= $(this).attr("url"); 
		//内容区域加载
		$("#content").load(url);
		//清除样式active
		$("a").removeClass("active");
		//当前点击的时追加样式
		$(this).addClass("active");
	})
</script>
</html>