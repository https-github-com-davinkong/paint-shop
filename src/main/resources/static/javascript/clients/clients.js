//Cookie
const cookieArr = document.cookie.split("=")
const contractorsId = cookieArr[1];

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/clients'

// GET DOM ELEMENTS
const clientForm = document.getElementById('client-form')
const clientFirstName = document.getElementById('client-fName')
const clientLastName = document.getElementById('client-lName')


// POST a client
const handleSubmit = async (e) =>{
    e.preventDefault()
    let bodyObj = {
        firstName: clientFirstName.value,
        lastName: clientLastName.value,
    }
    const response = await fetch(`${baseUrl}/client`, {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))
//    const result = await response.json()
    if (response.status == 200){
        console.log("client added")
    }
    document.getElementById("client-fName").value = ''
    document.getElementById("client-lName").value = ''
}

clientForm.addEventListener("submit", handleSubmit)




//check Login user only
//if (contractorsId == null){
//    window.alert("You are not authorized to access this page...");
//    window.location.replace("http://localhost:8080/html/RegisterLogin/login.html");
//}

//check Admin access only
//async function getRoleById(contractorsId) {
//    await fetch(`${baseUrl}/checkRole/${contractorsId}`, {
//        method: "GET",
//        headers: headers
//    })
//        .then(response => response.json())
//        .then(data => {
//            if (data.toString().match("true") ){
//                console.log("admin")
//            }else{
//                console.log("contractor")
//                window.alert("You are not authorized to access this page...");
//                window.location.replace("http://localhost:8080/html/RegisterLogin/login.html");
//            }
//    })
//        .catch(err => console.error(err))
//
//
//}
//getRoleById(contractorsId).then();

//function handleLogout(){
//    let c = document.cookie.split(";");
//
//    for(let i in c){
//        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
//    }
//
//}


