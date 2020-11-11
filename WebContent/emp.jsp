<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-master/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="jquery-easyui-master/themes/icon.css" />
<script type="text/javascript" src="jquery-easyui-master/jquery.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-master/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="jquery-easyui-master/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
	$(function(){
		$.getJSON("doinit_emp.do",function(map){
			var lsdep = map.lsdep;
			var lswf = map.lswf;
			for (var i = 0; i < lswf.length; i++) {
				var wf = lswf[i];
				$("#wf").append("<input type='checkbox' name='wids' value='"+wf.wid+"'/>"+wf.wname);
			}
			$('#depid').combobox({    
			    data:lsdep,    
			    valueField:'depid',    
			    textField:'depname',
			    value:1,
			    panelHeight:150
			}); 
		});
	});
		
	
</script>
</head>
<body>
	<div>
		<form action="" method="post" enctype="multipart/form-data"
			name="ffemp" id="ffemp">
			<table width="550" border="1" align="center" cellpadding="1"
				cellspacing="0">
				<tr>
					<td colspan="3" align="center" bgcolor="#99FFCC">员工管理</td>
				</tr>
				<tr>
					<td width="104">姓名</td>
					<td width="303"><input type="text" name="ename" id="ename" />
						<input type="hidden" name="eid" id="eid" /></td>

					<td width="129" rowspan="7"><img id="myphoto"
						src="uppic/default.jpg" width="129" height="150" /></td>
				</tr>
				<tr>
					<td>性别</td>
					<td><input name="sex" type="radio" id="radio" value="男"
						checked="checked" />男 <input type="radio" name="sex" id="radio2"
						value="女" />女</td>
				</tr>
				<tr>
					<td>地址</td>
					<td><input type="text" name="address" id="address" /></td>
				</tr>
				<tr>
					<td>生日</td>
					<td><input name="sdate" type="date" id="sdate"
						value="1990-01-01" /></td>
				</tr>
				<tr>
					<td>照片选择</td>
					<td><input type="file" name="pic" id="pic" /></td>
				</tr>
				<tr>
					<td>部门</td>
					<td><input type="text" name="depid" id="depid" /></td>
				</tr>
				<tr>
					<td>薪资</td>
					<td><input name="emoney" type="text" id="emoney" value="2000" /></td>
				</tr>
				<tr>
					<td>福利</td>
					<td colspan="2"><span id="wf"></span></td>
				</tr>
				<tr>
					<td colspan="3" align="center" bgcolor="#99FFCC"><input
						type="button" name="btsave" id="btsave" value="保存" /> <input
						type="button" name="btupdate" id="btupdate" value="修改" /> <input
						type="button" name="btreset" id="btreset" value="取消" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>