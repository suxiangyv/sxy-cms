<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content1") != null ? request.getParameter("content1") : "";
%>
<!doctype html>
<html>
<head>

	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="/resource/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="/resource/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="/resource/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="/resource/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="/resource/kindeditor/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			window.editor1 = K.create('textarea[name="content1"]', {
				cssPath : '/resource/kindeditor/plugins/code/prettify.css',
				uploadJson : '/resource/kindeditor/jsp/upload_json.jsp',
				fileManagerJson : '/resource/kindeditor/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>
</head>
<body>
	<%=htmlData%>
	<form  id="form">
		 <div class="form-group pt-2">
		    <label for="title">文章标题</label>
		    <input  class="form-control" name="title" id="title" >
		  </div>
		  
		  <div class="form-group pt-2">
		    <div class="row">
		      	<div class="col-md-2">
				    <label for="channelId">所属栏目:</label>
				    <select id="channelId" name="channelId">
				      <option> --请选择--</option>
				    </select>
		    	</div>
		    	<div class="col-md-2">
				    <label for="categoryId">所属分类:</label>
				    <select id="categoryId" name="categoryId">
				      <option> --请选择--</option>
				    </select>
		    	</div>
		    </div>
		  </div>
		  
		   <div class="form-group pt-2">
		    <input type="file" class="form-control-file" name="file"  >
		  </div>
		
		<textarea name="content1" cols="100" rows="8" style="width:1570px;height:350px;visibility:hidden;"><%=htmlspecialchars(htmlData)%></textarea>
		<br />
		<input id="tj" type="button" name="button" value="发表文章" />
	</form>
</body>
<script type="text/javascript">
$(function(){
	
	//获取栏目列表
	 $.post(
	    "/channel/getChannelList.do",
	    function(obj){ 
    	    for ( var i in obj) {
				$("#channelId").append("<option value='"+obj[i].id+"'>"+obj[i].name+"</option>")
			}
	    },"json"
	 )
});


$("#channelId").change(function(){
	var channelId = $(this).val();
	 $("#categoryId").html("");
	 $.post(
     	    "/channel/getCategoryList.do", 
     	    {"channelId":channelId},
     	    function(obj){
	        	   for ( var i in obj) {
						$("#categoryId").append("<option value='"+obj[i].id+"'>"+obj[i].name+"</option>")
					} 
     	    },"json"
     	 )
})


$("#tj").click(function(){
	var formData = new FormData($("#form")[0]);
	var  con =editor1.html();
	
	formData.set("content",con);
	$.ajax({
		url:"/my/publish/article.do", 
		data:formData, 
		dataType:"json", 
		type:"post",
		processData:false,
		contentType:false,
		success:function(obj){
			if(obj){
				$("#content").load("/my/article.do");
			}else{
				alert("发布失败！")
			}
		}
	})
})
</script>
</html>
<%!
	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}
%>