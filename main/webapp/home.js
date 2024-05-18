
let slide1=document.getElementById("slide1")
let add=document.getElementById("add")
add.style.display="none"
let logout=document.getElementById("logout")
logout.style.display="none"


let click=true
slide1.addEventListener("click",()=>
{	
	if(click==true)
	{
		add.style.display="block"
		logout.style.display="block"
		click=false
	}	
	else
	{
		add.style.display="none"
		logout.style.display="none"
		click=true
	}
})


