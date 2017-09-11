localStorage.clear();
var custname1= document.getElementById("name1");
var custnum1= document.getElementById("num1");
var custemail1= document.getElementById('email1');
var custaddress1=  document.getElementById('address1');
var custname2= document.getElementById("name2");
var custnum2= document.getElementById("num2");
var custemail2= document.getElementById('email2');
var custaddress2=  document.getElementById('address2');
var todoval= document.getElementById("add1");
var todoUList = document.getElementById("ulist2");
counter=1;
counter1=1;
counter2=0;
var key1;
var arr=[];

function savecust()
{
	var list = document.createElement("li");
	list.id="count"+counter;
    var input1= document.createElement("input");
    input1.type="checkbox";
    list.appendChild(input1);
    var listval = document.createElement("label");
	listval.innerText= custname1.value; 
	console.log(custname1.value);
    list.appendChild(listval);
    var button1= document.createElement("button");
    button1.id="b1";
    var del=document.createTextNode("delete");
    button1.appendChild(del);
    list.appendChild(button1);
    var element = document.getElementById("ulist");
    element.appendChild(list);
      button1.addEventListener("click", function()
      {
      document.getElementById(this.parentNode.id).style.display='none'; 
      localStorage.removeItem(this.parentNode.id);
      });
    var myCust = { "name": custname1.value , "number": custnum1.value , "email": custemail1.value, "addr": custaddress1.value};
    var myJSON = JSON.stringify(myCust);
    localStorage.setItem("count"+counter, myJSON);
 listval.addEventListener("click", function()
 {
    var details = localStorage.getItem(this.parentNode.id);
    Cust = JSON.parse(details);
    custname2.value = Cust.name;
    custnum2.value= Cust.number;
    custemail2.value= Cust.email;
    custaddress2.value= Cust.addr;
    console.log(Cust.name);
    console.log(arr);
    key1=document.getElementById(this.parentNode.id).id;
      console.log(key1);  
//to get the items which has been updated using updateform
    var details = localStorage.getItem(key1);
    Cust = JSON.parse(details);
    custname2.value = Cust.name;
    custnum2.value= Cust.number;
    custemail2.value= Cust.email;
    custaddress2.value= Cust.addr;
//to load todo list while clicking on custname
    var myarr=Cust.todolst;
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
     document.getElementById(this.parentNode.id).style.display='none'; 
     console.log(this.parentNode.children[0].innerText);
     var item=document.getElementById(this.parentNode.id).children[0].innerText;
     console.log(item);
     var index = arr.indexOf(item);
     console.log(index);
     arr.splice(index, 1);
     console.log(arr);
     });
    counter1++;
 }
 });
    counter++;
    document.getElementById("pop").style.display="none";
    custname1.value=null;
    custnum1.value=null;
    custemail1.value=null;
    custaddress1.value=null;    
}

function updateForm()
{
    arr.length=0;
	var todoitems= todoUList.children; 
		for(var i=0;i<todoitems.length;i++)
		{
        arr[i]=todoitems[i].children[0].innerText;
        console.log(todoitems[i].children[0]);
        } 
    console.log(arr);
    var myCust2 = { "name": custname2.value , "number": custnum2.value , "email": custemail2.value, "addr": custaddress2.value, "todolst" : arr};
    var myJSON2 = JSON.stringify(myCust2);
     console.log("key in "+key1);
    localStorage.setItem(key1, myJSON2);
    document.getElementById(key1).children[1].innerText=custname2.value; //to update the same updated value in customer list
    console.log(Cust.name);
    arr=[];
}

function addTodo()
{
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
    
}



function showForm() 
{
document.getElementById("pop").style.display="block";
}



