//Cookie
const cookieArr = document.cookie.split("=")
const contractorsId = cookieArr[1];



const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/contractors'

//check Login user only
if (contractorsId == null){
    window.alert("You are not authorized to access this page...");
    window.location.replace("http://localhost:8080/html/RegisterLogin/login.html");
}
//check contractor access only
async function getRoleById(contractorsId) {
    await fetch(`${baseUrl}/checkRole/${contractorsId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => {
            if (data.toString().match("false") ){
                console.log("contractor")
            }else{
                window.alert("You are not authorized to access this page...");
                window.location.replace("http://localhost:8080/html/RegisterLogin/login.html");
            }
        })
        .catch(err => console.error(err))

}
getRoleById(contractorsId).then();


function handleLogout(){
    let c = document.cookie.split(";");

    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }

}




