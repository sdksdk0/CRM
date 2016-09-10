/**
 * ajax通过部门id显示职务类型
 * 
 * 
 */
function changePost(obj,postSelectId){

	var departmentId = obj.value;

	var url = "postAction_ajaxGetAllPost";

	myQuery.get(url,{"crmDepartment.depId":departmentId},function(data){
		var postSelectObject = document.getElementById(postSelectId);
		postSelectObject.innerHTML = "<option value=''>--请选择--</option>";
		// 转换成json
		var jsonData = eval("("+data+")");
		// 遍历
		for(var i = 0 ; i < jsonData.length ; i ++){
			var postObj = jsonData[i];
			var postId = postObj.postId;
			var postName = postObj.name;
			
			postSelectObject.innerHTML += "<option value='"+postId+"'>"+postName+"</option>";
		}
	});
}