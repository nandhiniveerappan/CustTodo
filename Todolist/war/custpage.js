var custname1= document.getElementById("name1");
var custnum1= document.getElementById("num1");
var custemail1= document.getElementById('email1');
var custaddress1=  document.getElementById('address1');
var custname2= document.getElementById("name2");
var custnum2= document.getElementById("num2");
var custemail2= document.getElementById('email2');
var custaddress2=  document.getElementById('address2');
var todoval= document.getElementById("add1");
var custList = document.getElementById("ulist");
var todoUList = document.getElementById("ulist2");
var custPop= document.getElementById("pop");
var todo=document.getElementById("todo");
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
counter=1;
counter1=1;
counter2=0;
var key1;
var arr=[];

currentCustEmail = "";

$(document).ready(function(){
	
	$.ajax({
		url:'/LoadCustomers',
		type:'GET',
		success:function(data){
			console.log("data from servlet as jsonObject :"+data);
			var jsondata = JSON.parse(data);
			console.log("data from servlet as jsObject :"+jsondata);			
			for(i=0;i<jsondata.length;i++){
			var obj = jsondata[i];
			console.log("object values name :"+obj.name+" and email :"+obj.email+"and phone:"+obj.phone+"and num:"+obj.number+" and todolist :"+obj.todoList);			
			savecust(obj.name,obj.phone,obj.email,obj.address,obj.todoList);
			}
		},
		failure:function(){
			
		}
	});
	
});

function savecust(name, number, email, address, todo)
{
	var list = document.createElement("li");
	list.id="count"+counter;
//    var input1= document.createElement("input");
//    input1.type="checkbox";
   // list.appendChild(input1);
    var listval = document.createElement("label");
	listval.innerText= name; 
	console.log(name);
    list.appendChild(listval);
    var button1= document.createElement("button");
    button1.id="b1";
    var del=document.createTextNode("delete");
    button1.appendChild(del);
    list.appendChild(button1);
    var element = document.getElementById("ulist");
    element.appendChild(list);
	arr.length=0;

      button1.addEventListener("click", function()
      {
    	  var r = confirm("Please confirm to delete the customer");
    	  if(r==true){
          id1=this.parentNode.id;
    	  deleteItem=document.getElementById(this.parentNode.id);
       	  var data = JSON.parse(localStorage.getItem(this.parentNode.id));
    	  var jsOb = new Object();
    	  jsOb.custEmail = data.email;

    		
    		var jsonOb = JSON.stringify(jsOb);
    		console.log("data in delete (json)"+jsonOb);

    		
    		$.ajax({
    			url:'/DeleteContact',
    			type:'POST',
    			data:'data='+jsonOb,
    			success:function(){
    				custList.removeChild(deleteItem);
    				localStorage.removeItem(id1);
    				custname2.value = "";
    			    custnum2.value= "";
    			    custemail2.value= "";
    			    custaddress2.value= "";
    			    todoUList.innerHTML="";
    			}
      });
    	  }
    	  else{
    		  return false;
    	  }
      });
    var myCust = { "name": name , "number": number, "email": email, "address": address, "todoList":todo};
    var myJSON = JSON.stringify(myCust);
    localStorage.setItem("count"+counter, myJSON);
 listval.addEventListener("click", function()
 {
    details = localStorage.getItem(this.parentNode.id);
	data = JSON.parse(details);
	custname2.value = data.name;
    custnum2.value= data.number;
    custemail2.value= data.email;
    custaddress2.value= data.address;    
    console.log(arr);
    key1=document.getElementById(this.parentNode.id).id;
      console.log(key1);  
//to get the items which has been updated using updateform
    details = localStorage.getItem(key1);
    data = JSON.parse(details);
	custname2.value = data.name;
    custnum2.value= data.number;
    custemail2.value= data.email;
    custaddress2.value= data.address;
//to load todo list while clicking on custname
    var myarr=data.todoList;
    console.log(myarr);
    ulist2.innerHTML="";

  for(i=0; i < myarr.length; i++)
  {
	var list2= document.createElement("li");
    var lbl= document.createElement("label");
	lbl.innerText=myarr[i];
    list2.id="count1"+counter1;
    list2.appendChild(lbl);
    var button2= document.createElement("button");
    button2.id="b2";
	var del2=document.createTextNode("done");
	button2.appendChild(del2);
	list2.appendChild(button2);
    var element2= document.getElementById("ulist2");
	element2.appendChild(list2);
	button2.addEventListener("click", function()
			 {
		     document.getElementById(this.parentNode.id).remove(); 
		     console.log(this.parentNode.children[0].innerText);
		     var item=document.getElementById(this.parentNode.id).children[0].innerText;
		     console.log(item);
		     var index = myarr.indexOf(item);
		     console.log(index);
		     myarr.splice(index, 1);
		     console.log(myarr);
		     arr = myarr;
		     });
    counter1++;
 }
  currentCustEmail = data.email;
 });
    counter++;
    document.getElementById("pop").style.display="none";
    custname1.value=null;
    custnum1.value=null;
    custemail1.value=null;
    custaddress1.value=null;
    arr.length=0;
}

function create(){
	console.log("length of name:"+custname1.value.length);


	if(custname1.value.trim().length==0){
		window.alert("Please enter the name")
		return false;
	}else if(custemail1.value.trim().length==0){
		window.alert("Please enter the email")
		return false;
	}	
	else{
		if(!(custemail1.value.match(mailformat)))  
		{ 
			window.alert("Please enter a valid email address");
			return false;
		}
	
	
	var jsobj = new Object();
	jsobj.name = custname1.value;
	jsobj.email = custemail1.value;
	jsobj.number= custnum1.value;
	jsobj.address= custaddress1.value;
	
	var jsonObj = JSON.stringify(jsobj);
	console.log(jsonObj);
	
	$.ajax({
		url:'/savecustomer',
		type:'POST',
		data:'data='+jsonObj,
		success:function(data){
			if(data=="failure"){
				alert("Customer id already exists");
				custPop.style.display="none";
				todo.style.display="none";			
			}
			else{				
				savecust(custname1.value, custnum1.value, custemail1.value, custaddress1.value, arr);
			}
		},
		failure:function(){			
		}	
	});	
	}
	}

function updateForm()
{
	if(custname2.value.trim().length==0){
		window.alert("Please enter the name to update")
		return false;
	}else if(custemail2.value.trim().length==0){
		window.alert("Please enter the email to update")
		return false;
	}	
	else{
		if(!(custemail2.value.match(mailformat)))  
		{ 
			window.alert("Please enter a valid email address");
			return false;
		}
    arr.length=0;
	var todoitems= todoUList.children; 
		for(var i=0;i<todoitems.length;i++)
		{
        arr[i]=todoitems[i].children[0].innerText;
        console.log(todoitems[i].children[0]);
        } 
    console.log("arr val"+arr);
	var jsObj = new Object();
	jsObj.name =custname2.value;
	jsObj.number=custnum2.value;
	jsObj.email =custemail2.value;
	jsObj.address=custaddress2.value;
	jsObj.currentCustEmail =currentCustEmail;
    jsObj.todoList =arr;
	var jsonObj = JSON.stringify(jsObj);
	
	$.ajax({
		url:'/UpdateCust',
		type:'post',
		data:'data='+jsonObj,
		success:function(data){
			console.log("data in response of update "+data)
			if((data=="updated")){
				var customerData = {"name":custname2.value,"number":  custnum2.value,"email":custemail2.value, "address": custaddress2.value,"todoList":arr};
				var cusData = JSON.stringify(customerData);
				localStorage.setItem(key1, cusData);				
				currentCustEmail = custemail2.value;				
				console.log("updated ");
			}			
		},
		failure:function(){
			
		}
	});
	}  
}

function addTodo()
{ if(custname2.value.trim().length==0){
	alert("Please choose the customer to update todo");
	 todoval.value="";
	return false;
}else{
	if(todoval.value.trim().length==0){
	return false;
}
}
    var list2= document.createElement("li");
	var lbl= document.createElement("label");
	list2.id="count1"+counter1;
	lbl.innerText=todoval.value;
	list2.appendChild(lbl);
	arr.push(todoval.value);
	var button2= document.createElement("button");
	var del2=document.createTextNode("done");
	button2.appendChild(del2);
	list2.appendChild(button2);
	var element2= document.getElementById("ulist2");
	element2.appendChild(list2);
	button2.addEventListener("click", function()
	{
    document.getElementById(this.parentNode.id).remove(); 
    console.log(this.parentNode.children[0].innerText);
    var item=document.getElementById(this.parentNode.id).children[0].innerText;
    console.log(item);
    var index = arr.indexOf(item);
    console.log(index);
    arr.splice(index, 1);
    console.log(arr);
    });
    counter1++;
    todoval.value="";
}

function showForm() 
{

document.getElementById("pop").style.display="block";
custname2.value = "";
custnum2.value= "";
custemail2.value= "";
custaddress2.value= "";
todoUList.innerHTML="";
}

$("#addbtn").click(function(){
    $("#pop").toggle();
});


