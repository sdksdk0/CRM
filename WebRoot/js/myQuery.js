(function(){
	var  myQuery={};
	window.myQuery = myQuery;
	myQuery.get=function(url,params,fn){
			
			var xmlhttp=null;
			if (window.XMLHttpRequest){// code for all new browsers
				xmlhttp=new XMLHttpRequest();
			} else if (window.ActiveXObject){// code for IE5 and IE6
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			
			xmlhttp.onreadystatechange = function(){
				if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
					fn(xmlhttp.responseText);
				}
			};
			
			var isFirst=true;
			for(key in params){
				var value=params[key];
				if(isFirst){
					url=url+"?"+key+"="+value;
					isFirst=false;
				}else{
					url+="&"+key+"="+value;
				}
			}
			xmlhttp.open("GET", url);
			xmlhttp.send(null);	
		}
})();

